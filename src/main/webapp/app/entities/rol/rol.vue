<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('crewApp.rol.home.title')" id="rol-heading">Rols</span>
            <router-link :to="{name: 'RolCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-rol">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('crewApp.rol.home.createLabel')">
                    Create a new Rol
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
        <div class="alert alert-warning" v-if="!isFetching && rols && rols.length === 0">
            <span v-text="$t('crewApp.rol.home.notFound')">No rols found</span>
        </div>
        <div class="table-responsive" v-if="rols && rols.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('nombre')"><span v-text="$t('crewApp.rol.nombre')">Nombre</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nombre'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('clave')"><span v-text="$t('crewApp.rol.clave')">Clave</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'clave'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('logo')"><span v-text="$t('crewApp.rol.logo')">Logo</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'logo'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="rol in rols"
                    :key="rol.id">
                    <td>
                        <router-link :to="{name: 'RolView', params: {rolId: rol.id}}">{{rol.id}}</router-link>
                    </td>
                    <td>{{rol.nombre}}</td>
                    <td>{{rol.clave}}</td>
                    <td>
                        <a v-if="rol.logo" v-on:click="openFile(rol.logoContentType, rol.logo)">
                            <img v-bind:src="'data:' + rol.logoContentType + ';base64,' + rol.logo" style="max-height: 30px;" alt="rol image"/>
                        </a>
                        <span v-if="rol.logo">{{rol.logoContentType}}, {{byteSize(rol.logo)}}</span>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'RolView', params: {rolId: rol.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'RolEdit', params: {rolId: rol.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(rol)"
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
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="crewApp.rol.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-rol-heading" v-text="$t('crewApp.rol.delete.question', {'id': removeId})">Are you sure you want to delete this Rol?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-rol" v-text="$t('entity.action.delete')" v-on:click="removeRol()">Delete</button>
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
