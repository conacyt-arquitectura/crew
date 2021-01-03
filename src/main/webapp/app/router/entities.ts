import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const Proyecto = () => import('@/entities/proyecto/proyecto.vue');
// prettier-ignore
const ProyectoUpdate = () => import('@/entities/proyecto/proyecto-update.vue');
// prettier-ignore
const ProyectoDetails = () => import('@/entities/proyecto/proyecto-details.vue');
// prettier-ignore
const Celula = () => import('@/entities/celula/celula.vue');
// prettier-ignore
const CelulaUpdate = () => import('@/entities/celula/celula-update.vue');
// prettier-ignore
const CelulaDetails = () => import('@/entities/celula/celula-details.vue');
// prettier-ignore
const Participacion = () => import('@/entities/participacion/participacion.vue');
// prettier-ignore
const ParticipacionUpdate = () => import('@/entities/participacion/participacion-update.vue');
// prettier-ignore
const ParticipacionDetails = () => import('@/entities/participacion/participacion-details.vue');
// prettier-ignore
const Area = () => import('@/entities/area/area.vue');
// prettier-ignore
const AreaUpdate = () => import('@/entities/area/area-update.vue');
// prettier-ignore
const AreaDetails = () => import('@/entities/area/area-details.vue');
// prettier-ignore
const Persona = () => import('@/entities/persona/persona.vue');
// prettier-ignore
const PersonaUpdate = () => import('@/entities/persona/persona-update.vue');
// prettier-ignore
const PersonaDetails = () => import('@/entities/persona/persona-details.vue');
// prettier-ignore
const Badge = () => import('@/entities/badge/badge.vue');
// prettier-ignore
const BadgeUpdate = () => import('@/entities/badge/badge-update.vue');
// prettier-ignore
const BadgeDetails = () => import('@/entities/badge/badge-details.vue');
// prettier-ignore
const Avatar = () => import('@/entities/avatar/avatar.vue');
// prettier-ignore
const AvatarUpdate = () => import('@/entities/avatar/avatar-update.vue');
// prettier-ignore
const AvatarDetails = () => import('@/entities/avatar/avatar-details.vue');
// prettier-ignore
const Rol = () => import('@/entities/rol/rol.vue');
// prettier-ignore
const RolUpdate = () => import('@/entities/rol/rol-update.vue');
// prettier-ignore
const RolDetails = () => import('@/entities/rol/rol-details.vue');
// prettier-ignore
const Plataforma = () => import('@/entities/plataforma/plataforma.vue');
// prettier-ignore
const PlataformaUpdate = () => import('@/entities/plataforma/plataforma-update.vue');
// prettier-ignore
const PlataformaDetails = () => import('@/entities/plataforma/plataforma-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/proyecto',
    name: 'Proyecto',
    component: Proyecto,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/proyecto/new',
    name: 'ProyectoCreate',
    component: ProyectoUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/proyecto/:proyectoId/edit',
    name: 'ProyectoEdit',
    component: ProyectoUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/proyecto/:proyectoId/view',
    name: 'ProyectoView',
    component: ProyectoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/celula',
    name: 'Celula',
    component: Celula,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/celula/new',
    name: 'CelulaCreate',
    component: CelulaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/celula/:celulaId/edit',
    name: 'CelulaEdit',
    component: CelulaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/celula/:celulaId/view',
    name: 'CelulaView',
    component: CelulaDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/participacion',
    name: 'Participacion',
    component: Participacion,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/participacion/new',
    name: 'ParticipacionCreate',
    component: ParticipacionUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/participacion/:participacionId/edit',
    name: 'ParticipacionEdit',
    component: ParticipacionUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/participacion/:participacionId/view',
    name: 'ParticipacionView',
    component: ParticipacionDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/area',
    name: 'Area',
    component: Area,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/area/new',
    name: 'AreaCreate',
    component: AreaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/area/:areaId/edit',
    name: 'AreaEdit',
    component: AreaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/area/:areaId/view',
    name: 'AreaView',
    component: AreaDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/persona',
    name: 'Persona',
    component: Persona,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/persona/new',
    name: 'PersonaCreate',
    component: PersonaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/persona/:personaId/edit',
    name: 'PersonaEdit',
    component: PersonaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/persona/:personaId/view',
    name: 'PersonaView',
    component: PersonaDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/badge',
    name: 'Badge',
    component: Badge,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/badge/new',
    name: 'BadgeCreate',
    component: BadgeUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/badge/:badgeId/edit',
    name: 'BadgeEdit',
    component: BadgeUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/badge/:badgeId/view',
    name: 'BadgeView',
    component: BadgeDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/avatar',
    name: 'Avatar',
    component: Avatar,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/avatar/new',
    name: 'AvatarCreate',
    component: AvatarUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/avatar/:avatarId/edit',
    name: 'AvatarEdit',
    component: AvatarUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/avatar/:avatarId/view',
    name: 'AvatarView',
    component: AvatarDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/rol',
    name: 'Rol',
    component: Rol,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/rol/new',
    name: 'RolCreate',
    component: RolUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/rol/:rolId/edit',
    name: 'RolEdit',
    component: RolUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/rol/:rolId/view',
    name: 'RolView',
    component: RolDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/plataforma',
    name: 'Plataforma',
    component: Plataforma,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/plataforma/new',
    name: 'PlataformaCreate',
    component: PlataformaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/plataforma/:plataformaId/edit',
    name: 'PlataformaEdit',
    component: PlataformaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/plataforma/:plataformaId/view',
    name: 'PlataformaView',
    component: PlataformaDetails,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
