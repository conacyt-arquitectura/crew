import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IPlataforma } from '@/shared/model/plataforma.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import JhiDataUtils from '@/shared/data/data-utils.service';

import PlataformaService from './plataforma.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Plataforma extends mixins(JhiDataUtils, AlertMixin) {
  @Inject('plataformaService') private plataformaService: () => PlataformaService;
  private removeId: string = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public plataformas: IPlataforma[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllPlataformas();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllPlataformas();
  }

  public retrieveAllPlataformas(): void {
    this.isFetching = true;

    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    this.plataformaService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.plataformas = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IPlataforma): void {
    this.removeId = instance.id;
    this.$bvModal.show('removeEntity');
  }

  public removePlataforma(): void {
    this.plataformaService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('crewApp.plataforma.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllPlataformas();
        this.closeDialog();
      });
  }

  public sort(): Array<any> {
    const result = [this.propOrder + ',' + (this.reverse ? 'asc' : 'desc')];
    if (this.propOrder !== 'id') {
      result.push('id');
    }
    return result;
  }

  public loadPage(page: number): void {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
    }
  }

  public transition(): void {
    this.retrieveAllPlataformas();
  }

  public changeOrder(propOrder): void {
    this.propOrder = propOrder;
    this.reverse = !this.reverse;
    this.transition();
  }

  public closeDialog(): void {
    this.$bvModal.hide('removeEntity');
  }
}
