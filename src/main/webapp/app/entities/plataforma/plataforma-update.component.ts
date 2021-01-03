import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { IPlataforma, Plataforma } from '@/shared/model/plataforma.model';
import PlataformaService from './plataforma.service';

const validations: any = {
  plataforma: {
    nombre: {},
    color: {},
    logo: {},
  },
};

@Component({
  validations,
})
export default class PlataformaUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('plataformaService') private plataformaService: () => PlataformaService;
  public plataforma: IPlataforma = new Plataforma();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.plataformaId) {
        vm.retrievePlataforma(to.params.plataformaId);
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
    if (this.plataforma.id) {
      this.plataformaService()
        .update(this.plataforma)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.plataforma.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.plataformaService()
        .create(this.plataforma)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.plataforma.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrievePlataforma(plataformaId): void {
    this.plataformaService()
      .find(plataformaId)
      .then(res => {
        this.plataforma = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.plataforma && field && fieldContentType) {
      if (this.plataforma.hasOwnProperty(field)) {
        this.plataforma[field] = null;
      }
      if (this.plataforma.hasOwnProperty(fieldContentType)) {
        this.plataforma[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
