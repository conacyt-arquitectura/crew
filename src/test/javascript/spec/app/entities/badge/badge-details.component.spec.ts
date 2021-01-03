/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import BadgeDetailComponent from '@/entities/badge/badge-details.vue';
import BadgeClass from '@/entities/badge/badge-details.component';
import BadgeService from '@/entities/badge/badge.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Badge Management Detail Component', () => {
    let wrapper: Wrapper<BadgeClass>;
    let comp: BadgeClass;
    let badgeServiceStub: SinonStubbedInstance<BadgeService>;

    beforeEach(() => {
      badgeServiceStub = sinon.createStubInstance<BadgeService>(BadgeService);

      wrapper = shallowMount<BadgeClass>(BadgeDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { badgeService: () => badgeServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundBadge = { id: '123' };
        badgeServiceStub.find.resolves(foundBadge);

        // WHEN
        comp.retrieveBadge('123');
        await comp.$nextTick();

        // THEN
        expect(comp.badge).toBe(foundBadge);
      });
    });
  });
});
