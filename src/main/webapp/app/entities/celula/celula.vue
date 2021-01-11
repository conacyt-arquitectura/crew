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
          <strong>Cargando...</strong>
        </div>
      </template>

      <template #cell(logo)="data">
        <a v-if="data.item.logo">
          <b-avatar
            badge-variant="custom"
            badge-offset="-0.5em"
            :style="{ 'background-color': data.item.plataformaColor }"
            v-bind:src="'data:' + data.item.logoContentType + ';base64,' + data.item.logo"
            size="lg"
          >
            <template #badge>
              {{ data.item.plataformaClave | formatAvatarText }}
            </template>
          </b-avatar>
        </a>
        <b-avatar
          v-else
          :text="data.item.plataformaClave | formatAvatarText"
          :style="{ 'background-color': data.item.plataformaColor }"
          size="lg"
        ></b-avatar>
      </template>

      <template #cell(acciones)="row">
        <div class="btn-group">
          <router-link
            :to="{ name: 'CelulaView', params: { celulaId: row.item.id } }"
            tag="button"
            class="btn btn-outline-info btn-sm details"
          >
            <font-awesome-icon icon="eye"></font-awesome-icon>
          </router-link>
          <router-link
            :to="{ name: 'CelulaEdit', params: { celulaId: row.item.id } }"
            tag="button"
            class="btn btn-outline-primary btn-sm edit"
          >
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
          </router-link>
          <b-button v-on:click="prepareRemove(row.item)" variant="outline-danger" class="btn btn-sm" v-b-modal.removeEntity>
            <font-awesome-icon icon="times"></font-awesome-icon>
          </b-button>
        </div>
      </template>
    </b-table>

    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="crewApp.celula.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-celula-heading" v-text="$t('crewApp.celula.delete.question', { id: removeId })">
          Are you sure you want to delete this Celula?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-celula"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCelula()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./celula.component.ts">
</script>
