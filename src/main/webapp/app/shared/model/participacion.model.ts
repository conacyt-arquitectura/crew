export interface IParticipacion {
  id?: string;
  personaId?: string;
  rolId?: string;
}

export class Participacion implements IParticipacion {
  constructor(public id?: string, public personaId?: string, public rolId?: string) {}
}
