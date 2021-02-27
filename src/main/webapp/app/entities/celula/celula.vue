<template>
  <div>
    <h2 id="page-heading">
      <span v-text="$t('crewApp.celula.home.title')" id="celula-heading">Celulas</span>
      <router-link
        :to="{ name: 'CelulaCreate' }"
        tag="button"
        id="jh-create-entity"
        class="btn btn-primary float-right jh-create-entity create-celula"
      >
        <font-awesome-icon icon="plus"></font-awesome-icon>
        <span v-text="$t('crewApp.celula.home.createLabel')"> Create a new Celula </span>
      </router-link>
    </h2>
    <b-alert
      :show="dismissCountDown"
      dismissible
      :variant="alertType"
      @dismissed="dismissCountDown = 0"
      @dismiss-count-down="countDownChanged"
    >
      {{ alertMessage }}
    </b-alert>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && celulas && celulas.length === 0">
      <span v-text="$t('crewApp.celula.home.notFound')">No celulas found</span>
    </div>
    <b-table
      :striped="false"
      :borderless="true"
      :no-border-collapse="false"
      :busy="isFetching"
      :small="true"
      :hover="false"
      :fixed="false"
      head-variant="light"
      :items="celulas"
      :fields="['logo', 'nombre', 'acciones']"
    >
      <template #table-busy>
        <div class="text-center text-danger my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Cargando postulantes...</strong>
        </div>
      </template>

      <template #cell(logo)="data">
        <a>
          <b-avatar badge-variant="custom" badge-offset="-0.5em" size="lg">
            <template #badge>
              {{ data.item.plataformaClave | formatAvatarText }}
            </template>
          </b-avatar>
        </a>
        <b-avatar size="lg"></b-avatar>
      </template>

      <template #cell(acciones)="row">
        <c-action-buttons
          :params="{ celulaId: row.item.id }"
          editView="CelulaEdit"
          detailsView="CelulaView"
          @onCancel="prepareRemove(row.item)"
        />
      </template>
    </b-table>
    <c-delete-modal id="removeEntity" @onDelete="removeCelula()" />
  </div>
</template>

<script lang="ts" src="./celula.component.ts">
</script>
