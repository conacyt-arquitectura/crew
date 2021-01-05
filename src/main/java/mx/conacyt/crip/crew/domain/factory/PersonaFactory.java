package mx.conacyt.crip.crew.domain.factory;

import mx.conacyt.crip.crew.domain.Avatar;
import mx.conacyt.crip.crew.domain.Persona;

public class PersonaFactory {

    private PersonaFactory() {}

    public static final Persona createPersona() {
        return new Persona().avatar(createAvatar());
    }

    public static final Avatar createAvatar() {
        return new Avatar()
            .circleColor("#6fb8e0")
            .isHuman(true)
            .isCircle(false)
            .accessoriesType("Blank")
            .clotheType("ShirtCrewNeck")
            .clotheColor("Black")
            .eyebrowType("Default")
            .eyeType("Default")
            .facialHairColor("Brown")
            .facialHairType("Blank")
            .graphicType("Skull")
            .hairColor("BrownDark")
            .mouthType("Default")
            .skinColor("Pale")
            .topType("NoHair")
            .topColor("Blue03");
    }
}
