export interface IRol {
  id?: string;
  nombre?: string;
  clave?: string;
  logoContentType?: string;
  logo?: any;
}

export class Rol implements IRol {
  constructor(public id?: string, public nombre?: string, public clave?: string, public logoContentType?: string, public logo?: any) {}
}
