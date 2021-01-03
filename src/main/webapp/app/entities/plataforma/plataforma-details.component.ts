import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IPlataforma } from '@/shared/model/plataforma.model';
import PlataformaService from './plataforma.service';

@Component
export default class PlataformaDetails extends mixins(JhiDataUtils) {
  @Inject('plataformaService') private plataformaService: () => PlataformaService;
  public plataforma: IPlataforma = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.plataformaId) {
        vm.retrievePlataforma(to.params.plataformaId);
      }
    });
  }

  public retrievePlataforma(plataformaId) {
    this.plataformaService()
      .find(plataformaId)
      .then(res => {
        this.plataforma = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
