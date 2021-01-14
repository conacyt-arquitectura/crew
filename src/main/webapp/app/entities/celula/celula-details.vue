<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="celula">
        <h2 class="jh-entity-heading"><span v-text="$t('crewApp.celula.detail.title')">Celula</span> {{ celula.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('crewApp.celula.nombre')">Nombre</span>
          </dt>
          <dd>
            <span>{{ celula.nombre }}</span>
          </dd>
          <dt>
            <span v-text="$t('crewApp.celula.logo')">Logo</span>
          </dt>
          <dd>
            <div v-if="celula.logo">
              <a v-on:click="openFile(celula.logoContentType, celula.logo)">
                <img v-bind:src="'data:' + celula.logoContentType + ';base64,' + celula.logo" style="max-width: 100%" alt="celula image" />
              </a>
              {{ celula.logoContentType }}, {{ byteSize(celula.logo) }}
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="celula.id" :to="{ name: 'CelulaEdit', params: { celulaId: celula.id } }" tag="button" class="btn btn-primary">
          <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./celula-details.component.ts">
</script>
