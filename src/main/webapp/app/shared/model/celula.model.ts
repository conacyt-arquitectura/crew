export interface ICelula {
  id?: string;
  nombre?: string;
  logoContentType?: string;
  logo?: any;
}

export class Celula implements ICelula {
  constructor(public id?: string, public nombre?: string, public logoContentType?: string, public logo?: any) {}
}
