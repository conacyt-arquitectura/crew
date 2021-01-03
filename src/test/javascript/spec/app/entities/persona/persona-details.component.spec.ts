/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import PersonaDetailComponent from '@/entities/persona/persona-details.vue';
import PersonaClass from '@/entities/persona/persona-details.component';
import PersonaService from '@/entities/persona/persona.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Persona Management Detail Component', () => {
    let wrapper: Wrapper<PersonaClass>;
    let comp: PersonaClass;
    let personaServiceStub: SinonStubbedInstance<PersonaService>;

    beforeEach(() => {
      personaServiceStub = sinon.createStubInstance<PersonaService>(PersonaService);

      wrapper = shallowMount<PersonaClass>(PersonaDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { personaService: () => personaServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundPersona = { id: '123' };
        personaServiceStub.find.resolves(foundPersona);

        // WHEN
        comp.retrievePersona('123');
        await comp.$nextTick();

        // THEN
        expect(comp.persona).toBe(foundPersona);
      });
    });
  });
});
