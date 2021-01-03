/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import PersonaUpdateComponent from '@/entities/persona/persona-update.vue';
import PersonaClass from '@/entities/persona/persona-update.component';
import PersonaService from '@/entities/persona/persona.service';

import AvatarService from '@/entities/avatar/avatar.service';

import AreaService from '@/entities/area/area.service';

import BadgeService from '@/entities/badge/badge.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('Persona Management Update Component', () => {
    let wrapper: Wrapper<PersonaClass>;
    let comp: PersonaClass;
    let personaServiceStub: SinonStubbedInstance<PersonaService>;

    beforeEach(() => {
      personaServiceStub = sinon.createStubInstance<PersonaService>(PersonaService);

      wrapper = shallowMount<PersonaClass>(PersonaUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          personaService: () => personaServiceStub,

          avatarService: () => new AvatarService(),

          areaService: () => new AreaService(),

          badgeService: () => new BadgeService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: '123' };
        comp.persona = entity;
        personaServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(personaServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.persona = entity;
        personaServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(personaServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
