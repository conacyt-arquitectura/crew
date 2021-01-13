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
        <c-action-buttons :params="{ rolId: row.item.id }" editView="RolEdit" detailsView="RolView" @onCancel="prepareRemove(row.item)" />
      </template>
    </b-table>
    <c-delete-modal id="removeEntity" @onDelete="removeRol()" />
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
