
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
  { text: 'Blancos', value: 'Prescription01' },
  { text: 'Programador', value: 'Prescription02' },
  { text: 'Normales', value: 'Round' },
  { text: 'Solares ligeros', value: 'Sunglasses' },
  { text: 'Solares', value: 'Wayfarers' }
]

let clotheType = [
  { text: 'Camisa Blazer', value: 'BlazerShirt' },
  { text: 'Suéter Blazer', value: 'BlazerSweater' },
  { text: 'Suéter con cuello', value: 'CollarSweater' },
  { text: 'Playera estampada', value: 'GraphicShirt' },
  { text: 'Capucha', value: 'Hoodie' },
  { text: 'Overol', value: 'Overall' },
  { text: 'Cuello redondo', value: 'ShirtCrewNeck' },
  { text: 'Cuello redondo grande', value: 'ShirtScoopNeck' },
  { text: 'Cuello en V', value: 'ShirtVNeck' }
]

let clotheColor = [
  { text: 'black', value: 'Black' },
  { text: 'blue-claro', value: 'Blue01' },
  { text: 'blue-pastel', value: 'PastelBlue' },
  { text: 'blue-fuerte', value: 'Blue02' },
  { text: 'blue-rey', value: 'Blue03' },
  { text: 'gray-claro', value: 'Gray01' },
  { text: 'gray-fuerte', value: 'Gray02' },
  { text: 'gray-oxford', value: 'Heather' },
  { text: 'green-pastel', value: 'PastelGreen' },
  { text: 'orange-pastel', value: 'PastelOrange' },
  { text: 'red-pastel', value: 'PastelRed' },
  { text: 'yellow-pastel', value: 'PastelYellow' },
  { text: 'pink', value: 'Pink' },
  { text: 'red', value: 'Red' },
  { text: 'white', value: 'White' }
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
  { text: 'Llorando', value: 'Cry' },
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
  { text: 'Sin barba', value: 'Blank' },
  { text: 'Media', value: 'BeardMedium' },
  { text: 'Ligera', value: 'BeardLight' },
  { text: 'Abundante', value: 'BeardMagestic' },
  { text: 'Fantasía', value: 'MoustacheFancy' },
  { text: 'Magnum', value: 'MoustacheMagnum' }
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
  { text: 'auburn', value: 'Auburn' },
  { text: 'black', value: 'Black' },
  { text: 'blonde', value: 'Blonde' },
  { text: 'blolde-golden', value: 'BlondeGolden' },
  { text: 'brown', value: 'Brown' },
  { text: 'brown-dark', value: 'BrownDark' },
  { text: 'pink-pastel', value: 'PastelPink' },
  { text: 'platinum', value: 'Platinum' },
  { text: 'red', value: 'Red' },
  { text: 'gray-claro', value: 'SilverGray' }
]

let mouthType = [
  { text: 'Preocupado', value: 'Concerned' },
  { text: 'Normal', value: 'Default' },
  { text: 'Incredulo', value: 'Disbelief' },
  { text: 'Comiendo', value: 'Eating' },
  { text: 'Mueca', value: 'Grimace' },
  { text: 'Triste', value: 'Sad' },
  { text: 'Gritando', value: 'ScreamOpen' },
  { text: 'Serio', value: 'Serious' },
  { text: 'Sonriendo', value: 'Smile' },
  { text: 'Monstrando la lengua', value: 'Tongue' },
  { text: 'Confiado', value: 'Twinkle' },
  { text: 'Vomitando', value: 'Vomit' }
]

let skinColor = [
  { text: 'skin-tanned', value: 'Tanned' },
  { text: 'skin-yellow', value: 'Yellow' },
  { text: 'skin-light', value: 'Pale' },
  { text: 'skin-pale', value: 'Light' },
  { text: 'skin-brown', value: 'Brown' },
  { text: 'skin-dark-brown', value: 'DarkBrown' },
  { text: 'skin-dark-black', value: 'Black' }
]

let topType = [
  { text: 'Pelón', value: 'NoHair', type: 'pelon' },
  { text: 'Parche en ojo', value: 'Eyepatch', type: 'pelon' },
  { text: 'Sombrero', value: 'Hat', type: 'hat' },
  { text: 'Hijab', value: 'Hijab', type: 'hat' },
  { text: 'Turbante', value: 'Turban', type: 'hat' },
  { text: 'Invierno tradicional', value: 'WinterHat1', type: 'hat' },
  { text: 'Invierno indio ', value: 'WinterHat2', type: 'hat' },
  { text: 'Invierno clásico', value: 'WinterHat3', type: 'hat' },
  { text: 'Invierno con orejas', value: 'WinterHat4', type: 'hat' },
  { text: 'Largo', value: 'LongHairBigHair', type: 'hair' },
  { text: 'Corto Mediano', value: 'LongHairBob', type: 'hair' },
  { text: 'Chongo', value: 'LongHairBun', type: 'hair' },
  { text: 'Corto ondulado', value: 'LongHairCurly', type: 'hair' },
  { text: 'Largo ondulado', value: 'LongHairCurvy', type: 'hair' },
  { text: 'Rastas', value: 'LongHairDreads', type: 'hair' },
  { text: 'Frida kahlo', value: 'LongHairFrida', type: 'hair' },
  { text: 'Afro', value: 'LongHairFro', type: 'hair' },
  { text: 'Afro con banda', value: 'LongHairFroBand', type: 'hair' },
  { text: 'No muy largo', value: 'LongHairNotTooLong', type: 'hair' },
  { text: 'Largo con lados afeitados', value: 'LongHairShavedSides', type: 'hair' },
  { text: 'Largo con fleco', value: 'LongHairMiaWallace', type: 'hair' },
  { text: 'Largo planchado', value: 'LongHairStraight', type: 'hair' },
  { text: 'Largo medio planchado', value: 'LongHairStraight2', type: 'hair' },
  { text: 'Planchado estándar', value: 'LongHairStraightStrand', type: 'hair' },
  { text: 'Corto', value: 'ShortHairDreads01', type: 'hair' },
  { text: 'Corto rebelde', value: 'ShortHairDreads02', type: 'hair' },
  { text: 'Corto con frizz', value: 'ShortHairFrizzle', type: 'hair' },
  { text: 'Corto Shaggy Mullet', value: 'ShortHairShaggyMullet', type: 'hair' },
  { text: 'Corto y ondulado', value: 'ShortHairShortCurly', type: 'hair' },
  { text: 'Corto y plano', value: 'ShortHairShortFlat', type: 'hair' },
  { text: 'Corto redondeado', value: 'ShortHairShortRound', type: 'hair' },
  { text: 'Corto con ondas', value: 'ShortHairShortWaved', type: 'hair' },
  { text: 'Cabello a los lados', value: 'ShortHairSides', type: 'hair' },
  { text: 'Cesar', value: 'ShortHairTheCaesar', type: 'hair' },
  { text: 'Cesar levantado', value: 'ShortHairTheCaesarSidePart', type: 'hair' }
]

let topColor = [
  { text: 'dark', value: 'Black' },
  { text: 'blue-pastel', value: 'Blue01' },
  { text: 'blue-claro', value: 'Blue02' },
  { text: 'blue-fuerte', value: 'Blue03' },
  { text: 'gray-claro', value: 'Gray01' },
  { text: 'gray-fuerte', value: 'Gray02' },
  { text: 'gray-oxford', value: 'Heather' },
  { text: 'blue-pastel', value: 'PastelBlue' },
  { text: 'green-pastel', value: 'PastelGreen' },
  { text: 'orange-pastel', value: 'PastelOrange' },
  { text: 'red-pastel', value: 'PastelRed' },
  { text: 'yellow-pastel', value: 'PastelYellow' },
  { text: 'pink', value: 'Pink' },
  { text: 'red', value: 'Red' },
  { text: 'gray', value: 'White' }
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
