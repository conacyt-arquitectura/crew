import Component from 'vue-class-component';
import { Inject, Vue } from 'vue-property-decorator';
import LoginService from '@/account/login.service';

@Component
export default class InfoComponent extends Vue {
  @Inject('loginService')
  private loginService: () => LoginService;
}
