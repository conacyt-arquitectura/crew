import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IBadge } from '@/shared/model/badge.model';
import BadgeService from './badge.service';

@Component
export default class BadgeDetails extends mixins(JhiDataUtils) {
  @Inject('badgeService') private badgeService: () => BadgeService;
  public badge: IBadge = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.badgeId) {
        vm.retrieveBadge(to.params.badgeId);
      }
    });
  }

  public retrieveBadge(badgeId) {
    this.badgeService()
      .find(badgeId)
      .then(res => {
        this.badge = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
