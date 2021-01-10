<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="crewApp.plataforma.home.createOrEditLabel" v-text="$t('crewApp.plataforma.home.createOrEditLabel')">
          Create or edit a Plataforma
        </h2>
        <div>
          <div class="form-group" v-if="plataforma.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="plataforma.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.plataforma.nombre')" for="plataforma-nombre">Nombre</label>
            <input
              type="text"
              class="form-control"
              name="nombre"
              id="plataforma-nombre"
              :class="{ valid: !$v.plataforma.nombre.$invalid, invalid: $v.plataforma.nombre.$invalid }"
              v-model="$v.plataforma.nombre.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.plataforma.clave')" for="plataforma-clave">Clave</label>
            <input
              type="text"
              class="form-control"
              name="clave"
              id="plataforma-clave"
              :class="{ valid: !$v.plataforma.clave.$invalid, invalid: $v.plataforma.clave.$invalid }"
              v-model="$v.plataforma.clave.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.plataforma.color')" for="plataforma-color">Color</label>
            <input
              type="color"
              class="form-control"
              name="color"
              id="plataforma-color"
              :class="{ valid: !$v.plataforma.color.$invalid, invalid: $v.plataforma.color.$invalid }"
              v-model="$v.plataforma.color.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.plataforma.logo')" for="plataforma-logo">Logo</label>
            <div>
              <img
                v-bind:src="'data:' + plataforma.logoContentType + ';base64,' + plataforma.logo"
                style="max-height: 100px"
                v-if="plataforma.logo"
                alt="plataforma image"
              />
              <div v-if="plataforma.logo" class="form-text text-danger clearfix">
                <span class="pull-left">{{ plataforma.logoContentType }}, {{ byteSize(plataforma.logo) }}</span>
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
                v-on:change="setFileData($event, plataforma, 'logo', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="logo"
              id="plataforma-logo"
              :class="{ valid: !$v.plataforma.logo.$invalid, invalid: $v.plataforma.logo.$invalid }"
              v-model="$v.plataforma.logo.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="logoContentType"
              id="plataforma-logoContentType"
              v-model="plataforma.logoContentType"
            />
          </div>
        </div>
        <div>
          <c-save-button :enabled="$v.plataforma.$invalid || isSaving" :saving="isSaving"></c-save-button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./plataforma-update.component.ts">
</script>
