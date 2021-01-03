<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('crewApp.avatar.home.title')" id="avatar-heading">Avatars</span>
            <router-link :to="{name: 'AvatarCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-avatar">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('crewApp.avatar.home.createLabel')">
                    Create a new Avatar
                </span>
            </router-link>
        </h2>
        <b-alert :show="dismissCountDown"
            dismissible
            :variant="alertType"
            @dismissed="dismissCountDown=0"
            @dismiss-count-down="countDownChanged">
            {{alertMessage}}
        </b-alert>
        <br/>
        <div class="alert alert-warning" v-if="!isFetching && avatars && avatars.length === 0">
            <span v-text="$t('crewApp.avatar.home.notFound')">No avatars found</span>
        </div>
        <div class="table-responsive" v-if="avatars && avatars.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th><span v-text="$t('global.field.id')">ID</span></th>
                    <th><span v-text="$t('crewApp.avatar.isCircle')">Is Circle</span></th>
                    <th><span v-text="$t('crewApp.avatar.avatarStyle')">Avatar Style</span></th>
                    <th><span v-text="$t('crewApp.avatar.circleColor')">Circle Color</span></th>
                    <th><span v-text="$t('crewApp.avatar.accessoriesType')">Accessories Type</span></th>
                    <th><span v-text="$t('crewApp.avatar.clotheType')">Clothe Type</span></th>
                    <th><span v-text="$t('crewApp.avatar.clotheColor')">Clothe Color</span></th>
                    <th><span v-text="$t('crewApp.avatar.eyebrowType')">Eyebrow Type</span></th>
                    <th><span v-text="$t('crewApp.avatar.eyeType')">Eye Type</span></th>
                    <th><span v-text="$t('crewApp.avatar.facialHairColor')">Facial Hair Color</span></th>
                    <th><span v-text="$t('crewApp.avatar.facialHairType')">Facial Hair Type</span></th>
                    <th><span v-text="$t('crewApp.avatar.graphicType')">Graphic Type</span></th>
                    <th><span v-text="$t('crewApp.avatar.hairColor')">Hair Color</span></th>
                    <th><span v-text="$t('crewApp.avatar.mouthType')">Mouth Type</span></th>
                    <th><span v-text="$t('crewApp.avatar.skinColor')">Skin Color</span></th>
                    <th><span v-text="$t('crewApp.avatar.topType')">Top Type</span></th>
                    <th><span v-text="$t('crewApp.avatar.topColor')">Top Color</span></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="avatar in avatars"
                    :key="avatar.id">
                    <td>
                        <router-link :to="{name: 'AvatarView', params: {avatarId: avatar.id}}">{{avatar.id}}</router-link>
                    </td>
                    <td>{{avatar.isCircle}}</td>
                    <td>{{avatar.avatarStyle}}</td>
                    <td>{{avatar.circleColor}}</td>
                    <td>{{avatar.accessoriesType}}</td>
                    <td>{{avatar.clotheType}}</td>
                    <td>{{avatar.clotheColor}}</td>
                    <td>{{avatar.eyebrowType}}</td>
                    <td>{{avatar.eyeType}}</td>
                    <td>{{avatar.facialHairColor}}</td>
                    <td>{{avatar.facialHairType}}</td>
                    <td>{{avatar.graphicType}}</td>
                    <td>{{avatar.hairColor}}</td>
                    <td>{{avatar.mouthType}}</td>
                    <td>{{avatar.skinColor}}</td>
                    <td>{{avatar.topType}}</td>
                    <td>{{avatar.topColor}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'AvatarView', params: {avatarId: avatar.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'AvatarEdit', params: {avatarId: avatar.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(avatar)"
                                   variant="danger"
                                   class="btn btn-sm"
                                   v-b-modal.removeEntity>
                                <font-awesome-icon icon="times"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                            </b-button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="crewApp.avatar.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-avatar-heading" v-text="$t('crewApp.avatar.delete.question', {'id': removeId})">Are you sure you want to delete this Avatar?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-avatar" v-text="$t('entity.action.delete')" v-on:click="removeAvatar()">Delete</button>
            </div>
        </b-modal>
    </div>
</template>

<script lang="ts" src="./avatar.component.ts">
</script>
