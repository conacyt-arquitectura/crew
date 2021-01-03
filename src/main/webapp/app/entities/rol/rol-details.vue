<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="rol">
                <h2 class="jh-entity-heading"><span v-text="$t('crewApp.rol.detail.title')">Rol</span> {{rol.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('crewApp.rol.nombre')">Nombre</span>
                    </dt>
                    <dd>
                        <span>{{rol.nombre}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.rol.clave')">Clave</span>
                    </dt>
                    <dd>
                        <span>{{rol.clave}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.rol.logo')">Logo</span>
                    </dt>
                    <dd>
                        <div v-if="rol.logo">
                            <a v-on:click="openFile(rol.logoContentType, rol.logo)">
                                <img v-bind:src="'data:' + rol.logoContentType + ';base64,' + rol.logo" style="max-width: 100%;" alt="rol image"/>
                            </a>
                            {{rol.logoContentType}}, {{byteSize(rol.logo)}}
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="rol.id" :to="{name: 'RolEdit', params: {rolId: rol.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./rol-details.component.ts">
</script>
