<template>
  <div>
    <h2 id="page-heading">
      <span v-text="$t('crewApp.area.home.title')" id="area-heading">Areas</span>
      <router-link
        :to="{ name: 'AreaCreate' }"
        tag="button"
        id="jh-create-entity"
        class="btn btn-primary float-right jh-create-entity create-area"
      >
        <font-awesome-icon icon="plus"></font-awesome-icon>
        <span v-text="$t('crewApp.area.home.createLabel')"> Create a new Area </span>
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
    <div class="alert alert-warning" v-if="!isFetching && areas && areas.length === 0">
      <span v-text="$t('crewApp.area.home.notFound')">No areas found</span>
    </div>
    <b-table
      :striped="true"
      :borderless="false"
      :no-border-collapse="true"
      :busy="isFetching"
      :small="true"
      :hover="false"
      :fixed="false"
      head-variant="light"
      sticky-header
      :items="areas"
      :fields="['nombre', 'responsable', 'acciones']"
    >
      <template #table-busy>
        <div class="text-center text-danger my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Cargando...</strong>
        </div>
      </template>
      <template #cell(acciones)="row">
        <div class="btn-group">
          <router-link :to="{ name: 'AreaView', params: { areaId: row.item.id } }" tag="button" class="btn btn-outline-info btn-sm details">
            <font-awesome-icon icon="eye"></font-awesome-icon>
          </router-link>
          <router-link :to="{ name: 'AreaEdit', params: { areaId: row.item.id } }" tag="button" class="btn btn-outline-primary btn-sm edit">
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
        ><span id="crewApp.area.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-area-heading" v-text="$t('crewApp.area.delete.question', { id: removeId })">
          Are you sure you want to delete this Area?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-area"
          v-text="$t('entity.action.delete')"
          v-on:click="removeArea()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="areas && areas.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination
          pills
          size="sm"
          :total-rows="totalItems"
          v-model="page"
          :per-page="itemsPerPage"
          :change="loadPage(page)"
        ></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./area.component.ts">
</script>
