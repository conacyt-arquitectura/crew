<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="crewApp.area.home.createOrEditLabel" v-text="$t('crewApp.area.home.createOrEditLabel')">Create or edit a Area</h2>
        <div>
          <div class="form-group" v-if="area.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="area.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.area.nombre')" for="area-nombre">Nombre</label>
            <input
              type="text"
              class="form-control"
              name="nombre"
              id="area-nombre"
              :class="{ valid: !$v.area.nombre.$invalid, invalid: $v.area.nombre.$invalid }"
              v-model="$v.area.nombre.$model"
              required
            />
            <div v-if="$v.area.nombre.$anyDirty && $v.area.nombre.$invalid">
              <small class="form-text text-danger" v-if="!$v.area.nombre.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.area.responsable')" for="area-responsable">Responsable</label>
            <input
              type="text"
              class="form-control"
              name="responsable"
              id="area-responsable"
              :class="{ valid: !$v.area.responsable.$invalid, invalid: $v.area.responsable.$invalid }"
              v-model="$v.area.responsable.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.area.correo')" for="area-correo">Correo</label>
            <input
              type="text"
              class="form-control"
              name="correo"
              id="area-correo"
              :class="{ valid: !$v.area.correo.$invalid, invalid: $v.area.correo.$invalid }"
              v-model="$v.area.correo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.area.area')" for="area-area">Area</label>
            <select class="form-control" id="area-area" name="area" v-model="area.areaId">
              <option v-bind:value="null"></option>
              <option v-bind:value="areaOption.id" v-for="areaOption in areas" :key="areaOption.id">{{ areaOption.nombre }}</option>
            </select>
          </div>
        </div>
        <div>
          <c-dual-button :enabled="$v.area.$invalid || isSaving" :saving="isSaving"></c-dual-button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./area-update.component.ts">
</script>
