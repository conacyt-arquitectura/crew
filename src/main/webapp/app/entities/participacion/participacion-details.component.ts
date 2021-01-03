import { Component, Vue, Inject } from 'vue-property-decorator';

import { IParticipacion } from '@/shared/model/participacion.model';
import ParticipacionService from './participacion.service';

@Component
export default class ParticipacionDetails extends Vue {
  @Inject('participacionService') private participacionService: () => ParticipacionService;
  public participacion: IParticipacion = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.participacionId) {
        vm.retrieveParticipacion(to.params.participacionId);
      }
    });
  }

  public retrieveParticipacion(participacionId) {
    this.participacionService()
      .find(participacionId)
      .then(res => {
        this.participacion = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
