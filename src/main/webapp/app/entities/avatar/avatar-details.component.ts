import { Component, Vue, Inject } from 'vue-property-decorator';

import { IAvatar } from '@/shared/model/avatar.model';
import AvatarService from './avatar.service';

@Component
export default class AvatarDetails extends Vue {
  @Inject('avatarService') private avatarService: () => AvatarService;
  public avatar: IAvatar = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.avatarId) {
        vm.retrieveAvatar(to.params.avatarId);
      }
    });
  }

  public retrieveAvatar(avatarId) {
    this.avatarService()
      .find(avatarId)
      .then(res => {
        this.avatar = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
