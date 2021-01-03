export interface IArea {
  id?: string;
  nombre?: string;
  responsable?: string;
  correo?: string;
  areaId?: string;
}

export class Area implements IArea {
  constructor(public id?: string, public nombre?: string, public responsable?: string, public correo?: string, public areaId?: string) {}
}
