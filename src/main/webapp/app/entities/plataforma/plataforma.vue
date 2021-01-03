<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('crewApp.plataforma.home.title')" id="plataforma-heading">Plataformas</span>
            <router-link :to="{name: 'PlataformaCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-plataforma">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('crewApp.plataforma.home.createLabel')">
                    Create a new Plataforma
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
        <div class="alert alert-warning" v-if="!isFetching && plataformas && plataformas.length === 0">
            <span v-text="$t('crewApp.plataforma.home.notFound')">No plataformas found</span>
        </div>
        <div class="table-responsive" v-if="plataformas && plataformas.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('nombre')"><span v-text="$t('crewApp.plataforma.nombre')">Nombre</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nombre'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('color')"><span v-text="$t('crewApp.plataforma.color')">Color</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'color'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('logo')"><span v-text="$t('crewApp.plataforma.logo')">Logo</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'logo'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="plataforma in plataformas"
                    :key="plataforma.id">
                    <td>
                        <router-link :to="{name: 'PlataformaView', params: {plataformaId: plataforma.id}}">{{plataforma.id}}</router-link>
                    </td>
                    <td>{{plataforma.nombre}}</td>
                    <td>{{plataforma.color}}</td>
                    <td>
                        <a v-if="plataforma.logo" v-on:click="openFile(plataforma.logoContentType, plataforma.logo)">
                            <img v-bind:src="'data:' + plataforma.logoContentType + ';base64,' + plataforma.logo" style="max-height: 30px;" alt="plataforma image"/>
                        </a>
                        <span v-if="plataforma.logo">{{plataforma.logoContentType}}, {{byteSize(plataforma.logo)}}</span>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'PlataformaView', params: {plataformaId: plataforma.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'PlataformaEdit', params: {plataformaId: plataforma.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(plataforma)"
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
            <span slot="modal-title"><span id="crewApp.plataforma.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-plataforma-heading" v-text="$t('crewApp.plataforma.delete.question', {'id': removeId})">Are you sure you want to delete this Plataforma?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-plataforma" v-text="$t('entity.action.delete')" v-on:click="removePlataforma()">Delete</button>
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
