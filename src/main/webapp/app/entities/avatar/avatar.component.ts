import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IAvatar } from '@/shared/model/avatar.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import AvatarService from './avatar.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Avatar extends mixins(AlertMixin) {
  @Inject('avatarService') private avatarService: () => AvatarService;
  private removeId: string = null;

  public avatars: IAvatar[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllAvatars();
  }

  public clear(): void {
    this.retrieveAllAvatars();
  }

  public retrieveAllAvatars(): void {
    this.isFetching = true;

    this.avatarService()
      .retrieve()
      .then(
        res => {
          this.avatars = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IAvatar): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeAvatar(): void {
    this.avatarService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('crewApp.avatar.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllAvatars();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
