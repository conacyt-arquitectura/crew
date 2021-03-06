import Component from 'vue-class-component';
import { Inject, Vue } from 'vue-property-decorator';
import LoginService from '@/account/login.service';
import Info from '@/core/info/info.vue';

@Component({
  components: {
    Info
  }
})
export default class Home extends Vue {
  @Inject('loginService')
  private loginService: () => LoginService;

  public isLoading = true;

  public avatarUrl = 'https://robohash.org/' + Math.random().toString(36).substring(7) + '?set=set2&bgset=&size=400x400';

  public openLogin(): void {
    this.loginService().login();
  }

  public get authenticated(): boolean {
    return this.$store.getters.authenticated;
  }

  public get username(): string {
    return this.$store.getters.account ? this.$store.getters.account.login : '';
  }

  public onAvatarLoad(): void {
    this.isLoading = false;
  }
}
