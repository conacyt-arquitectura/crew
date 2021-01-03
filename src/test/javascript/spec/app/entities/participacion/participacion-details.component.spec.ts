/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import ParticipacionDetailComponent from '@/entities/participacion/participacion-details.vue';
import ParticipacionClass from '@/entities/participacion/participacion-details.component';
import ParticipacionService from '@/entities/participacion/participacion.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Participacion Management Detail Component', () => {
    let wrapper: Wrapper<ParticipacionClass>;
    let comp: ParticipacionClass;
    let participacionServiceStub: SinonStubbedInstance<ParticipacionService>;

    beforeEach(() => {
      participacionServiceStub = sinon.createStubInstance<ParticipacionService>(ParticipacionService);

      wrapper = shallowMount<ParticipacionClass>(ParticipacionDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { participacionService: () => participacionServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundParticipacion = { id: '123' };
        participacionServiceStub.find.resolves(foundParticipacion);

        // WHEN
        comp.retrieveParticipacion('123');
        await comp.$nextTick();

        // THEN
        expect(comp.participacion).toBe(foundParticipacion);
      });
    });
  });
});
