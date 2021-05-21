<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="asunto">
        <h2 class="jh-entity-heading"><span v-text="$t('crewApp.asunto.detail.title')">Asunto</span> {{ asunto.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('crewApp.asunto.nombre')">Nombre</span>
          </dt>
          <dd>
            <span>{{ asunto.nombre }}</span>
          </dd>
          <dt>
            <span v-text="$t('crewApp.asunto.clave')">Clave</span>
          </dt>
          <dd>
            <span>{{ asunto.clave }}</span>
          </dd>
          <dt>
            <span v-text="$t('crewApp.asunto.logo')">Logo</span>
          </dt>
          <dd>
            <div v-if="asunto.logo">
              <a v-on:click="openFile(asunto.logoContentType, asunto.logo)">
                <img v-bind:src="'data:' + asunto.logoContentType + ';base64,' + asunto.logo" style="max-width: 100%" alt="asunto image" />
              </a>
              {{ asunto.logoContentType }}, {{ byteSize(asunto.logo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('crewApp.asunto.celula')">Celula</span>
          </dt>
          <dd>
            <div v-if="asunto.celulaId">
              <router-link :to="{ name: 'CelulaView', params: { celulaId: asunto.celulaId } }">{{ asunto.celulaId }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('crewApp.asunto.plataforma')">Plataforma</span>
          </dt>
          <dd>
            <div v-if="asunto.plataformaId">
              <router-link :to="{ name: 'PlataformaView', params: { plataformaId: asunto.plataformaId } }">{{
                asunto.plataformaId
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('crewApp.asunto.area')">Area</span>
          </dt>
          <dd>
            <div v-if="asunto.areaId">
              <router-link :to="{ name: 'AreaView', params: { areaId: asunto.areaId } }">{{ asunto.areaId }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="asunto.id" :to="{ name: 'AsuntoEdit', params: { asuntoId: asunto.id } }" tag="button" class="btn btn-primary">
          <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./asunto-details.component.ts">
</script>
