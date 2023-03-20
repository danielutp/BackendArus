package co.com.sofka.jpa.asesor.asesorMappers;

import co.com.sofka.jpa.asesor.AsesorDto;
import co.com.sofka.model.asesor.Asesor;

import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListAfiliacionListDto;
import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListDtoAfiliacionList;
import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaDTOToAPersona;
import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaToPersonaDTO;

public class AsesorMappers {

    private AsesorMappers() {
        throw new IllegalStateException("Utility class");
    }


    public static Asesor asesorDTOToAAsesor(AsesorDto asesorDTO) {
        return Asesor.builder()
                .id(asesorDTO.getId())
                .persona(personaDTOToAPersona(asesorDTO.getPersonaDto()))
                .nombre(asesorDTO.getNombre())
                .afiliacionList(afiliacionListDtoAfiliacionList(asesorDTO.getAfiliacionDtoList()))
                .build();
    }


    public static AsesorDto asesorToAsesorDTO(Asesor asesor) {
        AsesorDto asesorDTO = new AsesorDto();
        asesorDTO.setId(asesor.getId());
        asesorDTO.setPersonaDto(personaToPersonaDTO(asesor.getPersona()));
        asesorDTO.setNombre(asesor.getNombre());
        asesorDTO.setAfiliacionDtoList(afiliacionListAfiliacionListDto(asesor.getAfiliacionList()));
        return asesorDTO;
    }
}
