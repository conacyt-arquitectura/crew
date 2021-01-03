<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="avatar">
                <h2 class="jh-entity-heading"><span v-text="$t('crewApp.avatar.detail.title')">Avatar</span> {{avatar.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('crewApp.avatar.isCircle')">Is Circle</span>
                    </dt>
                    <dd>
                        <span>{{avatar.isCircle}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.avatarStyle')">Avatar Style</span>
                    </dt>
                    <dd>
                        <span>{{avatar.avatarStyle}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.circleColor')">Circle Color</span>
                    </dt>
                    <dd>
                        <span>{{avatar.circleColor}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.accessoriesType')">Accessories Type</span>
                    </dt>
                    <dd>
                        <span>{{avatar.accessoriesType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.clotheType')">Clothe Type</span>
                    </dt>
                    <dd>
                        <span>{{avatar.clotheType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.clotheColor')">Clothe Color</span>
                    </dt>
                    <dd>
                        <span>{{avatar.clotheColor}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.eyebrowType')">Eyebrow Type</span>
                    </dt>
                    <dd>
                        <span>{{avatar.eyebrowType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.eyeType')">Eye Type</span>
                    </dt>
                    <dd>
                        <span>{{avatar.eyeType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.facialHairColor')">Facial Hair Color</span>
                    </dt>
                    <dd>
                        <span>{{avatar.facialHairColor}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.facialHairType')">Facial Hair Type</span>
                    </dt>
                    <dd>
                        <span>{{avatar.facialHairType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.graphicType')">Graphic Type</span>
                    </dt>
                    <dd>
                        <span>{{avatar.graphicType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.hairColor')">Hair Color</span>
                    </dt>
                    <dd>
                        <span>{{avatar.hairColor}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.mouthType')">Mouth Type</span>
                    </dt>
                    <dd>
                        <span>{{avatar.mouthType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.skinColor')">Skin Color</span>
                    </dt>
                    <dd>
                        <span>{{avatar.skinColor}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.topType')">Top Type</span>
                    </dt>
                    <dd>
                        <span>{{avatar.topType}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('crewApp.avatar.topColor')">Top Color</span>
                    </dt>
                    <dd>
                        <span>{{avatar.topColor}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="avatar.id" :to="{name: 'AvatarEdit', params: {avatarId: avatar.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./avatar-details.component.ts">
</script>
