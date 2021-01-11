<template>
  <div>
    <h2 id="page-heading">
      <span v-text="$t('crewApp.rol.home.title')" id="rol-heading">Rols</span>
      <router-link
        :to="{ name: 'RolCreate' }"
        tag="button"
        id="jh-create-entity"
        class="btn btn-primary float-right jh-create-entity create-rol"
      >
        <font-awesome-icon icon="plus"></font-awesome-icon>
        <span v-text="$t('crewApp.rol.home.createLabel')"> Create a new Rol </span>
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
    <div class="alert alert-warning" v-if="!isFetching && rols && rols.length === 0">
      <span v-text="$t('crewApp.rol.home.notFound')">No rols found</span>
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
      :items="rols"
      :fields="['logo', 'nombre', 'clave', 'acciones']"
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
        <div class="btn-group">
          <router-link :to="{ name: 'RolView', params: { rolId: row.item.id } }" tag="button" class="btn btn-outline-info btn-sm details">
            <font-awesome-icon icon="eye"></font-awesome-icon>
          </router-link>
          <router-link :to="{ name: 'RolEdit', params: { rolId: row.item.id } }" tag="button" class="btn btn-outline-primary btn-sm edit">
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
        ><span id="crewApp.rol.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-rol-heading" v-text="$t('crewApp.rol.delete.question', { id: removeId })">
          Are you sure you want to delete this Rol?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-rol"
          v-text="$t('entity.action.delete')"
          v-on:click="removeRol()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="rols && rols.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./rol.component.ts">
</script>
