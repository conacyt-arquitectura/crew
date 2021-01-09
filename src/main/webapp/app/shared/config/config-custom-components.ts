import SaveButtonComponent from '@/components/save-button/save-button.vue';
import DualButtonComponent from '@/components/dual-button/dual-button.vue';

export function initCustomComponents(vue) {
  vue.component('c-save-button', SaveButtonComponent);
  vue.component('c-dual-button', DualButtonComponent);
}
