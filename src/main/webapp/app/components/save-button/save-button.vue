<template>
  <div>
    <b-button type="submit" variant="outline-info" :disabled="enabled">
      <b-spinner small type="grow" v-if="saving">Guardando...</b-spinner>
      <span v-if="saving">Guardando...</span>
      <font-awesome-icon icon="cloud-upload-alt" v-if="!saving"></font-awesome-icon>&nbsp;
      <span v-text="$t('entity.action.save')" v-if="!saving">Save</span>
    </b-button>
  </div>
</template>


<script lang="ts" src="./save-button.component.ts">
</script>
