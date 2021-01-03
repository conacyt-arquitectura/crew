import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICelula } from '@/shared/model/celula.model';
import CelulaService from './celula.service';

@Component
export default class CelulaDetails extends mixins(JhiDataUtils) {
  @Inject('celulaService') private celulaService: () => CelulaService;
  public celula: ICelula = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.celulaId) {
        vm.retrieveCelula(to.params.celulaId);
      }
    });
  }

  public retrieveCelula(celulaId) {
    this.celulaService()
      .find(celulaId)
      .then(res => {
        this.celula = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
