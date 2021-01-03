import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { IRol, Rol } from '@/shared/model/rol.model';
import RolService from './rol.service';

const validations: any = {
  rol: {
    nombre: {},
    clave: {},
    logo: {},
  },
};

@Component({
  validations,
})
export default class RolUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('rolService') private rolService: () => RolService;
  public rol: IRol = new Rol();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.rolId) {
        vm.retrieveRol(to.params.rolId);
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
    if (this.rol.id) {
      this.rolService()
        .update(this.rol)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.rol.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.rolService()
        .create(this.rol)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.rol.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveRol(rolId): void {
    this.rolService()
      .find(rolId)
      .then(res => {
        this.rol = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.rol && field && fieldContentType) {
      if (this.rol.hasOwnProperty(field)) {
        this.rol[field] = null;
      }
      if (this.rol.hasOwnProperty(fieldContentType)) {
        this.rol[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
