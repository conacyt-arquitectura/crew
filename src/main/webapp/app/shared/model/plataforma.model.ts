export interface IPlataforma {
  id?: string;
  nombre?: string;
  color?: string;
  logoContentType?: string;
  logo?: any;
  clave?: string;
}

export class Plataforma implements IPlataforma {
  constructor(public id?: string, public nombre?: string, public color?: string, public logoContentType?: string, public logo?: any, public clave?: string) { }
}
