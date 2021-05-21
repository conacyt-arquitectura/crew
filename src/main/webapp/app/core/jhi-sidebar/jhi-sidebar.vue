<template>
  <div>
    <b-button v-b-toggle.sidebar-1>Toggle Sidebar</b-button>
    <b-sidebar
      aria-labelledby="sidebar-no-header-title"
      bg-variant="secondary"
      is-nav
      no-header-close
      left
      text-variant="primary"
      appear
      no-close-on-esc
      no-close-on-route-change
      no-close-on-backdrop
      :visible="false"
      width="270px"
      shadow
    >
      <nav class="mb-3">
        <b-nav vertical>
          <b-nav-item active @click="hide">Active</b-nav-item>
          <b-nav-item to="/asunto"
            ><font-awesome-icon icon="route" /> <span v-text="$t('global.menu.entities.asunto')">Asunto</span></b-nav-item
          >
        </b-nav>
      </nav>
      <div class="p-3">
        <h1>
          <router-link :to="'/'">
            <span class="logo">Kbase</span>
          </router-link>
        </h1>

        <b-dropdown-item to="/asunto">
          <font-awesome-icon icon="route" />
          <span v-text="$t('global.menu.entities.asunto')">Asunto</span>
        </b-dropdown-item>
        <ul class="list-unstyled components mb-5">
          <li v-if="authenticated" class="active">
            <router-link :to="'/'"> <span class="fa fa-home mr-3"></span> {{ $t('global.menu.home') }} </router-link>
          </li>
        </ul>
      </div>
    </b-sidebar>
  </div>
</template>

<script lang="ts" src="./jhi-sidebar.component.ts">
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
