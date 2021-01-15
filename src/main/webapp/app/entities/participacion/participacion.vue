<template>
  <div>
    <h2 id="page-heading">
      <span v-text="$t('crewApp.participacion.home.title')" id="participacion-heading">Participacions</span>
      <router-link
        :to="{ name: 'ParticipacionCreate' }"
        tag="button"
        id="jh-create-entity"
        class="btn btn-primary float-right jh-create-entity create-participacion"
      >
        <font-awesome-icon icon="plus"></font-awesome-icon>
        <span v-text="$t('crewApp.participacion.home.createLabel')"> Create a new Participacion </span>
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
    <div class="alert alert-warning" v-if="!isFetching && participacions && participacions.length === 0">
      <span v-text="$t('crewApp.participacion.home.notFound')">No participacions found</span>
    </div>
    <div>
      <div class="form-group">
        <label class="form-control-label" v-text="$t('crewApp.participacion.celula')" for="participacion-celula">celula</label>
        <b-form-select @change="retrieveAllParticipacions()" value-field="id" text-field="nombre" v-model="celulaId" :options="celulas">
        </b-form-select>
        </select>
      </div>
    </div>
    <b-table
      :striped="false"
      :borderless="true"
      :no-border-collapse="false"
      :busy="isFetching"
      :small="true"
      :hover="false"
      :fixed="true"
      head-variant="light"
      :items="participacions"
      :fields="['participante', 'rol', 'acciones']"
    >
      <template #table-busy>
        <div class="text-center text-danger my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Cargando...</strong>
        </div>
      </template>
      <template #cell(acciones)="row">
        <c-action-buttons
          :params="{ participacionId: row.item.id }"
          editView="ParticipacionEdit"
          detailsView="ParticipacionView"
          @onCancel="prepareRemove(row.item)"
        />
      </template>
    </b-table>
    <c-delete-modal id="removeEntity" @onDelete="removeParticipacion()" />
    <div v-show="participacions && participacions.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./participacion.component.ts">
</script>
