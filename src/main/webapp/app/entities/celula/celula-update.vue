<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="crewApp.celula.home.createOrEditLabel" v-text="$t('crewApp.celula.home.createOrEditLabel')">Create or edit a Celula</h2>
        <div>
          <div class="form-group" v-if="celula.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="celula.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.celula.nombre')" for="celula-nombre">Nombre</label>
            <input
              type="text"
              class="form-control"
              name="nombre"
              id="celula-nombre"
              :class="{ valid: !$v.celula.nombre.$invalid, invalid: $v.celula.nombre.$invalid }"
              v-model="$v.celula.nombre.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.celula.plataforma')" for="celula-plataforma">Plataforma</label>
            <select class="form-control" id="celula-plataforma" name="plataforma" v-model="celula.plataformaId">
              <option v-bind:value="null"></option>
              <option v-bind:value="plataformaOption.id" v-for="plataformaOption in plataformas" :key="plataformaOption.id">
                {{ plataformaOption.nombre }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.celula.logo')" for="celula-logo">Logo</label>
            <div>
              <img
                v-bind:src="'data:' + celula.logoContentType + ';base64,' + celula.logo"
                style="max-height: 100px"
                v-if="celula.logo"
                alt="celula image"
              />
              <div v-if="celula.logo" class="form-text text-danger clearfix">
                <span class="pull-left">{{ celula.logoContentType }}, {{ byteSize(celula.logo) }}</span>
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
                v-on:change="setFileData($event, celula, 'logo', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="logo"
              id="celula-logo"
              :class="{ valid: !$v.celula.logo.$invalid, invalid: $v.celula.logo.$invalid }"
              v-model="$v.celula.logo.$model"
            />
            <input type="hidden" class="form-control" name="logoContentType" id="celula-logoContentType" v-model="celula.logoContentType" />
          </div>
        </div>
        <div>
          <c-dual-button :enabled="$v.celula.$invalid || isSaving" :saving="isSaving"></c-dual-button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./celula-update.component.ts">
</script>
