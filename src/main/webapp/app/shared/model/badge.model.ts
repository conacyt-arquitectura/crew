export interface IBadge {
  id?: string;
  nombre?: string;
  descripcion?: any;
  logoContentType?: string;
  logo?: any;
}

export class Badge implements IBadge {
  constructor(public id?: string, public nombre?: string, public descripcion?: any, public logoContentType?: string, public logo?: any) {}
}
