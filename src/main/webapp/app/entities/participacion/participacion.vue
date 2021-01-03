<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('crewApp.participacion.home.title')" id="participacion-heading">Participacions</span>
            <router-link :to="{name: 'ParticipacionCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-participacion">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('crewApp.participacion.home.createLabel')">
                    Create a new Participacion
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
        <div class="alert alert-warning" v-if="!isFetching && participacions && participacions.length === 0">
            <span v-text="$t('crewApp.participacion.home.notFound')">No participacions found</span>
        </div>
        <div class="table-responsive" v-if="participacions && participacions.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('personaId')"><span v-text="$t('crewApp.participacion.persona')">Persona</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'personaId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('rolId')"><span v-text="$t('crewApp.participacion.rol')">Rol</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rolId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="participacion in participacions"
                    :key="participacion.id">
                    <td>
                        <router-link :to="{name: 'ParticipacionView', params: {participacionId: participacion.id}}">{{participacion.id}}</router-link>
                    </td>
                    <td>
                        <div v-if="participacion.personaId">
                            <router-link :to="{name: 'PersonaView', params: {personaId: participacion.personaId}}">{{participacion.personaId}}</router-link>
                        </div>
                    </td>
                    <td>
                        <div v-if="participacion.rolId">
                            <router-link :to="{name: 'RolView', params: {rolId: participacion.rolId}}">{{participacion.rolId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'ParticipacionView', params: {participacionId: participacion.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'ParticipacionEdit', params: {participacionId: participacion.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(participacion)"
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
            <span slot="modal-title"><span id="crewApp.participacion.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-participacion-heading" v-text="$t('crewApp.participacion.delete.question', {'id': removeId})">Are you sure you want to delete this Participacion?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-participacion" v-text="$t('entity.action.delete')" v-on:click="removeParticipacion()">Delete</button>
            </div>
        </b-modal>
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
