/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import PlataformaUpdateComponent from '@/entities/plataforma/plataforma-update.vue';
import PlataformaClass from '@/entities/plataforma/plataforma-update.component';
import PlataformaService from '@/entities/plataforma/plataforma.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('Plataforma Management Update Component', () => {
    let wrapper: Wrapper<PlataformaClass>;
    let comp: PlataformaClass;
    let plataformaServiceStub: SinonStubbedInstance<PlataformaService>;

    beforeEach(() => {
      plataformaServiceStub = sinon.createStubInstance<PlataformaService>(PlataformaService);

      wrapper = shallowMount<PlataformaClass>(PlataformaUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          plataformaService: () => plataformaServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: '123' };
        comp.plataforma = entity;
        plataformaServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(plataformaServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.plataforma = entity;
        plataformaServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(plataformaServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
