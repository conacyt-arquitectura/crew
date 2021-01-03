<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('crewApp.proyecto.home.title')" id="proyecto-heading">Proyectos</span>
            <router-link :to="{name: 'ProyectoCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-proyecto">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('crewApp.proyecto.home.createLabel')">
                    Create a new Proyecto
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
        <div class="alert alert-warning" v-if="!isFetching && proyectos && proyectos.length === 0">
            <span v-text="$t('crewApp.proyecto.home.notFound')">No proyectos found</span>
        </div>
        <div class="table-responsive" v-if="proyectos && proyectos.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('nombre')"><span v-text="$t('crewApp.proyecto.nombre')">Nombre</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nombre'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('clave')"><span v-text="$t('crewApp.proyecto.clave')">Clave</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'clave'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('logo')"><span v-text="$t('crewApp.proyecto.logo')">Logo</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'logo'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('celulaId')"><span v-text="$t('crewApp.proyecto.celula')">Celula</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'celulaId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('plataformaId')"><span v-text="$t('crewApp.proyecto.plataforma')">Plataforma</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'plataformaId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('areaId')"><span v-text="$t('crewApp.proyecto.area')">Area</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="proyecto in proyectos"
                    :key="proyecto.id">
                    <td>
                        <router-link :to="{name: 'ProyectoView', params: {proyectoId: proyecto.id}}">{{proyecto.id}}</router-link>
                    </td>
                    <td>{{proyecto.nombre}}</td>
                    <td>{{proyecto.clave}}</td>
                    <td>
                        <a v-if="proyecto.logo" v-on:click="openFile(proyecto.logoContentType, proyecto.logo)">
                            <img v-bind:src="'data:' + proyecto.logoContentType + ';base64,' + proyecto.logo" style="max-height: 30px;" alt="proyecto image"/>
                        </a>
                        <span v-if="proyecto.logo">{{proyecto.logoContentType}}, {{byteSize(proyecto.logo)}}</span>
                    </td>
                    <td>
                        <div v-if="proyecto.celulaId">
                            <router-link :to="{name: 'CelulaView', params: {celulaId: proyecto.celulaId}}">{{proyecto.celulaId}}</router-link>
                        </div>
                    </td>
                    <td>
                        <div v-if="proyecto.plataformaId">
                            <router-link :to="{name: 'PlataformaView', params: {plataformaId: proyecto.plataformaId}}">{{proyecto.plataformaId}}</router-link>
                        </div>
                    </td>
                    <td>
                        <div v-if="proyecto.areaId">
                            <router-link :to="{name: 'AreaView', params: {areaId: proyecto.areaId}}">{{proyecto.areaId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'ProyectoView', params: {proyectoId: proyecto.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'ProyectoEdit', params: {proyectoId: proyecto.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(proyecto)"
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
            <span slot="modal-title"><span id="crewApp.proyecto.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-proyecto-heading" v-text="$t('crewApp.proyecto.delete.question', {'id': removeId})">Are you sure you want to delete this Proyecto?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-proyecto" v-text="$t('entity.action.delete')" v-on:click="removeProyecto()">Delete</button>
            </div>
        </b-modal>
    </div>
</template>

<script lang="ts" src="./proyecto.component.ts">
</script>
