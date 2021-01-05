<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="crewApp.persona.home.createOrEditLabel" v-text="$t('crewApp.persona.home.createOrEditLabel')">Create or edit a Persona</h2>
        <div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.persona.nombre')" for="persona-nombre">Nombre</label>
            <input
              type="text"
              class="form-control"
              name="nombre"
              id="persona-nombre"
              :class="{ valid: !$v.persona.nombre.$invalid, invalid: $v.persona.nombre.$invalid }"
              v-model="$v.persona.nombre.$model"
              required
            />
            <div v-if="$v.persona.nombre.$anyDirty && $v.persona.nombre.$invalid">
              <small class="form-text text-danger" v-if="!$v.persona.nombre.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.persona.primerApellido')" for="persona-primerApellido"
              >Primer Apellido</label
            >
            <input
              type="text"
              class="form-control"
              name="primerApellido"
              id="persona-primerApellido"
              :class="{ valid: !$v.persona.primerApellido.$invalid, invalid: $v.persona.primerApellido.$invalid }"
              v-model="$v.persona.primerApellido.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.persona.segundoApellido')" for="persona-segundoApellido"
              >Segundo Apellido</label
            >
            <input
              type="text"
              class="form-control"
              name="segundoApellido"
              id="persona-segundoApellido"
              :class="{ valid: !$v.persona.segundoApellido.$invalid, invalid: $v.persona.segundoApellido.$invalid }"
              v-model="$v.persona.segundoApellido.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.persona.correo')" for="persona-correo">Correo</label>
            <input
              type="text"
              class="form-control"
              name="correo"
              id="persona-correo"
              :class="{ valid: !$v.persona.correo.$invalid, invalid: $v.persona.correo.$invalid }"
              v-model="$v.persona.correo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.persona.resumen')" for="persona-resumen">Resumen</label>
            <textarea
              class="form-control"
              name="resumen"
              id="persona-resumen"
              :class="{ valid: !$v.persona.resumen.$invalid, invalid: $v.persona.resumen.$invalid }"
              v-model="$v.persona.resumen.$model"
            ></textarea>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.persona.area')" for="persona-area">Area</label>
            <select class="form-control" id="persona-area" name="area" v-model="persona.areaId">
              <option v-bind:value="null"></option>
              <option v-bind:value="areaOption.id" v-for="areaOption in areas" :key="areaOption.id">{{ areaOption.nombre }}</option>
            </select>
          </div>
        </div>
        <div>
          <c-save-button :enabled="$v.persona.$invalid || isSaving" :saving="isSaving"></c-save-button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./persona-update.component.ts">
</script>
