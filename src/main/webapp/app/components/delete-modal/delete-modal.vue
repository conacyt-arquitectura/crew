<template>
  <b-modal :id="id">
    <span slot="modal-title"><span id="crewApp.delete.title" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
    <div class="modal-body">
      <p id="jhi-delete-celula-heading" v-text="$t('entity.delete.question')">Are you sure you want to delete this Celula?</p>
    </div>
    <div slot="modal-footer">
      <button type="button" class="btn btn-outline-danger" v-text="$t('entity.action.cancel')" v-on:click="closeModal()">Cancel</button>
      <button type="button" class="btn btn-danger" id="jhi-confirm-delete-celula" v-text="$t('entity.action.delete')" v-on:click="remove()">
        Delete
      </button>
    </div>
  </b-modal>
</template>


<script lang="ts" src="./delete-modal.component.ts">
</script>
