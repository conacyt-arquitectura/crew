export interface ICelula {
  id?: string;
  nombre?: string;
  logoContentType?: string;
  logo?: any;
  plataformaId?: string;
  plataformaClave?: string;
  plataformaColor?: string;
}

export class Celula implements ICelula {
  constructor(
    public id?: string,
    public nombre?: string,
    public logoContentType?: string,
    public logo?: any,
    public plataformaId?: string,
    public plataformaClave?: string,
    public plataformaColor?: string
  ) { }
}
