<template>
  <div>
    <h2 id="page-heading">
      <span v-text="$t('crewApp.badge.home.title')" id="badge-heading">Badges</span>
      <router-link
        :to="{ name: 'BadgeCreate' }"
        tag="button"
        id="jh-create-entity"
        class="btn btn-primary float-right jh-create-entity create-badge"
      >
        <font-awesome-icon icon="plus"></font-awesome-icon>
        <span v-text="$t('crewApp.badge.home.createLabel')"> Create a new Badge </span>
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
    <div class="alert alert-warning" v-if="!isFetching && badges && badges.length === 0">
      <span v-text="$t('crewApp.badge.home.notFound')">No badges found</span>
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
      :items="badges"
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
          :params="{ badgeId: row.item.id }"
          editView="BadgeEdit"
          detailsView="BadgeView"
          @onCancel="prepareRemove(row.item)"
        />
      </template>
    </b-table>
    <c-delete-modal id="removeEntity" @onDelete="removeBadge()" />
  </div>
</template>

<script lang="ts" src="./badge.component.ts">
</script>
