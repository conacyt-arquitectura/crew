<template>
  <div>
    <b-button id="cancel-save" type="button" variant="outline-primary" v-on:click="previousState()">
      <span v-text="$t('entity.action.cancel')">Save</span>
    </b-button>

    <b-button type="submit" variant="primary" :disabled="enabled">
      <b-spinner small type="grow" v-if="saving">Guardando...</b-spinner>
      <span v-if="saving">Guardando...</span>
      <span v-text="$t('entity.action.save')" v-if="!saving">Save</span>
    </b-button>
  </div>
</template>


<script lang="ts" src="./dual-button.component.ts">
</script>
