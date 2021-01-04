<template>
  <div class="home row">
    <div class="col-md-3">
      <avataaars
        class="avatar-float"
        v-show="avatar.human"
        :isCircle="avatar.circle"
        :circleColor="avatar.circleColor"
        :accessoriesType="avatar.accessoriesType"
        :clotheType="avatar.clotheType"
        :clotheColor="avatar.clotheColor"
        :eyebrowType="avatar.eyebrowType"
        :eyeType="avatar.eyeType"
        :facialHairColor="avatar.facialHairColor"
        :facialHairType="avatar.facialHairType"
        :graphicType="avatar.graphicType"
        :hairColor="avatar.hairColor"
        :mouthType="avatar.mouthType"
        :skinColor="avatar.skinColor"
        :topType="avatar.topType"
        :topColor="avatar.topColor"
      ></avataaars>

      <!-- AVATAR-->
      <vue-load-image v-show="!avatar.human">
        <img
          slot="image"
          class="rounded img-fluid rounded"
          src="https://robohash.org/c78e3e320b7c98b51b612f3b28bdc2d3?set=set4&bgset=&size=400x400"
          alt="robo"
        />
        <img slot="preloader" class="mx-auto d-block img-fluid rounded" src="/content/images/loader.gif" />
        <div slot="error">error message</div>
      </vue-load-image>
    </div>

    <!-- FORMULARIO -->

    <div class="col-md-9">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="crewApp.avatar.home.createOrEditLabel" v-text="$t('crewApp.avatar.home.createOrEditLabel')">Create or edit a Avatar</h2>

        <div class="form-group">
          <b-form-checkbox v-model="avatar.human" switch>{{ $t('crewApp.avatar.isHuman') }}</b-form-checkbox>
        </div>

        <!-- FORMULARIO AVATAR HUMANO-->

        <div v-show="avatar.human">
          <b-tabs content-class="mt-3" pills card vertical>
            <b-tab title="Fondo">
              <div class="form-group">
                <b-form-checkbox v-model="$v.avatar.circle.$model" switch>{{ $t('crewApp.avatar.isCircle') }}</b-form-checkbox>
              </div>
              <div class="form-group w-25" v-show="avatar.circle">
                <label class="form-control-label" v-text="$t('crewApp.avatar.circleColor')" for="avatar-circleColor">Circle Color</label>
                <input
                  type="color"
                  class="form-control w-25"
                  name="circleColor"
                  id="avatar-circleColor"
                  :class="{ valid: !$v.avatar.circleColor.$invalid, invalid: $v.avatar.circleColor.$invalid }"
                  v-model="$v.avatar.circleColor.$model"
                />
              </div>
            </b-tab>

            <b-tab title="Lentes">
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.accessoriesType')" for="avatar-accessoriesType"
                  >Accessories Type</label
                >
                <b-form-radio-group
                  class=""
                  id="glasses-type"
                  v-model="avatar.accessoriesType"
                  :options="catalog.accesoriesTypes"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
            </b-tab>

            <b-tab title="Ropa">
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.clotheType')" for="avatar-clotheType">Clothe Type</label>
                <b-form-radio-group
                  class=""
                  id="clothe-type"
                  v-model="avatar.clotheType"
                  :options="catalog.clotheType"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
              <div class="form-group" v-if="avatar.clotheType === 'GraphicShirt'">
                <label class="form-control-label" v-text="$t('crewApp.avatar.graphicType')" for="avatar-graphicType">Graphic Type</label>
                <b-form-radio-group
                  id="graphic-type"
                  v-model="avatar.graphicType"
                  :options="catalog.graphicType"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.clotheColor')" for="avatar-clotheColor">Clothe Color</label>
                <b-form-radio-group class="" id="clothe-color" v-model="avatar.clotheColor" buttons>
                  <b-form-radio
                    v-for="(clothe, index) in catalog.clotheColor"
                    :key="index"
                    :button-variant="clothe.text"
                    :value="clothe.value"
                    buttons
                  ></b-form-radio>
                </b-form-radio-group>
              </div>
            </b-tab>

            <b-tab title="Ojos">
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.eyebrowType')" for="avatar-eyebrowType">Eyebrow Type</label>
                <b-form-radio-group
                  class=""
                  id="eyebrow-type"
                  v-model="avatar.eyebrowType"
                  :options="catalog.eyebrowType"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>

              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.eyeType')" for="avatar-eyeType">Eye Type</label>
                <b-form-radio-group
                  class=""
                  id="eye-type"
                  v-model="avatar.eyeType"
                  :options="catalog.eyeType"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
            </b-tab>

            <b-tab title="Barba">
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.facialHairColor')" for="avatar-facialHairColor"
                  >Facial Hair Color</label
                >
                <b-form-radio-group
                  class=""
                  id="facial-hair-color"
                  v-model="avatar.facialHairColor"
                  :options="catalog.facialHairColor"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.facialHairType')" for="avatar-facialHairType"
                  >Facial Hair Type</label
                >
                <b-form-radio-group
                  class=""
                  id="facial-hair-type"
                  v-model="avatar.facialHairType"
                  :options="catalog.facialHairType"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
            </b-tab>

            <b-tab title="Lentes">
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.hairColor')" for="avatar-hairColor">Hair Color</label>
                <b-form-radio-group
                  class=""
                  id="hair-color"
                  v-model="avatar.hairColor"
                  :options="catalog.hairColor"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
            </b-tab>

            <b-tab title="Boca">
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.mouthType')" for="avatar-mouthType">Mouth Type</label>
                <b-form-radio-group
                  class=""
                  id="mouth-type"
                  v-model="avatar.mouthType"
                  :options="catalog.mouthType"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
            </b-tab>

            <b-tab title="Color de piel">
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.skinColor')" for="avatar-skinColor">Skin Color</label>
                <b-form-radio-group
                  class=""
                  id="skin-color"
                  v-model="avatar.skinColor"
                  :options="catalog.skinColor"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
            </b-tab>

            <b-tab title="Sombreros">
              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.topType')" for="avatar-topType">Top Type</label>
                <b-form-radio-group
                  class=""
                  id="top-type"
                  v-model="avatar.topType"
                  :options="catalog.topType"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>

              <div class="form-group">
                <label class="form-control-label" v-text="$t('crewApp.avatar.topColor')" for="avatar-topColor">Top Color</label>
                <b-form-radio-group
                  class=""
                  id="top-color"
                  v-model="avatar.topColor"
                  :options="catalog.topColor"
                  button-variant="outline-primary"
                ></b-form-radio-group>
              </div>
            </b-tab>
          </b-tabs>
        </div>
        <!-- FORMULARIO AVATAR NO HUMANO-->

        <div v-show="!avatar.human"></div>
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
