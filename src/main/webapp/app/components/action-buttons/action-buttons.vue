<template>
  <div class="btn-group">
    <router-link :to="detailsParams" tag="button" class="btn btn-outline-info mr-2 details"> Detalle </router-link>
    <router-link :to="editParams" tag="button" class="btn btn-outline-primary btn-sm mr-2 edit"> Editar </router-link>
    <b-button v-on:click="cancel()" variant="outline-danger" class="btn btn-sm mr-1"> Eliminar </b-button>
  </div>
</template>


<script lang="ts" src="./action-buttons.component.ts">
</script>
