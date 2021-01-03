<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="area">
                <h2 class="jh-entity-heading"><span v-text="$t('crewApp.area.detail.title')">Area</span> {{area.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('crewApp.area.nombre')">Nombre</span>
                    </dt>
                    <dd>
                        <span>{{area.nombre}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.area.responsable')">Responsable</span>
                    </dt>
                    <dd>
                        <span>{{area.responsable}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.area.correo')">Correo</span>
                    </dt>
                    <dd>
                        <span>{{area.correo}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.area.area')">Area</span>
                    </dt>
                    <dd>
                        <div v-if="area.areaId">
                            <router-link :to="{name: 'AreaView', params: {areaId: area.areaId}}">{{area.areaId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="area.id" :to="{name: 'AreaEdit', params: {areaId: area.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./area-details.component.ts">
</script>
