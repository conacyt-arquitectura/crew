<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="crewApp.avatar.home.createOrEditLabel" v-text="$t('crewApp.avatar.home.createOrEditLabel')">Create or edit a Avatar</h2>
                <div>
                    <div class="form-group" v-if="avatar.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="avatar.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.isCircle')" for="avatar-isCircle">Is Circle</label>
                        <input type="checkbox" class="form-check" name="isCircle" id="avatar-isCircle"
                            :class="{'valid': !$v.avatar.isCircle.$invalid, 'invalid': $v.avatar.isCircle.$invalid }" v-model="$v.avatar.isCircle.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.avatarStyle')" for="avatar-avatarStyle">Avatar Style</label>
                        <input type="text" class="form-control" name="avatarStyle" id="avatar-avatarStyle"
                            :class="{'valid': !$v.avatar.avatarStyle.$invalid, 'invalid': $v.avatar.avatarStyle.$invalid }" v-model="$v.avatar.avatarStyle.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.circleColor')" for="avatar-circleColor">Circle Color</label>
                        <input type="text" class="form-control" name="circleColor" id="avatar-circleColor"
                            :class="{'valid': !$v.avatar.circleColor.$invalid, 'invalid': $v.avatar.circleColor.$invalid }" v-model="$v.avatar.circleColor.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.accessoriesType')" for="avatar-accessoriesType">Accessories Type</label>
                        <input type="text" class="form-control" name="accessoriesType" id="avatar-accessoriesType"
                            :class="{'valid': !$v.avatar.accessoriesType.$invalid, 'invalid': $v.avatar.accessoriesType.$invalid }" v-model="$v.avatar.accessoriesType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.clotheType')" for="avatar-clotheType">Clothe Type</label>
                        <input type="text" class="form-control" name="clotheType" id="avatar-clotheType"
                            :class="{'valid': !$v.avatar.clotheType.$invalid, 'invalid': $v.avatar.clotheType.$invalid }" v-model="$v.avatar.clotheType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.clotheColor')" for="avatar-clotheColor">Clothe Color</label>
                        <input type="text" class="form-control" name="clotheColor" id="avatar-clotheColor"
                            :class="{'valid': !$v.avatar.clotheColor.$invalid, 'invalid': $v.avatar.clotheColor.$invalid }" v-model="$v.avatar.clotheColor.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.eyebrowType')" for="avatar-eyebrowType">Eyebrow Type</label>
                        <input type="text" class="form-control" name="eyebrowType" id="avatar-eyebrowType"
                            :class="{'valid': !$v.avatar.eyebrowType.$invalid, 'invalid': $v.avatar.eyebrowType.$invalid }" v-model="$v.avatar.eyebrowType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.eyeType')" for="avatar-eyeType">Eye Type</label>
                        <input type="text" class="form-control" name="eyeType" id="avatar-eyeType"
                            :class="{'valid': !$v.avatar.eyeType.$invalid, 'invalid': $v.avatar.eyeType.$invalid }" v-model="$v.avatar.eyeType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.facialHairColor')" for="avatar-facialHairColor">Facial Hair Color</label>
                        <input type="text" class="form-control" name="facialHairColor" id="avatar-facialHairColor"
                            :class="{'valid': !$v.avatar.facialHairColor.$invalid, 'invalid': $v.avatar.facialHairColor.$invalid }" v-model="$v.avatar.facialHairColor.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.facialHairType')" for="avatar-facialHairType">Facial Hair Type</label>
                        <input type="text" class="form-control" name="facialHairType" id="avatar-facialHairType"
                            :class="{'valid': !$v.avatar.facialHairType.$invalid, 'invalid': $v.avatar.facialHairType.$invalid }" v-model="$v.avatar.facialHairType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.graphicType')" for="avatar-graphicType">Graphic Type</label>
                        <input type="text" class="form-control" name="graphicType" id="avatar-graphicType"
                            :class="{'valid': !$v.avatar.graphicType.$invalid, 'invalid': $v.avatar.graphicType.$invalid }" v-model="$v.avatar.graphicType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.hairColor')" for="avatar-hairColor">Hair Color</label>
                        <input type="text" class="form-control" name="hairColor" id="avatar-hairColor"
                            :class="{'valid': !$v.avatar.hairColor.$invalid, 'invalid': $v.avatar.hairColor.$invalid }" v-model="$v.avatar.hairColor.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.mouthType')" for="avatar-mouthType">Mouth Type</label>
                        <input type="text" class="form-control" name="mouthType" id="avatar-mouthType"
                            :class="{'valid': !$v.avatar.mouthType.$invalid, 'invalid': $v.avatar.mouthType.$invalid }" v-model="$v.avatar.mouthType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.skinColor')" for="avatar-skinColor">Skin Color</label>
                        <input type="text" class="form-control" name="skinColor" id="avatar-skinColor"
                            :class="{'valid': !$v.avatar.skinColor.$invalid, 'invalid': $v.avatar.skinColor.$invalid }" v-model="$v.avatar.skinColor.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.topType')" for="avatar-topType">Top Type</label>
                        <input type="text" class="form-control" name="topType" id="avatar-topType"
                            :class="{'valid': !$v.avatar.topType.$invalid, 'invalid': $v.avatar.topType.$invalid }" v-model="$v.avatar.topType.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('crewApp.avatar.topColor')" for="avatar-topColor">Top Color</label>
                        <input type="text" class="form-control" name="topColor" id="avatar-topColor"
                            :class="{'valid': !$v.avatar.topColor.$invalid, 'invalid': $v.avatar.topColor.$invalid }" v-model="$v.avatar.topColor.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.avatar.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./avatar-update.component.ts">
</script>
