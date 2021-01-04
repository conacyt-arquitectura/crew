import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { IAvatar, Avatar } from '@/shared/model/avatar.model';
import AvatarService from './avatar.service';
import { AvatarCatalog, Catalog } from '@/util/avatar.catalog';

const validations: any = {
  avatar: {
    circle: {},
    avatarStyle: {},
    circleColor: {},
    accessoriesType: {},
    clotheType: {},
    clotheColor: {},
    eyebrowType: {},
    eyeType: {},
    facialHairColor: {},
    facialHairType: {},
    graphicType: {},
    hairColor: {},
    mouthType: {},
    skinColor: {},
    topType: {},
    topColor: {},
  },
};

@Component({
  validations,
})
export default class AvatarUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('avatarService') private avatarService: () => AvatarService;
  public avatar: IAvatar = new Avatar();
  public isSaving = false;
  public currentLanguage = '';

  public catalog = AvatarCatalog;
  public isAvatarRobot = true;

  public hairTypeList = this.catalog.topType.filter(topType => topType.type === 'hair').map(topType => topType.value);
  public hatTypeList = this.catalog.topType.filter(topType => topType.type === 'hat').map(topType => topType.value);

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.avatarId) {
        vm.retrieveAvatar(to.params.avatarId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.avatar.id) {
      this.avatarService()
        .update(this.avatar)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.avatar.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.avatarService()
        .create(this.avatar)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('crewApp.avatar.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveAvatar(avatarId): void {
    this.avatarService()
      .find(avatarId)
      .then(res => {
        this.avatar = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void { }

  public get isTshirt(): boolean {
    return this.avatar.clotheType !== 'BlazerShirt' && this.avatar.clotheType !== 'BlazerSweater';
  }

  public get isGraphicTshirt(): boolean {
    return this.avatar.clotheType === 'GraphicShirt';
  }

  public get hasMustache(): boolean {
    return this.avatar.facialHairType !== 'Blank';
  }

  public get hasHat(): boolean {
    console.log(this.hatTypeList);

    return this.hatTypeList.includes(this.avatar.topType);
  }

  public get hasHair(): boolean {
    console.log('testing hair' + this.avatar.topType);

    return this.hairTypeList.includes(this.avatar.topType);
  }
}
