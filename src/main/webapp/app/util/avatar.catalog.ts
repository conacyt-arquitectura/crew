
export class Catalog {
  constructor(
    public accesoriesTypes?: any,
    public clotheType?: any,
    public clotheColor?: any,
    public eyebrowType?: any
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
  { text: 'Option 1', value: 'BlazerShirt' },
  { text: 'Option 2', value: 'BlazerSweater' },
  { text: 'Option 3', value: 'CollarSweater' },
  { text: 'Option 4', value: 'GraphicShirt' },
  { text: 'Option 5', value: 'Hoodie' },
  { text: 'Option 6', value: 'Overall' },
  { text: 'Option 7', value: 'ShirtCrewNeck' },
  { text: 'Option 8', value: 'ShirtScoopNeck' },
  { text: 'Option 9', value: 'ShirtVNeck' }
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
  { text: 'Option 1', value: 'Angry' },
  { text: 'Option 2', value: 'AngryNatural' },
  { text: 'Option 3', value: 'Default' },
  { text: 'Option 4', value: 'DefaultNatural' },
  { text: 'Option 5', value: 'FlatNatural' },
  { text: 'Option 6', value: 'RaisedExcited' },
  { text: 'Option 7', value: 'RaisedExcitedNatural' },
  { text: 'Option 8', value: 'SadConcerned' },
  { text: 'Option 8', value: 'SadConcernedNatural' },
  { text: 'Option 8', value: 'UnibrowNatural' },
  { text: 'Option 8', value: 'UpDown' },
  { text: 'Option 9', value: 'UpDownNatural' }
]
export let AvatarCatalog = new Catalog(accesoriesTypes, clotheType, clotheColor, eyebrowType);
