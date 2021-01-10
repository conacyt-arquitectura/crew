<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="crewApp.participacion.home.createOrEditLabel" v-text="$t('crewApp.participacion.home.createOrEditLabel')">
          Create or edit a Participacion
        </h2>
        <div>
          <div class="form-group" v-if="participacion.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="participacion.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.participacion.celula')" for="participacion-celula">celula</label>
            <select class="form-control" id="participacion-celula" name="celula" v-model="participacion.celulaId">
              <option v-bind:value="null"></option>
              <option v-bind:value="celulaOption.id" v-for="celulaOption in celulas" :key="celulaOption.id">
                {{ celulaOption.nombre }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.participacion.persona')" for="participacion-persona">Persona</label>
            <select class="form-control" id="participacion-persona" name="persona" v-model="participacion.personaId">
              <option v-bind:value="null"></option>
              <option v-bind:value="personaOption.id" v-for="personaOption in personas" :key="personaOption.id">
                {{ personaOption.nombre }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('crewApp.participacion.rol')" for="participacion-rol">Rol</label>
            <select class="form-control" id="participacion-rol" name="rol" v-model="participacion.rolId">
              <option v-bind:value="null"></option>
              <option v-bind:value="rolOption.id" v-for="rolOption in rols" :key="rolOption.id">{{ rolOption.nombre }}</option>
            </select>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button type="submit" id="save-entity" :disabled="$v.participacion.$invalid || isSaving" class="btn btn-primary">
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./participacion-update.component.ts">
</script>
