/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import AvatarComponent from '@/entities/avatar/avatar.vue';
import AvatarClass from '@/entities/avatar/avatar.component';
import AvatarService from '@/entities/avatar/avatar.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-alert', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Avatar Management Component', () => {
    let wrapper: Wrapper<AvatarClass>;
    let comp: AvatarClass;
    let avatarServiceStub: SinonStubbedInstance<AvatarService>;

    beforeEach(() => {
      avatarServiceStub = sinon.createStubInstance<AvatarService>(AvatarService);
      avatarServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<AvatarClass>(AvatarComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          avatarService: () => avatarServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      avatarServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '123' }] });

      // WHEN
      comp.retrieveAllAvatars();
      await comp.$nextTick();

      // THEN
      expect(avatarServiceStub.retrieve.called).toBeTruthy();
      expect(comp.avatars[0]).toEqual(jasmine.objectContaining({ id: '123' }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      avatarServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: '123' });
      comp.removeAvatar();
      await comp.$nextTick();

      // THEN
      expect(avatarServiceStub.delete.called).toBeTruthy();
      expect(avatarServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
