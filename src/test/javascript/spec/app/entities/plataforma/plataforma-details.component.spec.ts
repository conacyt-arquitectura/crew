/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import PlataformaDetailComponent from '@/entities/plataforma/plataforma-details.vue';
import PlataformaClass from '@/entities/plataforma/plataforma-details.component';
import PlataformaService from '@/entities/plataforma/plataforma.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Plataforma Management Detail Component', () => {
    let wrapper: Wrapper<PlataformaClass>;
    let comp: PlataformaClass;
    let plataformaServiceStub: SinonStubbedInstance<PlataformaService>;

    beforeEach(() => {
      plataformaServiceStub = sinon.createStubInstance<PlataformaService>(PlataformaService);

      wrapper = shallowMount<PlataformaClass>(PlataformaDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { plataformaService: () => plataformaServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundPlataforma = { id: '123' };
        plataformaServiceStub.find.resolves(foundPlataforma);

        // WHEN
        comp.retrievePlataforma('123');
        await comp.$nextTick();

        // THEN
        expect(comp.plataforma).toBe(foundPlataforma);
      });
    });
  });
});
