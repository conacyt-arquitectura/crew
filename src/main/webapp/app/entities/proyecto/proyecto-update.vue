<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="crewApp.proyecto.home.createOrEditLabel" v-text="$t('crewApp.proyecto.home.createOrEditLabel')">Create or edit a Proyecto</h2>
                <div>
                    <div class="form-group" v-if="proyecto.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="proyecto.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.proyecto.nombre')" for="proyecto-nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" id="proyecto-nombre"
                            :class="{'valid': !$v.proyecto.nombre.$invalid, 'invalid': $v.proyecto.nombre.$invalid }" v-model="$v.proyecto.nombre.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.proyecto.clave')" for="proyecto-clave">Clave</label>
                        <input type="text" class="form-control" name="clave" id="proyecto-clave"
                            :class="{'valid': !$v.proyecto.clave.$invalid, 'invalid': $v.proyecto.clave.$invalid }" v-model="$v.proyecto.clave.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.proyecto.logo')" for="proyecto-logo">Logo</label>
                        <div>
                            <img v-bind:src="'data:' + proyecto.logoContentType + ';base64,' + proyecto.logo" style="max-height: 100px;" v-if="proyecto.logo" alt="proyecto image"/>
                            <div v-if="proyecto.logo" class="form-text text-danger clearfix">
                                <span class="pull-left">{{proyecto.logoContentType}}, {{byteSize(proyecto.logo)}}</span>
                                <button type="button" v-on:click="clearInputImage('logo', 'logoContentType', 'file_logo')" class="btn btn-secondary btn-xs pull-right">
                                    <font-awesome-icon icon="times"></font-awesome-icon>
                                </button>
                            </div>
                            <input type="file" ref="file_logo" id="file_logo" v-on:change="setFileData($event, proyecto, 'logo', true)" accept="image/*" v-text="$t('entity.action.addimage')"/>
                        </div>
                        <input type="hidden" class="form-control" name="logo" id="proyecto-logo"
                            :class="{'valid': !$v.proyecto.logo.$invalid, 'invalid': $v.proyecto.logo.$invalid }" v-model="$v.proyecto.logo.$model" />
                        <input type="hidden" class="form-control" name="logoContentType" id="proyecto-logoContentType"
                            v-model="proyecto.logoContentType" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.proyecto.celula')" for="proyecto-celula">Celula</label>
                        <select class="form-control" id="proyecto-celula" name="celula" v-model="proyecto.celulaId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="celulaOption.id" v-for="celulaOption in celulas" :key="celulaOption.id">{{celulaOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.proyecto.plataforma')" for="proyecto-plataforma">Plataforma</label>
                        <select class="form-control" id="proyecto-plataforma" name="plataforma" v-model="proyecto.plataformaId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="plataformaOption.id" v-for="plataformaOption in plataformas" :key="plataformaOption.id">{{plataformaOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.proyecto.area')" for="proyecto-area">Area</label>
                        <select class="form-control" id="proyecto-area" name="area" v-model="proyecto.areaId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="areaOption.id" v-for="areaOption in areas" :key="areaOption.id">{{areaOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.proyecto.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./proyecto-update.component.ts">
</script>
