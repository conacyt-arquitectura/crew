<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="badge">
                <h2 class="jh-entity-heading"><span v-text="$t('crewApp.badge.detail.title')">Badge</span> {{badge.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('crewApp.badge.nombre')">Nombre</span>
                    </dt>
                    <dd>
                        <span>{{badge.nombre}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.badge.descripcion')">Descripcion</span>
                    </dt>
                    <dd>
                        <span>{{badge.descripcion}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.badge.logo')">Logo</span>
                    </dt>
                    <dd>
                        <div v-if="badge.logo">
                            <a v-on:click="openFile(badge.logoContentType, badge.logo)">
                                <img v-bind:src="'data:' + badge.logoContentType + ';base64,' + badge.logo" style="max-width: 100%;" alt="badge image"/>
                            </a>
                            {{badge.logoContentType}}, {{byteSize(badge.logo)}}
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="badge.id" :to="{name: 'BadgeEdit', params: {badgeId: badge.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./badge-details.component.ts">
</script>
