<template>
  <div id="app">
    <b-sidebar id="sidebar-border" sidebar-class="border-right border-danger">
      <div class="px-3 py-2">
        <p>
          Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus,
          porta ac consectetur ac, vestibulum at eros.
        </p>
      </div>
    </b-sidebar>

    <ribbon></ribbon>
    <div id="app-header">
      <jhi-navbar></jhi-navbar>
      <jhi-sidebar></jhi-sidebar>
    </div>
    <div class="container-fluid">
      <div class="card jh-card">
        <router-view></router-view>
      </div>

      <!--   <jhi-footer></jhi-footer> -->
    </div>
  </div>
</template>

<script lang="ts" src="./app.component.ts">
</script>
