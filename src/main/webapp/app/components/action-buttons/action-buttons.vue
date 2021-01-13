<template>
  <div class="btn-group">
    <div class="btn-group">
      <router-link :to="detailsParams" tag="button" class="btn btn-outline-info btn-sm details">
        <font-awesome-icon icon="eye"></font-awesome-icon>
      </router-link>
      <router-link :to="editParams" tag="button" class="btn btn-outline-primary btn-sm edit">
        <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
      </router-link>
      <b-button v-on:click="cancel()" variant="outline-danger" class="btn btn-sm" v-b-modal.removeEntity>
        <font-awesome-icon icon="times"></font-awesome-icon>
      </b-button>
    </div>
  </div>
</template>


<script lang="ts" src="./action-buttons.component.ts">
</script>
