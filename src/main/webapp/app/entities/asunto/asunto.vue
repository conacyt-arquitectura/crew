<template>
  <div>
    <h2 id="page-heading">
      <span v-text="$t('crewApp.asunto.home.title')" id="asunto-heading">Asuntos</span>
      <router-link
        :to="{ name: 'AsuntoCreate' }"
        tag="button"
        id="jh-create-entity"
        class="btn btn-primary float-right jh-create-entity create-asunto"
      >
        <font-awesome-icon icon="plus"></font-awesome-icon>
        <span v-text="$t('crewApp.asunto.home.createLabel')"> Create a new Asunto </span>
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
    <div class="alert alert-warning" v-if="!isFetching && asuntos && asuntos.length === 0">
      <span v-text="$t('crewApp.asunto.home.notFound')">No asuntos found</span>
    </div>
    <div class="table-responsive" v-if="asuntos && asuntos.length > 0">
      <table class="table table-striped">
        <thead>
          <tr>
            <th v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th v-on:click="changeOrder('nombre')">
              <span v-text="$t('crewApp.asunto.nombre')">Nombre</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nombre'"></jhi-sort-indicator>
            </th>
            <th v-on:click="changeOrder('clave')">
              <span v-text="$t('crewApp.asunto.clave')">Clave</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'clave'"></jhi-sort-indicator>
            </th>
            <th v-on:click="changeOrder('logo')">
              <span v-text="$t('crewApp.asunto.logo')">Logo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'logo'"></jhi-sort-indicator>
            </th>
            <th v-on:click="changeOrder('celulaId')">
              <span v-text="$t('crewApp.asunto.celula')">Celula</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'celulaId'"></jhi-sort-indicator>
            </th>
            <th v-on:click="changeOrder('plataformaId')">
              <span v-text="$t('crewApp.asunto.plataforma')">Plataforma</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'plataformaId'"></jhi-sort-indicator>
            </th>
            <th v-on:click="changeOrder('areaId')">
              <span v-text="$t('crewApp.asunto.area')">Area</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaId'"></jhi-sort-indicator>
            </th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="asunto in asuntos" :key="asunto.id">
            <td>
              <router-link :to="{ name: 'AsuntoView', params: { asuntoId: asunto.id } }">{{ asunto.id }}</router-link>
            </td>
            <td>{{ asunto.nombre }}</td>
            <td>{{ asunto.clave }}</td>
            <td>
              <a v-if="asunto.logo" v-on:click="openFile(asunto.logoContentType, asunto.logo)">
                <img v-bind:src="'data:' + asunto.logoContentType + ';base64,' + asunto.logo" style="max-height: 30px" alt="asunto image" />
              </a>
              <span v-if="asunto.logo">{{ asunto.logoContentType }}, {{ byteSize(asunto.logo) }}</span>
            </td>
            <td>
              <div v-if="asunto.celulaId">
                <router-link :to="{ name: 'CelulaView', params: { celulaId: asunto.celulaId } }">{{ asunto.celulaId }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="asunto.plataformaId">
                <router-link :to="{ name: 'PlataformaView', params: { plataformaId: asunto.plataformaId } }">{{
                  asunto.plataformaId
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="asunto.areaId">
                <router-link :to="{ name: 'AreaView', params: { areaId: asunto.areaId } }">{{ asunto.areaId }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'AsuntoView', params: { asuntoId: asunto.id } }" tag="button" class="btn btn-info btn-sm details">
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
                <router-link :to="{ name: 'AsuntoEdit', params: { asuntoId: asunto.id } }" tag="button" class="btn btn-primary btn-sm edit">
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                </router-link>
                <b-button v-on:click="prepareRemove(asunto)" variant="danger" class="btn btn-sm" v-b-modal.removeEntity>
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
        <infinite-loading
          ref="infiniteLoading"
          v-if="totalItems > itemsPerPage"
          :identifier="infiniteId"
          slot="append"
          @infinite="loadMore"
          force-use-infinite-wrapper=".el-table__body-wrapper"
          :distance="20"
        >
        </infinite-loading>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="crewApp.asunto.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-asunto-heading" v-text="$t('crewApp.asunto.delete.question', { id: removeId })">
          Are you sure you want to delete this Asunto?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-asunto"
          v-text="$t('entity.action.delete')"
          v-on:click="removeAsunto()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./asunto.component.ts">
</script>
