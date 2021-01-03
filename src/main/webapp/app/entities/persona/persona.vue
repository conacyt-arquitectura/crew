<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('crewApp.persona.home.title')" id="persona-heading">Personas</span>
            <router-link :to="{name: 'PersonaCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-persona">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('crewApp.persona.home.createLabel')">
                    Create a new Persona
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
        <div class="alert alert-warning" v-if="!isFetching && personas && personas.length === 0">
            <span v-text="$t('crewApp.persona.home.notFound')">No personas found</span>
        </div>
        <div class="table-responsive" v-if="personas && personas.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('nombre')"><span v-text="$t('crewApp.persona.nombre')">Nombre</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nombre'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('primerApellido')"><span v-text="$t('crewApp.persona.primerApellido')">Primer Apellido</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'primerApellido'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('segundoApellido')"><span v-text="$t('crewApp.persona.segundoApellido')">Segundo Apellido</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'segundoApellido'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('correo')"><span v-text="$t('crewApp.persona.correo')">Correo</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'correo'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('resumen')"><span v-text="$t('crewApp.persona.resumen')">Resumen</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resumen'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('imagen')"><span v-text="$t('crewApp.persona.imagen')">Imagen</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'imagen'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('avatarId')"><span v-text="$t('crewApp.persona.avatar')">Avatar</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'avatarId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('areaId')"><span v-text="$t('crewApp.persona.area')">Area</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'areaId'"></jhi-sort-indicator></th>
                    <th v-on:click="changeOrder('badgesId')"><span v-text="$t('crewApp.persona.badges')">Badges</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'badgesId'"></jhi-sort-indicator></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="persona in personas"
                    :key="persona.id">
                    <td>
                        <router-link :to="{name: 'PersonaView', params: {personaId: persona.id}}">{{persona.id}}</router-link>
                    </td>
                    <td>{{persona.nombre}}</td>
                    <td>{{persona.primerApellido}}</td>
                    <td>{{persona.segundoApellido}}</td>
                    <td>{{persona.correo}}</td>
                    <td>{{persona.resumen}}</td>
                    <td>
                        <a v-if="persona.imagen" v-on:click="openFile(persona.imagenContentType, persona.imagen)">
                            <img v-bind:src="'data:' + persona.imagenContentType + ';base64,' + persona.imagen" style="max-height: 30px;" alt="persona image"/>
                        </a>
                        <span v-if="persona.imagen">{{persona.imagenContentType}}, {{byteSize(persona.imagen)}}</span>
                    </td>
                    <td>
                        <div v-if="persona.avatarId">
                            <router-link :to="{name: 'AvatarView', params: {avatarId: persona.avatarId}}">{{persona.avatarId}}</router-link>
                        </div>
                    </td>
                    <td>
                        <div v-if="persona.areaId">
                            <router-link :to="{name: 'AreaView', params: {areaId: persona.areaId}}">{{persona.areaId}}</router-link>
                        </div>
                    </td>
                    <td>
                        <div v-if="persona.badgesId">
                            <router-link :to="{name: 'BadgeView', params: {badgeId: persona.badgesId}}">{{persona.badgesId}}</router-link>
                        </div>
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'PersonaView', params: {personaId: persona.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'PersonaEdit', params: {personaId: persona.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(persona)"
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
            <span slot="modal-title"><span id="crewApp.persona.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-persona-heading" v-text="$t('crewApp.persona.delete.question', {'id': removeId})">Are you sure you want to delete this Persona?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-persona" v-text="$t('entity.action.delete')" v-on:click="removePersona()">Delete</button>
            </div>
        </b-modal>
    </div>
</template>

<script lang="ts" src="./persona.component.ts">
</script>
