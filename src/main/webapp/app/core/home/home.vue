<template>
  <div>
    <div v-if="authenticated" class="home row">
      <OrgChart />
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
    <div v-else class="banner">
      <b-carousel id="carousel-id" :interval="4000" controls indicators background="#0000" style="text-shadow: 1px 1px 2px #333">
        <b-carousel-slide
          caption="Pilares"
          text="Salsa tiene 4 pilares"
          img-center="true"
          img-fluid="true"
          img-thumbnail="true"
          img-src="/content/images/salsa/pilares.png"
        >
        </b-carousel-slide>
        <b-carousel-slide
          img-center="true"
          img-fluid="true"
          img-thumbnail="true"
          caption="Plataforma"
          text="Salsa está compuesto de 4 plataformas."
          img-src="/content/images/salsa/plataformas.png"
        >
        </b-carousel-slide>

        <b-carousel-slide
          img-center="true"
          img-fluid="true"
          img-thumbnail="true"
          caption="Direcciones"
          text="Estamos conformados de 4 direcciones."
          img-src="/content/images/salsa/direcciones.png"
        >
        </b-carousel-slide>
        <b-carousel-slide
          img-center="true"
          img-fluid="true"
          img-thumbnail="true"
          caption="Prácticas"
          text="Estmos conformados por 4 grupo de prácticas."
          img-src="/content/images/salsa/practicas.png"
        >
        </b-carousel-slide>
      </b-carousel>
    </div>
    <div></div>
  </div>
</template>

<script lang="ts" src="./home.component.ts">
</script>
