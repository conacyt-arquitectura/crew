import SaveButtonComponent from '@/components/save-button/save-button.vue';
import DualButtonComponent from '@/components/dual-button/dual-button.vue';
import ActionButtonsComponent from '@/components/action-buttons/action-buttons.vue';
import DeleteModalComponent from '@/components/delete-modal/delete-modal.vue';

export function initCustomComponents(vue) {
  vue.component('c-save-button', SaveButtonComponent);
  vue.component('c-dual-button', DualButtonComponent);
  vue.component('c-action-buttons', ActionButtonsComponent);
  vue.component('c-delete-modal', DeleteModalComponent);
}
