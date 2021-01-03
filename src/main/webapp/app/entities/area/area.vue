<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('crewApp.area.home.title')" id="area-heading">Areas</span>
            <router-link :to="{name: 'AreaCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-area">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('crewApp.area.home.createLabel')">
                    Create a new Area
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
        <div class="alert alert-warning" v-if="!isFetching && areas && areas.length === 0">
            <span v-text="$t('crewApp.area.home.notFound')">No areas found</span>
        </div>
        <div class="table-responsive" v-if="areas && areas.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('nombre')"><span v-text="$t('crewApp.area.nombre')">Nombre</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nombre'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('responsable')"><span v-text="$t('crewApp.area.responsable')">Responsable</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'responsable'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('correo')"><span v-text="$t('crewApp.area.correo')">Correo</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'correo'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('areaId')"><span v-text="$t('crewApp.area.area')">Area</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="area in areas"
                    :key="area.id">
                    <td>
                        <router-link :to="{name: 'AreaView', params: {areaId: area.id}}">{{area.id}}</router-link>
                    </td>
                    <td>{{area.nombre}}</td>
                    <td>{{area.responsable}}</td>
                    <td>{{area.correo}}</td>
                    <td>
                        <div v-if="area.areaId">
                            <router-link :to="{name: 'AreaView', params: {areaId: area.areaId}}">{{area.areaId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'AreaView', params: {areaId: area.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'AreaEdit', params: {areaId: area.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(area)"
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
            <span slot="modal-title"><span id="crewApp.area.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-area-heading" v-text="$t('crewApp.area.delete.question', {'id': removeId})">Are you sure you want to delete this Area?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-area" v-text="$t('entity.action.delete')" v-on:click="removeArea()">Delete</button>
            </div>
        </b-modal>
        <div v-show="areas && areas.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./area.component.ts">
</script>
