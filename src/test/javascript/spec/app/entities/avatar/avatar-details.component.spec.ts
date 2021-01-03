/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import AvatarDetailComponent from '@/entities/avatar/avatar-details.vue';
import AvatarClass from '@/entities/avatar/avatar-details.component';
import AvatarService from '@/entities/avatar/avatar.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Avatar Management Detail Component', () => {
    let wrapper: Wrapper<AvatarClass>;
    let comp: AvatarClass;
    let avatarServiceStub: SinonStubbedInstance<AvatarService>;

    beforeEach(() => {
      avatarServiceStub = sinon.createStubInstance<AvatarService>(AvatarService);

      wrapper = shallowMount<AvatarClass>(AvatarDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { avatarService: () => avatarServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundAvatar = { id: '123' };
        avatarServiceStub.find.resolves(foundAvatar);

        // WHEN
        comp.retrieveAvatar('123');
        await comp.$nextTick();

        // THEN
        expect(comp.avatar).toBe(foundAvatar);
      });
    });
  });
});
