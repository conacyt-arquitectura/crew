export interface IAvatar {
  id?: string;
  isCircle?: boolean;
  avatarStyle?: string;
  circleColor?: string;
  accessoriesType?: string;
  clotheType?: string;
  clotheColor?: string;
  eyebrowType?: string;
  eyeType?: string;
  facialHairColor?: string;
  facialHairType?: string;
  graphicType?: string;
  hairColor?: string;
  mouthType?: string;
  skinColor?: string;
  topType?: string;
  topColor?: string;
}

export class Avatar implements IAvatar {
  constructor(
    public id?: string,
    public circle?: boolean,
    public avatarStyle?: string,
    public circleColor?: string,
    public accessoriesType?: string,
    public clotheType?: string,
    public clotheColor?: string,
    public eyebrowType?: string,
    public eyeType?: string,
    public facialHairColor?: string,
    public facialHairType?: string,
    public graphicType?: string,
    public hairColor?: string,
    public mouthType?: string,
    public skinColor?: string,
    public topType?: string,
    public topColor?: string,
    public human?: boolean
  ) {
    this.circle = this.circle || false;
    this.human = this.human || true;
    this.circleColor = this.circleColor || '#6fb8e0';
    this.accessoriesType = this.accessoriesType || 'Blank';
    this.clotheType = this.clotheType || 'ShirtCrewNeck';
    this.clotheColor = this.clotheColor || 'Black';
    this.eyebrowType = this.eyebrowType || 'Default';
    this.eyeType = this.eyeType || 'Default';
    this.facialHairColor = this.facialHairColor || 'Brown';
    this.facialHairType = this.facialHairType || 'Blank';
    this.graphicType = this.graphicType || 'Skull';
    this.hairColor = this.hairColor || 'BrownDark';
    this.mouthType = this.mouthType || 'Default';
    this.skinColor = this.skinColor || 'Pale';
    this.topType = this.topType || 'NoHair';
    this.topColor = this.topColor || 'Blue03';
  }
}
