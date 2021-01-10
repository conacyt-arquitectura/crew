<template>
  <div>
    <div v-if="authenticated" class="home row">
      <div class="col-md-3">
        <b-overlay :show="isLoading" variant="white" spinner-type="grow" rounded="sm">
          <b-aspect aspect="1:1">
            <b-img :src="avatarUrl" fluid alt="Responsive image" @load="onAvatarLoad"></b-img>
          </b-aspect>
        </b-overlay>
      </div>
      <div class="col-md-9">
        <h1 class="display-4" v-text="$t('home.title')">Bienvenido tripulación!</h1>
        <p class="lead" v-text="$t('home.subtitle')">This is your homepage</p>

        <div>
          <div class="alert alert-success" v-if="authenticated">
            <span v-if="username" v-text="$t('home.logged.message', { username: username })"
              >You are logged in as user "{{ username }}"</span
            >
          </div>

          <div class="alert alert-warning" v-if="!authenticated">
            <span v-text="$t('global.messages.info.authenticated.prefix')">If you want to </span>
            <a class="alert-link" v-on:click="openLogin()" v-text="$t('global.messages.info.authenticated.link')">sign in</a
            ><span v-html="$t('global.messages.info.authenticated.suffix')"
              >, you can try the default accounts:<br />- Administrator (login="admin" and password="admin") <br />- User (login="user" and
              password="user").</span
            >
          </div>
        </div>
      </div>
    </div>
    <div v-else>
      <Info />
    </div>
    <div></div>
  </div>
</template>

<script lang="ts" src="./home.component.ts">
</script>
