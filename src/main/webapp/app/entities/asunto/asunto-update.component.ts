import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import CelulaService from '../celula/celula.service';
import { ICelula } from '@/shared/model/celula.model';

import PlataformaService from '../plataforma/plataforma.service';
import { IPlataforma } from '@/shared/model/plataforma.model';

import AreaService from '../area/area.service';
import { IArea } from '@/shared/model/area.model';

import AlertService from '@/shared/alert/alert.service';
import { IAsunto, Asunto } from '@/shared/model/asunto.model';
import AsuntoService from './asunto.service';

const validations: any = {
  asunto: {
    nombre: {},
    clave: {},
    logo: {},
  },
};

@Component({
  validations,
})
export default class AsuntoUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('asuntoService') private asuntoService: () => AsuntoService;
  public asunto: IAsunto = new Asunto();

  @Inject('celulaService') private celulaService: () => CelulaService;

  public celulas: ICelula[] = [];

  @Inject('plataformaService') private plataformaService: () => PlataformaService;

  public plataformas: IPlataforma[] = [];

  @Inject('areaService') private areaService: () => AreaService;

  public areas: IArea[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.asuntoId) {
        vm.retrieveAsunto(to.params.asuntoId);
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
    if (this.asunto.id) {
      this.asuntoService()
        .update(this.asunto)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.asunto.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.asuntoService()
        .create(this.asunto)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.asunto.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveAsunto(asuntoId): void {
    this.asuntoService()
      .find(asuntoId)
      .then(res => {
        this.asunto = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.asunto && field && fieldContentType) {
      if (this.asunto.hasOwnProperty(field)) {
        this.asunto[field] = null;
      }
      if (this.asunto.hasOwnProperty(fieldContentType)) {
        this.asunto[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {
    this.celulaService()
      .retrieve()
      .then(res => {
        this.celulas = res.data;
      });
    this.plataformaService()
      .retrieve()
      .then(res => {
        this.plataformas = res.data;
      });
    this.areaService()
      .retrieve()
      .then(res => {
        this.areas = res.data;
      });
  }
}
