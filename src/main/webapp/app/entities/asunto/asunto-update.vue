<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="crewApp.asunto.home.createOrEditLabel" v-text="$t('crewApp.asunto.home.createOrEditLabel')">Create or edit a Asunto</h2>
        <div>
          <div class="form-group" v-if="asunto.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="asunto.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.asunto.nombre')" for="asunto-nombre">Nombre</label>
            <input
              type="text"
              class="form-control"
              name="nombre"
              id="asunto-nombre"
              :class="{ valid: !$v.asunto.nombre.$invalid, invalid: $v.asunto.nombre.$invalid }"
              v-model="$v.asunto.nombre.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.asunto.clave')" for="asunto-clave">Clave</label>
            <input
              type="text"
              class="form-control"
              name="clave"
              id="asunto-clave"
              :class="{ valid: !$v.asunto.clave.$invalid, invalid: $v.asunto.clave.$invalid }"
              v-model="$v.asunto.clave.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.asunto.logo')" for="asunto-logo">Logo</label>
            <div>
              <img
                v-bind:src="'data:' + asunto.logoContentType + ';base64,' + asunto.logo"
                style="max-height: 100px"
                v-if="asunto.logo"
                alt="asunto image"
              />
              <div v-if="asunto.logo" class="form-text text-danger clearfix">
                <span class="pull-left">{{ asunto.logoContentType }}, {{ byteSize(asunto.logo) }}</span>
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
                v-on:change="setFileData($event, asunto, 'logo', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="logo"
              id="asunto-logo"
              :class="{ valid: !$v.asunto.logo.$invalid, invalid: $v.asunto.logo.$invalid }"
              v-model="$v.asunto.logo.$model"
            />
            <input type="hidden" class="form-control" name="logoContentType" id="asunto-logoContentType" v-model="asunto.logoContentType" />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.asunto.celula')" for="asunto-celula">Celula</label>
            <select class="form-control" id="asunto-celula" name="celula" v-model="asunto.celulaId">
              <option v-bind:value="null"></option>
              <option v-bind:value="celulaOption.id" v-for="celulaOption in celulas" :key="celulaOption.id">{{ celulaOption.id }}</option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.asunto.plataforma')" for="asunto-plataforma">Plataforma</label>
            <select class="form-control" id="asunto-plataforma" name="plataforma" v-model="asunto.plataformaId">
              <option v-bind:value="null"></option>
              <option v-bind:value="plataformaOption.id" v-for="plataformaOption in plataformas" :key="plataformaOption.id">
                {{ plataformaOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.asunto.area')" for="asunto-area">Area</label>
            <select class="form-control" id="asunto-area" name="area" v-model="asunto.areaId">
              <option v-bind:value="null"></option>
              <option v-bind:value="areaOption.id" v-for="areaOption in areas" :key="areaOption.id">{{ areaOption.id }}</option>
            </select>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button type="submit" id="save-entity" :disabled="$v.asunto.$invalid || isSaving" class="btn btn-primary">
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./asunto-update.component.ts">
</script>
