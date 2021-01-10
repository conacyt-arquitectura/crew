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
      :fields="['color', 'nombre', 'acciones']"
    >
      <template #table-busy>
        <div class="text-center text-danger my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Cargando...</strong>
        </div>
      </template>

      <template #cell(color)="data">
        <b-avatar :text="data.item.nombre | formatAvatarText" :style="{ 'background-color': data.item.color }" size="sm"></b-avatar>
      </template>

      <template #cell(acciones)="row">
        <div class="btn-group">
          <router-link
            :to="{ name: 'PlataformaView', params: { plataformaId: row.item.id } }"
            tag="button"
            class="btn btn-outline-info btn-sm details"
          >
            <font-awesome-icon icon="eye"></font-awesome-icon>
          </router-link>
          <router-link
            :to="{ name: 'PlataformaEdit', params: { plataformaId: row.item.id } }"
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
        ><span id="crewApp.plataforma.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-plataforma-heading" v-text="$t('crewApp.plataforma.delete.question', { id: removeId })">
          Are you sure you want to delete this Plataforma?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-plataforma"
          v-text="$t('entity.action.delete')"
          v-on:click="removePlataforma()"
        >
          Delete
        </button>
      </div>
    </b-modal>
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
