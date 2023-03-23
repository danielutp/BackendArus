package co.com.sofka.jpa.causante.causanteMappers;

import co.com.sofka.jpa.causante.CausanteDto;
import co.com.sofka.jpa.persona.personaMappers.PersonaMappers;
import co.com.sofka.model.causante.Causante;

import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaDTOConvertirAPersona;

public class CausanteMappers {

    private CausanteMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static Causante causanteDTOConvertirAACausante(CausanteDto causanteDTO) {
        return Causante.builder()
                .id(causanteDTO.getId())
                .nick(causanteDTO.getNick())
                .persona(personaDTOConvertirAPersona(causanteDTO.getPersonaDto()))
                .build();
    }

    public static CausanteDto causanteConvertirACausanteDTO(Causante causante) {
        CausanteDto causanteDTO = new CausanteDto();
        causanteDTO.setId(causante.getId());
        causanteDTO.setNick(causante.getNick());
        causanteDTO.setPersonaDto(PersonaMappers.personaConvertirAPersonaDTO(causante.getPersona()));
        return causanteDTO;
    }

}