<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="participacion">
                <h2 class="jh-entity-heading"><span v-text="$t('crewApp.participacion.detail.title')">Participacion</span> {{participacion.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('crewApp.participacion.persona')">Persona</span>
                    </dt>
                    <dd>
                        <div v-if="participacion.personaId">
                            <router-link :to="{name: 'PersonaView', params: {personaId: participacion.personaId}}">{{participacion.personaId}}</router-link>
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.participacion.rol')">Rol</span>
                    </dt>
                    <dd>
                        <div v-if="participacion.rolId">
                            <router-link :to="{name: 'RolView', params: {rolId: participacion.rolId}}">{{participacion.rolId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="participacion.id" :to="{name: 'ParticipacionEdit', params: {participacionId: participacion.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./participacion-details.component.ts">
</script>
