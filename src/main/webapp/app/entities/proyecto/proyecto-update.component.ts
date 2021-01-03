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
import { IProyecto, Proyecto } from '@/shared/model/proyecto.model';
import ProyectoService from './proyecto.service';

const validations: any = {
  proyecto: {
    nombre: {},
    clave: {},
    logo: {},
  },
};

@Component({
  validations,
})
export default class ProyectoUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('proyectoService') private proyectoService: () => ProyectoService;
  public proyecto: IProyecto = new Proyecto();

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
      if (to.params.proyectoId) {
        vm.retrieveProyecto(to.params.proyectoId);
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
    if (this.proyecto.id) {
      this.proyectoService()
        .update(this.proyecto)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.proyecto.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.proyectoService()
        .create(this.proyecto)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.proyecto.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveProyecto(proyectoId): void {
    this.proyectoService()
      .find(proyectoId)
      .then(res => {
        this.proyecto = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.proyecto && field && fieldContentType) {
      if (this.proyecto.hasOwnProperty(field)) {
        this.proyecto[field] = null;
      }
      if (this.proyecto.hasOwnProperty(fieldContentType)) {
        this.proyecto[fieldContentType] = null;
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
