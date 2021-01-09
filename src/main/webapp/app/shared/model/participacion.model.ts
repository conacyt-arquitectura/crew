export interface IParticipacion {
  id?: string;
  personaId?: string;
  rolId?: string;
  celulaId?: string;
}

export class Participacion implements IParticipacion {
  constructor(public id?: string, public personaId?: string, public rolId?: string, public celulaId?: string) { }
}
