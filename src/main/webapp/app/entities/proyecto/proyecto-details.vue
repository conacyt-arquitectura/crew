<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="proyecto">
                <h2 class="jh-entity-heading"><span v-text="$t('crewApp.proyecto.detail.title')">Proyecto</span> {{proyecto.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('crewApp.proyecto.nombre')">Nombre</span>
                    </dt>
                    <dd>
                        <span>{{proyecto.nombre}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.proyecto.clave')">Clave</span>
                    </dt>
                    <dd>
                        <span>{{proyecto.clave}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.proyecto.logo')">Logo</span>
                    </dt>
                    <dd>
                        <div v-if="proyecto.logo">
                            <a v-on:click="openFile(proyecto.logoContentType, proyecto.logo)">
                                <img v-bind:src="'data:' + proyecto.logoContentType + ';base64,' + proyecto.logo" style="max-width: 100%;" alt="proyecto image"/>
                            </a>
                            {{proyecto.logoContentType}}, {{byteSize(proyecto.logo)}}
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.proyecto.celula')">Celula</span>
                    </dt>
                    <dd>
                        <div v-if="proyecto.celulaId">
                            <router-link :to="{name: 'CelulaView', params: {celulaId: proyecto.celulaId}}">{{proyecto.celulaId}}</router-link>
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.proyecto.plataforma')">Plataforma</span>
                    </dt>
                    <dd>
                        <div v-if="proyecto.plataformaId">
                            <router-link :to="{name: 'PlataformaView', params: {plataformaId: proyecto.plataformaId}}">{{proyecto.plataformaId}}</router-link>
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.proyecto.area')">Area</span>
                    </dt>
                    <dd>
                        <div v-if="proyecto.areaId">
                            <router-link :to="{name: 'AreaView', params: {areaId: proyecto.areaId}}">{{proyecto.areaId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="proyecto.id" :to="{name: 'ProyectoEdit', params: {proyectoId: proyecto.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./proyecto-details.component.ts">
</script>
