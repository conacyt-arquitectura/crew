<template>
  <div>
    <h2 id="page-heading">
      <span v-text="$t('crewApp.plataforma.home.title')" id="plataforma-heading">Plataformas</span>
      <router-link
        :to="{ name: 'PlataformaCreate' }"
        tag="button"
        id="jh-create-entity"
        class="btn btn-primary float-right jh-create-entity create-plataforma"
      >
        <font-awesome-icon icon="plus"></font-awesome-icon>
        <span v-text="$t('crewApp.plataforma.home.createLabel')"> Create a new Plataforma </span>
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
    <div class="alert alert-warning" v-if="!isFetching && plataformas && plataformas.length === 0">
      <span v-text="$t('crewApp.plataforma.home.notFound')">No plataformas found</span>
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
      :items="plataformas"
      :fields="['logo', 'nombre', 'acciones']"
    >
      <template #table-busy>
        <div class="text-center text-danger my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Cargando...</strong>
        </div>
      </template>

      <template #cell(logo)="data">
        <a v-if="data.item.logo" v-on:click="openFile(data.item.logoContentType, data.item.logo)">
          <img v-bind:src="'data:' + data.item.logoContentType + ';base64,' + data.item.logo" style="max-height: 30px" alt="rol image" />
        </a>
      </template>
      <template #cell(acciones)="row">
        <c-action-buttons
          :params="{ plataformaId: row.item.id }"
          editView="PlataformaEdit"
          detailsView="PlataformaView"
          @onCancel="prepareRemove(row.item)"
        />
      </template>
    </b-table>
    <c-delete-modal id="removeEntity" @onDelete="removePlataforma()" />
    <div v-show="plataformas && plataformas.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./plataforma.component.ts">
</script>
