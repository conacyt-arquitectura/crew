import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { IArea, Area } from '@/shared/model/area.model';
import AreaService from './area.service';

const validations: any = {
  area: {
    nombre: {
      required,
    },
    responsable: {},
    correo: {},
  },
};

@Component({
  validations,
})
export default class AreaUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('areaService') private areaService: () => AreaService;
  public area: IArea = new Area();

  public areas: IArea[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.areaId) {
        vm.retrieveArea(to.params.areaId);
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
    if (this.area.id) {
      this.areaService()
        .update(this.area)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.area.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.areaService()
        .create(this.area)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.area.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveArea(areaId): void {
    this.areaService()
      .find(areaId)
      .then(res => {
        this.area = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.areaService()
      .retrieve()
      .then(res => {
        this.areas = res.data;
      });
  }
}
