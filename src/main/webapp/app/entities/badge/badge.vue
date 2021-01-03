<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('crewApp.badge.home.title')" id="badge-heading">Badges</span>
            <router-link :to="{name: 'BadgeCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-badge">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('crewApp.badge.home.createLabel')">
                    Create a new Badge
                </span>
            </router-link>
        </h2>
        <b-alert :show="dismissCountDown"
            dismissible
            :variant="alertType"
            @dismissed="dismissCountDown=0"
            @dismiss-count-down="countDownChanged">
            {{alertMessage}}
        </b-alert>
        <br/>
        <div class="alert alert-warning" v-if="!isFetching && badges && badges.length === 0">
            <span v-text="$t('crewApp.badge.home.notFound')">No badges found</span>
        </div>
        <div class="table-responsive" v-if="badges && badges.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('nombre')"><span v-text="$t('crewApp.badge.nombre')">Nombre</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nombre'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('descripcion')"><span v-text="$t('crewApp.badge.descripcion')">Descripcion</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'descripcion'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('logo')"><span v-text="$t('crewApp.badge.logo')">Logo</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'logo'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="badge in badges"
                    :key="badge.id">
                    <td>
                        <router-link :to="{name: 'BadgeView', params: {badgeId: badge.id}}">{{badge.id}}</router-link>
                    </td>
                    <td>{{badge.nombre}}</td>
                    <td>{{badge.descripcion}}</td>
                    <td>
                        <a v-if="badge.logo" v-on:click="openFile(badge.logoContentType, badge.logo)">
                            <img v-bind:src="'data:' + badge.logoContentType + ';base64,' + badge.logo" style="max-height: 30px;" alt="badge image"/>
                        </a>
                        <span v-if="badge.logo">{{badge.logoContentType}}, {{byteSize(badge.logo)}}</span>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'BadgeView', params: {badgeId: badge.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'BadgeEdit', params: {badgeId: badge.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(badge)"
                                   variant="danger"
                                   class="btn btn-sm"
                                   v-b-modal.removeEntity>
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
                    :distance='20'>
                </infinite-loading>
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="crewApp.badge.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-badge-heading" v-text="$t('crewApp.badge.delete.question', {'id': removeId})">Are you sure you want to delete this Badge?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-badge" v-text="$t('entity.action.delete')" v-on:click="removeBadge()">Delete</button>
            </div>
        </b-modal>
    </div>
</template>

<script lang="ts" src="./badge.component.ts">
</script>
