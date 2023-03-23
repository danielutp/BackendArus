package co.com.sofka.jpa.asesor.asesorMappers;

import co.com.sofka.jpa.asesor.AsesorDto;
import co.com.sofka.model.asesor.Asesor;

import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaDTOConvertirAPersona;
import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaConvertirAPersonaDTO;

public class AsesorMappers {

    private AsesorMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static Asesor asesorDTOConvertirAAsesor(AsesorDto asesorDTO) {
        return Asesor.builder()
                .id(asesorDTO.getId())
                .nombre(asesorDTO.getNombre())
                .persona(personaDTOConvertirAPersona(asesorDTO.getPersonaDto()))
                .build();
    }

    public static AsesorDto asesorConvertirAAsesorDTO(Asesor asesor) {
        AsesorDto asesorDTO = new AsesorDto();
        asesorDTO.setId(asesor.getId());
        asesorDTO.setNombre(asesor.getNombre());
        asesorDTO.setPersonaDto(personaConvertirAPersonaDTO(asesor.getPersona()));
        return asesorDTO;
    }
}
