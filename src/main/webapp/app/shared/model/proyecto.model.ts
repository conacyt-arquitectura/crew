export interface IProyecto {
  id?: string;
  nombre?: string;
  clave?: string;
  logoContentType?: string;
  logo?: any;
  celulaId?: string;
  plataformaId?: string;
  areaId?: string;
}

export class Proyecto implements IProyecto {
  constructor(
    public id?: string,
    public nombre?: string,
    public clave?: string,
    public logoContentType?: string,
    public logo?: any,
    public celulaId?: string,
    public plataformaId?: string,
    public areaId?: string
  ) {}
}
