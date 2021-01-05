import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AvatarService from '../avatar/avatar.service';
import { IAvatar } from '@/shared/model/avatar.model';

import AreaService from '../area/area.service';
import { IArea } from '@/shared/model/area.model';

import BadgeService from '../badge/badge.service';
import { IBadge } from '@/shared/model/badge.model';

import AlertService from '@/shared/alert/alert.service';
import { IPersona, Persona } from '@/shared/model/persona.model';
import PersonaService from './persona.service';

const validations: any = {
  persona: {
    nombre: {
      required,
    },
    primerApellido: {},
    segundoApellido: {},
    correo: {},
    resumen: {},
    imagen: {},
  },
};

@Component({
  validations,
})
export default class PersonaUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('personaService') private personaService: () => PersonaService;
  public persona: IPersona = new Persona();

  @Inject('avatarService') private avatarService: () => AvatarService;

  public avatars: IAvatar[] = [];

  @Inject('areaService') private areaService: () => AreaService;

  public areas: IArea[] = [];

  @Inject('badgeService') private badgeService: () => BadgeService;

  public badges: IBadge[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.retrievePersona();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.persona.id) {
      this.personaService()
        .update(this.persona)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.persona.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.personaService()
        .create(this.persona)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.persona.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrievePersona(): void {
    this.personaService()
      .findByLogin()
      .then(res => {
        this.persona = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.persona && field && fieldContentType) {
      if (this.persona.hasOwnProperty(field)) {
        this.persona[field] = null;
      }
      if (this.persona.hasOwnProperty(fieldContentType)) {
        this.persona[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {
    this.avatarService()
      .retrieve()
      .then(res => {
        this.avatars = res.data;
      });
    this.areaService()
      .retrieve()
      .then(res => {
        this.areas = res.data;
      });
    this.badgeService()
      .retrieve()
      .then(res => {
        this.badges = res.data;
      });
  }
}
