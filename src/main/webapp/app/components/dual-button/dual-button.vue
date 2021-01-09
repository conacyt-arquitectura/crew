<template>
  <div>
    <b-button id="cancel-save" type="button" variant="outline-info" v-on:click="previousState()">
      <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;
      <span v-text="$t('entity.action.cancel')">Save</span>
    </b-button>

    <b-button type="submit" variant="outline-info" :disabled="enabled">
      <b-spinner small type="grow" v-if="saving">Guardando...</b-spinner>
      <span v-if="saving">Guardando...</span>
      <font-awesome-icon icon="cloud-upload-alt" v-if="!saving"></font-awesome-icon>&nbsp;
      <span v-text="$t('entity.action.save')" v-if="!saving">Save</span>
    </b-button>

    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
      <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
    </button>

    <button type="submit" id="save-entity" :disabled="$v.participacion.$invalid || isSaving" class="btn btn-primary">
      <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
    </button>
  </div>
</template>


<script lang="ts" src="./dual-button.component.ts">
</script>
