import Vue from 'vue';
import Component from 'vue-class-component';
import Ribbon from '@/core/ribbon/ribbon.vue';
import JhiFooter from '@/core/jhi-footer/jhi-footer.vue';
import JhiNavbar from '@/core/jhi-navbar/jhi-navbar.vue';
import JhiSidebar from '@/core/jhi-sidebar/jhi-sidebar.vue';

@Component({
  components: {
    ribbon: Ribbon,
    'jhi-navbar': JhiNavbar,
    'jhi-sidebar': JhiSidebar,

    'jhi-footer': JhiFooter,
  },
})
export default class App extends Vue { }
