export interface IParticipacion {
  id?: string;
  personaId?: string;
  participante?: string;
  rolId?: string;
  rol?: string;
  celulaId?: string;
  celula?: string;
}

export class Participacion implements IParticipacion {
  constructor(
    public id?: string,
    public personaId?: string,
    public participante?: string,
    public rolId?: string,
    public rol?: string,
    public celulaId?: string,
    public celula?: string
  ) { }
}
