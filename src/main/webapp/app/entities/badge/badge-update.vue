<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="crewApp.badge.home.createOrEditLabel" v-text="$t('crewApp.badge.home.createOrEditLabel')">Create or edit a Badge</h2>
                <div>
                    <div class="form-group" v-if="badge.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="badge.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.badge.nombre')" for="badge-nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" id="badge-nombre"
                            :class="{'valid': !$v.badge.nombre.$invalid, 'invalid': $v.badge.nombre.$invalid }" v-model="$v.badge.nombre.$model"  required/>
                        <div v-if="$v.badge.nombre.$anyDirty && $v.badge.nombre.$invalid">
                            <small class="form-text text-danger" v-if="!$v.badge.nombre.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.badge.descripcion')" for="badge-descripcion">Descripcion</label>
                        <textarea class="form-control" name="descripcion" id="badge-descripcion"
                            :class="{'valid': !$v.badge.descripcion.$invalid, 'invalid': $v.badge.descripcion.$invalid }" v-model="$v.badge.descripcion.$model"  required></textarea>
                        <div v-if="$v.badge.descripcion.$anyDirty && $v.badge.descripcion.$invalid">
                            <small class="form-text text-danger" v-if="!$v.badge.descripcion.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.badge.logo')" for="badge-logo">Logo</label>
                        <div>
                            <img v-bind:src="'data:' + badge.logoContentType + ';base64,' + badge.logo" style="max-height: 100px;" v-if="badge.logo" alt="badge image"/>
                            <div v-if="badge.logo" class="form-text text-danger clearfix">
                                <span class="pull-left">{{badge.logoContentType}}, {{byteSize(badge.logo)}}</span>
                                <button type="button" v-on:click="clearInputImage('logo', 'logoContentType', 'file_logo')" class="btn btn-secondary btn-xs pull-right">
                                    <font-awesome-icon icon="times"></font-awesome-icon>
                                </button>
                            </div>
                            <input type="file" ref="file_logo" id="file_logo" v-on:change="setFileData($event, badge, 'logo', true)" accept="image/*" v-text="$t('entity.action.addimage')"/>
                        </div>
                        <input type="hidden" class="form-control" name="logo" id="badge-logo"
                            :class="{'valid': !$v.badge.logo.$invalid, 'invalid': $v.badge.logo.$invalid }" v-model="$v.badge.logo.$model" />
                        <input type="hidden" class="form-control" name="logoContentType" id="badge-logoContentType"
                            v-model="badge.logoContentType" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.badge.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./badge-update.component.ts">
</script>
