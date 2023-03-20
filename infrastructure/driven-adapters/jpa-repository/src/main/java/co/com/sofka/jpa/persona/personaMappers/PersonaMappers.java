package co.com.sofka.jpa.persona.personaMappers;


import co.com.sofka.jpa.persona.PersonaDto;
import co.com.sofka.model.persona.Persona;

public class PersonaMappers {

    public PersonaMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static Persona personaDTOToAPersona(PersonaDto personaDTO) {
        return Persona.builder()
                .id(personaDTO.getId())
                .identificacion(personaDTO.getIdentificacion())
                .tipoIdentificacion(personaDTO.getTipoIdentificacion())
                .nombres(personaDTO.getNombres())
                .apellidos(personaDTO.getApellidos())
                .fechaNacimiento(personaDTO.getFechaNacimiento())
                .genero(personaDTO.getGenero())
                .build();
    }


    public static PersonaDto personaToPersonaDTO(Persona persona) {
        PersonaDto personaDTO = new PersonaDto();
        personaDTO.setId(persona.getId());
        personaDTO.setIdentificacion(persona.getIdentificacion());
        personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
        personaDTO.setNombres(persona.getNombres());
        personaDTO.setApellidos(persona.getApellidos());
        personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
        personaDTO.setGenero(persona.getGenero());
        return personaDTO;
    }


}
