<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="persona">
                <h2 class="jh-entity-heading"><span v-text="$t('crewApp.persona.detail.title')">Persona</span> {{persona.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('crewApp.persona.nombre')">Nombre</span>
                    </dt>
                    <dd>
                        <span>{{persona.nombre}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.persona.primerApellido')">Primer Apellido</span>
                    </dt>
                    <dd>
                        <span>{{persona.primerApellido}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.persona.segundoApellido')">Segundo Apellido</span>
                    </dt>
                    <dd>
                        <span>{{persona.segundoApellido}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.persona.correo')">Correo</span>
                    </dt>
                    <dd>
                        <span>{{persona.correo}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.persona.resumen')">Resumen</span>
                    </dt>
                    <dd>
                        <span>{{persona.resumen}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.persona.imagen')">Imagen</span>
                    </dt>
                    <dd>
                        <div v-if="persona.imagen">
                            <a v-on:click="openFile(persona.imagenContentType, persona.imagen)">
                                <img v-bind:src="'data:' + persona.imagenContentType + ';base64,' + persona.imagen" style="max-width: 100%;" alt="persona image"/>
                            </a>
                            {{persona.imagenContentType}}, {{byteSize(persona.imagen)}}
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.persona.avatar')">Avatar</span>
                    </dt>
                    <dd>
                        <div v-if="persona.avatarId">
                            <router-link :to="{name: 'AvatarView', params: {avatarId: persona.avatarId}}">{{persona.avatarId}}</router-link>
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.persona.area')">Area</span>
                    </dt>
                    <dd>
                        <div v-if="persona.areaId">
                            <router-link :to="{name: 'AreaView', params: {areaId: persona.areaId}}">{{persona.areaId}}</router-link>
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.persona.badges')">Badges</span>
                    </dt>
                    <dd>
                        <div v-if="persona.badgesId">
                            <router-link :to="{name: 'BadgeView', params: {badgeId: persona.badgesId}}">{{persona.badgesId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="persona.id" :to="{name: 'PersonaEdit', params: {personaId: persona.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./persona-details.component.ts">
</script>
