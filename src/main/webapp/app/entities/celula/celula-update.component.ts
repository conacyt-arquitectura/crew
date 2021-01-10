import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { ICelula, Celula } from '@/shared/model/celula.model';
import CelulaService from './celula.service';


import PlataformaService from '../plataforma/plataforma.service';
import { IPlataforma } from '@/shared/model/plataforma.model';
const validations: any = {
  celula: {
    nombre: {},
    logo: {},
  },
};

@Component({
  validations,
})
export default class CelulaUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('celulaService') private celulaService: () => CelulaService;
  public celula: ICelula = new Celula();

  @Inject('plataformaService') private plataformaService: () => PlataformaService;
  public plataformas: IPlataforma[] = [];

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.celulaId) {
        vm.retrieveCelula(to.params.celulaId);
      }
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
    if (this.celula.id) {
      this.celulaService()
        .update(this.celula)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.celula.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.celulaService()
        .create(this.celula)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.celula.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveCelula(celulaId): void {
    this.celulaService()
      .find(celulaId)
      .then(res => {
        this.celula = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.celula && field && fieldContentType) {
      if (this.celula.hasOwnProperty(field)) {
        this.celula[field] = null;
      }
      if (this.celula.hasOwnProperty(fieldContentType)) {
        this.celula[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {
    this.plataformaService()
      .retrieve()
      .then(res => {
        this.plataformas = res.data;
      });
  }
}
