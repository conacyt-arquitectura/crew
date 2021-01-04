
export class Catalog {
  constructor(
    public accesoriesTypes?: any,
    public clotheType?: any,
    public clotheColor?: any,
    public eyebrowType?: any,
    public eyeType?: any,
    public facialHairColor?: any,
    public facialHairType?: any,
    public graphicType?: any,
    public hairColor?: any,
    public mouthType?: any,
    public skinColor?: any,
    public topType?: any,
    public topColor?: any
  ) { }
}
let accesoriesTypes = [
  { text: 'Sin lentes', value: 'Blank' },
  { text: 'Diva', value: 'Kurt' },
  { text: 'blancos', value: 'Prescription01' },
  { text: 'nerd', value: 'Prescription02' },
  { text: 'normales', value: 'Round' },
  { text: 'solares ligeros', value: 'Sunglasses' },
  { text: 'solares', value: 'Wayfarers' }
]

let clotheType = [
  { text: 'Camisa Blazer', value: 'BlazerShirt' },
  { text: 'Suéter Blazer', value: 'BlazerSweater' },
  { text: 'Suéter con cuello', value: 'CollarSweater' },
  { text: 'Playera con dibujo', value: 'GraphicShirt' },
  { text: 'Capucha', value: 'Hoodie' },
  { text: 'Overol', value: 'Overall' },
  { text: 'Cuello redondo', value: 'ShirtCrewNeck' },
  { text: 'Cuello redondo grande', value: 'ShirtScoopNeck' },
  { text: 'Cuello en V', value: 'ShirtVNeck' }
]

let clotheColor = [
  { text: 'negro', value: 'Black' },
  { text: 'azul-claro', value: 'Blue01' },
  { text: 'azul-pastel', value: 'PastelBlue' },
  { text: 'azul-fuerte', value: 'Blue02' },
  { text: 'azul-rey', value: 'Blue03' },
  { text: 'gris-claro', value: 'Gray01' },
  { text: 'gris-fuerte', value: 'Gray02' },
  { text: 'gris-oxford', value: 'Heather' },
  { text: 'verde-pastel', value: 'PastelGreen' },
  { text: 'naranja-pastel', value: 'PastelOrange' },
  { text: 'rojo-pastel', value: 'PastelRed' },
  { text: 'amarillo-pastel', value: 'PastelYellow' },
  { text: 'rosa', value: 'Pink' },
  { text: 'rojo', value: 'Red' },
  { text: 'blanco', value: 'White' }
]

let eyebrowType = [
  { text: 'Enojado', value: 'Angry' },
  { text: 'Ejonado natural', value: 'AngryNatural' },
  { text: 'Normal', value: 'Default' },
  { text: 'Normal natural', value: 'DefaultNatural' },
  { text: 'Plano natural', value: 'FlatNatural' },
  { text: 'Emocionado', value: 'RaisedExcited' },
  { text: 'Emocionado natural', value: 'RaisedExcitedNatural' },
  { text: 'Triste', value: 'SadConcerned' },
  { text: 'Desconcertado', value: 'SadConcernedNatural' },
  { text: 'Una ceja', value: 'UnibrowNatural' },
  { text: 'Ceja levantada', value: 'UpDown' },
  { text: 'Ceja levantada natural', value: 'UpDownNatural' }
]

let eyeType = [
  { text: 'Cerrados', value: 'Close' },
  { text: 'LLorando', value: 'Cry' },
  { text: 'Normal', value: 'Default' },
  { text: 'Mareado', value: 'Dizzy' },
  { text: 'Mirada', value: 'EyeRoll' },
  { text: 'Feliz', value: 'Happy' },
  { text: 'Enamorado', value: 'Hearts' },
  { text: 'mirando a la derecha', value: 'Side' },
  { text: 'Estrabismo', value: 'Squint' },
  { text: 'Sorprendido', value: 'Surprised' },
  { text: 'Guiñando', value: 'Wink' },
  { text: 'Guiño loco', value: 'WinkWacky' }
]

let facialHairColor = [
  { text: 'Castaño', value: 'Auburn' },
  { text: 'Negro', value: 'Black' },
  { text: 'Rubio', value: 'Blonde' },
  { text: 'Dorado', value: 'BlondeGolden' },
  { text: 'Cafe claro', value: 'Brown' },
  { text: 'Cafe obscuro', value: 'BrownDark' },
  { text: 'Rosa pastel', value: 'PastelPink' },
  { text: 'Plateado', value: 'Platinum' },
  { text: 'Rojo', value: 'Red' },
  { text: 'Plateado', value: 'SilverGray' }
]

let facialHairType = [
  { text: 'Option 1', value: 'Blank' },
  { text: 'Option 1', value: 'BeardMedium' },
  { text: 'Option 1', value: 'BeardLight' },
  { text: 'Option 1', value: 'BeardMagestic' },
  { text: 'Option 1', value: 'MoustacheFancy' },
  { text: 'Option 1', value: 'MoustacheMagnum' }
]

let graphicType = [
  { text: 'Batman', value: 'Bat' },
  { text: 'Cumbia', value: 'Cumbia' },
  { text: 'Venado', value: 'Deer' },
  { text: 'Diamante', value: 'Diamond' },
  { text: 'Hola', value: 'Hola' },
  { text: 'Pizza', value: 'Pizza' },
  { text: 'Resistencia', value: 'Resist' },
  { text: 'Selena', value: 'Selena' },
  { text: 'Oso', value: 'Bear' },
  { text: 'Calabera rellena', value: 'SkullOutline' },
  { text: 'Calabera', value: 'Skull' }
]

let hairColor = [
  { text: 'Option 1', value: 'Auburn' },
  { text: 'Option 1', value: 'Black' },
  { text: 'Option 1', value: 'Blonde' },
  { text: 'Option 1', value: 'BlondeGolden' },
  { text: 'Option 1', value: 'Brown' },
  { text: 'Option 1', value: 'BrownDark' },
  { text: 'Option 1', value: 'PastelPink' },
  { text: 'Option 1', value: 'Platinum' },
  { text: 'Option 1', value: 'Red' },
  { text: 'Option 1', value: 'SilverGray' }
]

let mouthType = [
  { text: 'Option 1', value: 'Concerned' },
  { text: 'Option 1', value: 'Default' },
  { text: 'Option 1', value: 'Disbelief' },
  { text: 'Option 1', value: 'Eating' },
  { text: 'Option 1', value: 'Grimace' },
  { text: 'Option 1', value: 'Sad' },
  { text: 'Option 1', value: 'ScreamOpen' },
  { text: 'Option 1', value: 'Serious' },
  { text: 'Option 1', value: 'Smile' },
  { text: 'Option 1', value: 'Tongue' },
  { text: 'Option 1', value: 'Twinkle' },
  { text: 'Option 1', value: 'Vomit' }
]

let skinColor = [
  { text: 'Option 1', value: 'Tanned' },
  { text: 'Option 1', value: 'Yellow' },
  { text: 'Option 1', value: 'Pale' },
  { text: 'Option 1', value: 'Light' },
  { text: 'Option 1', value: 'Brown' },
  { text: 'Option 1', value: 'DarkBrown' },
  { text: 'Option 1', value: 'Black' }
]

let topType = [
  { text: 'Option 1', value: 'NoHair' },
  { text: 'Option 1', value: 'Eyepatch' },
  { text: 'Option 1', value: 'Hat' },
  { text: 'Option 1', value: 'Hijab' },
  { text: 'Option 1', value: 'Turban' },
  { text: 'Option 1', value: 'WinterHat1' },
  { text: 'Option 1', value: 'WinterHat2' },
  { text: 'Option 1', value: 'WinterHat3' },
  { text: 'Option 1', value: 'WinterHat4' },
  { text: 'Option 1', value: 'LongHairBigHair' },
  { text: 'Option 1', value: 'LongHairBob' },
  { text: 'Option 1', value: 'LongHairBun' },
  { text: 'Option 1', value: 'LongHairCurly' },
  { text: 'Option 1', value: 'LongHairCurvy' },
  { text: 'Option 1', value: 'LongHairDreads' },
  { text: 'Option 1', value: 'LongHairFrida' },
  { text: 'Option 1', value: 'LongHairFro' },
  { text: 'Option 1', value: 'LongHairFroBand' },
  { text: 'Option 1', value: 'LongHairNotTooLong' },
  { text: 'Option 1', value: 'LongHairShavedSides' },
  { text: 'Option 1', value: 'LongHairMiaWallace' },
  { text: 'Option 1', value: 'LongHairStraight' },
  { text: 'Option 1', value: 'LongHairStraight2' },
  { text: 'Option 1', value: 'LongHairStraightStrand' },
  { text: 'Option 1', value: 'ShortHairDreads01' },
  { text: 'Option 1', value: 'ShortHairDreads02' },
  { text: 'Option 1', value: 'ShortHairFrizzle' },
  { text: 'Option 1', value: 'ShortHairShaggyMullet' },
  { text: 'Option 1', value: 'ShortHairShortCurly' },
  { text: 'Option 1', value: 'ShortHairShortFlat' },
  { text: 'Option 1', value: 'ShortHairShortRound' },
  { text: 'Option 1', value: 'ShortHairShortWaved' },
  { text: 'Option 1', value: 'ShortHairSides' },
  { text: 'Option 1', value: 'ShortHairTheCaesar' },
  { text: 'Option 1', value: 'ShortHairTheCaesarSidePart' }
]

let topColor = [
  { text: 'Option 1', value: 'Black' },
  { text: 'Option 1', value: 'Blue01' },
  { text: 'Option 1', value: 'Blue02' },
  { text: 'Option 1', value: 'Blue03' },
  { text: 'Option 1', value: 'Gray01' },
  { text: 'Option 1', value: 'Gray02' },
  { text: 'Option 1', value: 'Heather' },
  { text: 'Option 1', value: 'PastelBlue' },
  { text: 'Option 1', value: 'PastelGreen' },
  { text: 'Option 1', value: 'PastelOrange' },
  { text: 'Option 1', value: 'PastelRed' },
  { text: 'Option 1', value: 'PastelYellow' },
  { text: 'Option 1', value: 'Pink' },
  { text: 'Option 1', value: 'Red' },
  { text: 'Option 1', value: 'White' }
]

export let AvatarCatalog = new Catalog(
  accesoriesTypes,
  clotheType,
  clotheColor,
  eyebrowType,
  eyeType,
  facialHairColor,
  facialHairType,
  graphicType,
  hairColor,
  mouthType,
  skinColor,
  topType,
  topColor
);
