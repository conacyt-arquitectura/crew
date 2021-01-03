import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IPersona } from '@/shared/model/persona.model';
import PersonaService from './persona.service';

@Component
export default class PersonaDetails extends mixins(JhiDataUtils) {
  @Inject('personaService') private personaService: () => PersonaService;
  public persona: IPersona = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.personaId) {
        vm.retrievePersona(to.params.personaId);
      }
    });
  }

  public retrievePersona(personaId) {
    this.personaService()
      .find(personaId)
      .then(res => {
        this.persona = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
