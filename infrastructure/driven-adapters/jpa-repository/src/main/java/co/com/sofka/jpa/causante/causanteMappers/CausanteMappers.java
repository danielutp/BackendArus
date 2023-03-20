package co.com.sofka.jpa.causante.causanteMappers;

import co.com.sofka.jpa.causante.CausanteDto;
import co.com.sofka.jpa.persona.personaMappers.PersonaMappers;
import co.com.sofka.model.causante.Causante;

import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListAfiliacionListDto;
import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListDtoAfiliacionList;
import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaDTOToAPersona;

public class CausanteMappers {

    private CausanteMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static Causante causanteDTOToACausante(CausanteDto causanteDTO) {
        return Causante.builder()
                .id(causanteDTO.getId())
                .persona(personaDTOToAPersona(causanteDTO.getPersonaDto()))
                .afiliacionList(afiliacionListDtoAfiliacionList(causanteDTO.getAfiliacionDtoList()))
                .build();
    }


    public static CausanteDto causanteToCausanteDTO(Causante causante) {
        CausanteDto causanteDTO = new CausanteDto();
        causanteDTO.setId(causante.getId());
        causanteDTO.setPersonaDto(PersonaMappers.personaToPersonaDTO(causante.getPersona()));
        causanteDTO.setAfiliacionDtoList(afiliacionListAfiliacionListDto(causante.getAfiliacionList()));
        return causanteDTO;
    }


}

