import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { IBadge, Badge } from '@/shared/model/badge.model';
import BadgeService from './badge.service';

const validations: any = {
  badge: {
    nombre: {
      required,
    },
    descripcion: {
      required,
    },
    logo: {},
  },
};

@Component({
  validations,
})
export default class BadgeUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('badgeService') private badgeService: () => BadgeService;
  public badge: IBadge = new Badge();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.badgeId) {
        vm.retrieveBadge(to.params.badgeId);
      }
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
    if (this.badge.id) {
      this.badgeService()
        .update(this.badge)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.badge.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.badgeService()
        .create(this.badge)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.badge.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveBadge(badgeId): void {
    this.badgeService()
      .find(badgeId)
      .then(res => {
        this.badge = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.badge && field && fieldContentType) {
      if (this.badge.hasOwnProperty(field)) {
        this.badge[field] = null;
      }
      if (this.badge.hasOwnProperty(fieldContentType)) {
        this.badge[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
