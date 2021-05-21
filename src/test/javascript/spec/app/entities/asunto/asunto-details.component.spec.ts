/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import AsuntoDetailComponent from '@/entities/asunto/asunto-details.vue';
import AsuntoClass from '@/entities/asunto/asunto-details.component';
import AsuntoService from '@/entities/asunto/asunto.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Asunto Management Detail Component', () => {
    let wrapper: Wrapper<AsuntoClass>;
    let comp: AsuntoClass;
    let asuntoServiceStub: SinonStubbedInstance<AsuntoService>;

    beforeEach(() => {
      asuntoServiceStub = sinon.createStubInstance<AsuntoService>(AsuntoService);

      wrapper = shallowMount<AsuntoClass>(AsuntoDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { asuntoService: () => asuntoServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundAsunto = { id: '123' };
        asuntoServiceStub.find.resolves(foundAsunto);

        // WHEN
        comp.retrieveAsunto('123');
        await comp.$nextTick();

        // THEN
        expect(comp.asunto).toBe(foundAsunto);
      });
    });
  });
});
