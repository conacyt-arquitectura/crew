/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import AsuntoUpdateComponent from '@/entities/asunto/asunto-update.vue';
import AsuntoClass from '@/entities/asunto/asunto-update.component';
import AsuntoService from '@/entities/asunto/asunto.service';

import CelulaService from '@/entities/celula/celula.service';

import PlataformaService from '@/entities/plataforma/plataforma.service';

import AreaService from '@/entities/area/area.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('Asunto Management Update Component', () => {
    let wrapper: Wrapper<AsuntoClass>;
    let comp: AsuntoClass;
    let asuntoServiceStub: SinonStubbedInstance<AsuntoService>;

    beforeEach(() => {
      asuntoServiceStub = sinon.createStubInstance<AsuntoService>(AsuntoService);

      wrapper = shallowMount<AsuntoClass>(AsuntoUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          asuntoService: () => asuntoServiceStub,

          celulaService: () => new CelulaService(),

          plataformaService: () => new PlataformaService(),

          areaService: () => new AreaService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: '123' };
        comp.asunto = entity;
        asuntoServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(asuntoServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.asunto = entity;
        asuntoServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(asuntoServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
