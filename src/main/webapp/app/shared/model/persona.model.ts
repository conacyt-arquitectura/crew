export interface IPersona {
  id?: string;
  nombre?: string;
  primerApellido?: string;
  segundoApellido?: string;
  correo?: string;
  resumen?: any;
  imagenContentType?: string;
  imagen?: any;
  avatarId?: string;
  areaId?: string;
  badgesId?: string;
}

export class Persona implements IPersona {
  constructor(
    public id?: string,
    public nombre?: string,
    public primerApellido?: string,
    public segundoApellido?: string,
    public correo?: string,
    public resumen?: any,
    public imagenContentType?: string,
    public imagen?: any,
    public avatarId?: string,
    public areaId?: string,
    public badgesId?: string
  ) {}
}
