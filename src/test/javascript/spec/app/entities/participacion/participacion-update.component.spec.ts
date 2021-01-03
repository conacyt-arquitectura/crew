/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import ParticipacionUpdateComponent from '@/entities/participacion/participacion-update.vue';
import ParticipacionClass from '@/entities/participacion/participacion-update.component';
import ParticipacionService from '@/entities/participacion/participacion.service';

import PersonaService from '@/entities/persona/persona.service';

import RolService from '@/entities/rol/rol.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('Participacion Management Update Component', () => {
    let wrapper: Wrapper<ParticipacionClass>;
    let comp: ParticipacionClass;
    let participacionServiceStub: SinonStubbedInstance<ParticipacionService>;

    beforeEach(() => {
      participacionServiceStub = sinon.createStubInstance<ParticipacionService>(ParticipacionService);

      wrapper = shallowMount<ParticipacionClass>(ParticipacionUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          participacionService: () => participacionServiceStub,

          personaService: () => new PersonaService(),

          rolService: () => new RolService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: '123' };
        comp.participacion = entity;
        participacionServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(participacionServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.participacion = entity;
        participacionServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(participacionServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
