import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import PersonaService from '../persona/persona.service';
import { IPersona } from '@/shared/model/persona.model';

import RolService from '../rol/rol.service';
import { IRol } from '@/shared/model/rol.model';

import AlertService from '@/shared/alert/alert.service';
import { IParticipacion, Participacion } from '@/shared/model/participacion.model';
import ParticipacionService from './participacion.service';

const validations: any = {
  participacion: {},
};

@Component({
  validations,
})
export default class ParticipacionUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('participacionService') private participacionService: () => ParticipacionService;
  public participacion: IParticipacion = new Participacion();

  @Inject('personaService') private personaService: () => PersonaService;

  public personas: IPersona[] = [];

  @Inject('rolService') private rolService: () => RolService;

  public rols: IRol[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.participacionId) {
        vm.retrieveParticipacion(to.params.participacionId);
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
    if (this.participacion.id) {
      this.participacionService()
        .update(this.participacion)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.participacion.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.participacionService()
        .create(this.participacion)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.participacion.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveParticipacion(participacionId): void {
    this.participacionService()
      .find(participacionId)
      .then(res => {
        this.participacion = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.personaService()
      .retrieve()
      .then(res => {
        this.personas = res.data;
      });
    this.rolService()
      .retrieve()
      .then(res => {
        this.rols = res.data;
      });
  }
}
