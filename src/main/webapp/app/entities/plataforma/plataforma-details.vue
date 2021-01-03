<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="plataforma">
                <h2 class="jh-entity-heading"><span v-text="$t('crewApp.plataforma.detail.title')">Plataforma</span> {{plataforma.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('crewApp.plataforma.nombre')">Nombre</span>
                    </dt>
                    <dd>
                        <span>{{plataforma.nombre}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.plataforma.color')">Color</span>
                    </dt>
                    <dd>
                        <span>{{plataforma.color}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.plataforma.logo')">Logo</span>
                    </dt>
                    <dd>
                        <div v-if="plataforma.logo">
                            <a v-on:click="openFile(plataforma.logoContentType, plataforma.logo)">
                                <img v-bind:src="'data:' + plataforma.logoContentType + ';base64,' + plataforma.logo" style="max-width: 100%;" alt="plataforma image"/>
                            </a>
                            {{plataforma.logoContentType}}, {{byteSize(plataforma.logo)}}
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="plataforma.id" :to="{name: 'PlataformaEdit', params: {plataformaId: plataforma.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./plataforma-details.component.ts">
</script>
