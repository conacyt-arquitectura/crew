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
    public isCircle?: boolean,
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
    public topColor?: string
  ) {
    this.isCircle = this.isCircle || false;
  }
}
