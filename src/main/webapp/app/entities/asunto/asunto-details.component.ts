import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IAsunto } from '@/shared/model/asunto.model';
import AsuntoService from './asunto.service';

@Component
export default class AsuntoDetails extends mixins(JhiDataUtils) {
  @Inject('asuntoService') private asuntoService: () => AsuntoService;
  public asunto: IAsunto = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.asuntoId) {
        vm.retrieveAsunto(to.params.asuntoId);
      }
    });
  }

  public retrieveAsunto(asuntoId) {
    this.asuntoService()
      .find(asuntoId)
      .then(res => {
        this.asunto = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
