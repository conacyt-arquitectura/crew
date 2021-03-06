import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IArea } from '@/shared/model/area.model';
import AlertMixin from '@/shared/alert/alert.mixin';
import OrgChart from '@/components/org-chart/org-chart.vue';

import AreaService from './area.service';

@Component({
  mixins: [Vue2Filters.mixin],
  components: {
    OrgChart
  }
})
export default class Area extends mixins(AlertMixin) {
  @Inject('areaService') private areaService: () => AreaService;
  private removeId: string = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public areas: IArea[] = [];

  public isFetching = false;
  public nodes = [];

  public mounted(): void {
    this.retrieveAllAreas();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllAreas();
  }

  public retrieveAllAreas(): void {
    this.isFetching = true;

    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    this.areaService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.areas = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
          this.areas.forEach(area => {
            this.nodes.push(
              { id: area.id, pid: area.areaId, name: area.responsable }
            )
          })
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IArea): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeArea(): void {
    this.areaService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('crewApp.area.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllAreas();
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
    this.retrieveAllAreas();
  }

  public changeOrder(propOrder): void {
    this.propOrder = propOrder;
    this.reverse = !this.reverse;
    this.transition();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
