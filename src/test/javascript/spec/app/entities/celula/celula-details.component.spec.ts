/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CelulaDetailComponent from '@/entities/celula/celula-details.vue';
import CelulaClass from '@/entities/celula/celula-details.component';
import CelulaService from '@/entities/celula/celula.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Celula Management Detail Component', () => {
    let wrapper: Wrapper<CelulaClass>;
    let comp: CelulaClass;
    let celulaServiceStub: SinonStubbedInstance<CelulaService>;

    beforeEach(() => {
      celulaServiceStub = sinon.createStubInstance<CelulaService>(CelulaService);

      wrapper = shallowMount<CelulaClass>(CelulaDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { celulaService: () => celulaServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCelula = { id: '123' };
        celulaServiceStub.find.resolves(foundCelula);

        // WHEN
        comp.retrieveCelula('123');
        await comp.$nextTick();

        // THEN
        expect(comp.celula).toBe(foundCelula);
      });
    });
  });
});
