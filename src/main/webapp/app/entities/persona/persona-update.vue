<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="crewApp.persona.home.createOrEditLabel" v-text="$t('crewApp.persona.home.createOrEditLabel')">Create or edit a Persona</h2>
                <div>
                    <div class="form-group" v-if="persona.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="persona.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.nombre')" for="persona-nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" id="persona-nombre"
                            :class="{'valid': !$v.persona.nombre.$invalid, 'invalid': $v.persona.nombre.$invalid }" v-model="$v.persona.nombre.$model"  required/>
                        <div v-if="$v.persona.nombre.$anyDirty && $v.persona.nombre.$invalid">
                            <small class="form-text text-danger" v-if="!$v.persona.nombre.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.primerApellido')" for="persona-primerApellido">Primer Apellido</label>
                        <input type="text" class="form-control" name="primerApellido" id="persona-primerApellido"
                            :class="{'valid': !$v.persona.primerApellido.$invalid, 'invalid': $v.persona.primerApellido.$invalid }" v-model="$v.persona.primerApellido.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.segundoApellido')" for="persona-segundoApellido">Segundo Apellido</label>
                        <input type="text" class="form-control" name="segundoApellido" id="persona-segundoApellido"
                            :class="{'valid': !$v.persona.segundoApellido.$invalid, 'invalid': $v.persona.segundoApellido.$invalid }" v-model="$v.persona.segundoApellido.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.correo')" for="persona-correo">Correo</label>
                        <input type="text" class="form-control" name="correo" id="persona-correo"
                            :class="{'valid': !$v.persona.correo.$invalid, 'invalid': $v.persona.correo.$invalid }" v-model="$v.persona.correo.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.resumen')" for="persona-resumen">Resumen</label>
                        <textarea class="form-control" name="resumen" id="persona-resumen"
                            :class="{'valid': !$v.persona.resumen.$invalid, 'invalid': $v.persona.resumen.$invalid }" v-model="$v.persona.resumen.$model" ></textarea>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.imagen')" for="persona-imagen">Imagen</label>
                        <div>
                            <img v-bind:src="'data:' + persona.imagenContentType + ';base64,' + persona.imagen" style="max-height: 100px;" v-if="persona.imagen" alt="persona image"/>
                            <div v-if="persona.imagen" class="form-text text-danger clearfix">
                                <span class="pull-left">{{persona.imagenContentType}}, {{byteSize(persona.imagen)}}</span>
                                <button type="button" v-on:click="clearInputImage('imagen', 'imagenContentType', 'file_imagen')" class="btn btn-secondary btn-xs pull-right">
                                    <font-awesome-icon icon="times"></font-awesome-icon>
                                </button>
                            </div>
                            <input type="file" ref="file_imagen" id="file_imagen" v-on:change="setFileData($event, persona, 'imagen', true)" accept="image/*" v-text="$t('entity.action.addimage')"/>
                        </div>
                        <input type="hidden" class="form-control" name="imagen" id="persona-imagen"
                            :class="{'valid': !$v.persona.imagen.$invalid, 'invalid': $v.persona.imagen.$invalid }" v-model="$v.persona.imagen.$model" />
                        <input type="hidden" class="form-control" name="imagenContentType" id="persona-imagenContentType"
                            v-model="persona.imagenContentType" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.avatar')" for="persona-avatar">Avatar</label>
                        <select class="form-control" id="persona-avatar" name="avatar" v-model="persona.avatarId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="avatarOption.id" v-for="avatarOption in avatars" :key="avatarOption.id">{{avatarOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.area')" for="persona-area">Area</label>
                        <select class="form-control" id="persona-area" name="area" v-model="persona.areaId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="areaOption.id" v-for="areaOption in areas" :key="areaOption.id">{{areaOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.persona.badges')" for="persona-badges">Badges</label>
                        <select class="form-control" id="persona-badges" name="badges" v-model="persona.badgesId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="badgeOption.id" v-for="badgeOption in badges" :key="badgeOption.id">{{badgeOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.persona.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./persona-update.component.ts">
</script>
