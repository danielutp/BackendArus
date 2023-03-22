package co.com.sofka.jpa.asesor.asesorMappers;

import co.com.sofka.jpa.asesor.AsesorDto;
import co.com.sofka.model.asesor.Asesor;

import java.util.List;
import java.util.stream.Collectors;

import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListAfiliacionListDto;
import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListDtoAfiliacionList;
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
                .afiliacionList(afiliacionListDtoAfiliacionList(asesorDTO.getAfiliacionDtoList()))
                .build();
    }

    public static AsesorDto asesorConvertirAAsesorDTO(Asesor asesor) {
        AsesorDto asesorDTO = new AsesorDto();
        asesorDTO.setId(asesor.getId());
        asesorDTO.setPersonaDto(personaConvertirAPersonaDTO(asesor.getPersona()));
        asesorDTO.setNombre(asesor.getNombre());
        asesorDTO.setAfiliacionDtoList(afiliacionListAfiliacionListDto(asesor.getAfiliacionList()));
        return asesorDTO;
    }
}
