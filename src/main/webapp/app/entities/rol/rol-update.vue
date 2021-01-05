<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="crewApp.rol.home.createOrEditLabel" v-text="$t('crewApp.rol.home.createOrEditLabel')">Create or edit a Rol</h2>
        <div>
          <div class="form-group" v-if="rol.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="rol.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.rol.nombre')" for="rol-nombre">Nombre</label>
            <input
              type="text"
              class="form-control"
              name="nombre"
              id="rol-nombre"
              :class="{ valid: !$v.rol.nombre.$invalid, invalid: $v.rol.nombre.$invalid }"
              v-model="$v.rol.nombre.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.rol.clave')" for="rol-clave">Clave</label>
            <input
              type="text"
              class="form-control"
              name="clave"
              id="rol-clave"
              :class="{ valid: !$v.rol.clave.$invalid, invalid: $v.rol.clave.$invalid }"
              v-model="$v.rol.clave.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.rol.logo')" for="rol-logo">Logo</label>
            <div>
              <img
                v-bind:src="'data:' + rol.logoContentType + ';base64,' + rol.logo"
                style="max-height: 100px"
                v-if="rol.logo"
                alt="rol image"
              />
              <div v-if="rol.logo" class="form-text text-danger clearfix">
                <span class="pull-left">{{ rol.logoContentType }}, {{ byteSize(rol.logo) }}</span>
                <button
                  type="button"
                  v-on:click="clearInputImage('logo', 'logoContentType', 'file_logo')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_logo"
                id="file_logo"
                v-on:change="setFileData($event, rol, 'logo', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="logo"
              id="rol-logo"
              :class="{ valid: !$v.rol.logo.$invalid, invalid: $v.rol.logo.$invalid }"
              v-model="$v.rol.logo.$model"
            />
            <input type="hidden" class="form-control" name="logoContentType" id="rol-logoContentType" v-model="rol.logoContentType" />
          </div>
        </div>
        <div>
          <c-save-button :enabled="$v.rol.$invalid || isSaving" :saving="isSaving"></c-save-button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./rol-update.component.ts">
</script>
