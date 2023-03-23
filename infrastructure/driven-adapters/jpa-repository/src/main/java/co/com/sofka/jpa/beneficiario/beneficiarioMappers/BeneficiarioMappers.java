package co.com.sofka.jpa.beneficiario.beneficiarioMappers;

import co.com.sofka.jpa.beneficiario.BeneficiarioDto;
import co.com.sofka.model.beneficiario.Beneficiario;

import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaDTOConvertirAPersona;
import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaConvertirAPersonaDTO;

public class BeneficiarioMappers {

    private BeneficiarioMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static Beneficiario beneficiarioDTOConvertirAABeneficiario(BeneficiarioDto beneficiarioDTO) {
        return Beneficiario.builder()
                .id(beneficiarioDTO.getId())
                .persona(personaDTOConvertirAPersona(beneficiarioDTO.getPersonaDto()))
                .estudiante(beneficiarioDTO.getEstudiante())
                .dependiente(beneficiarioDTO.getDependiente())
                .tipoBeneficiario(beneficiarioDTO.getTipoBeneficiario())
                .build();
    }

    public static BeneficiarioDto beneficiarioConvertirABeneficiarioDTO(Beneficiario beneficiario) {
        BeneficiarioDto beneficiarioDTO = new BeneficiarioDto();
        beneficiarioDTO.setId(beneficiario.getId());
        beneficiarioDTO.setEstudiante(beneficiario.getEstudiante());
        beneficiarioDTO.setDependiente(beneficiario.getDependiente());
        beneficiarioDTO.setTipoBeneficiario(beneficiario.getTipoBeneficiario());
        beneficiarioDTO.setPersonaDto(personaConvertirAPersonaDTO(beneficiario.getPersona()));
        return beneficiarioDTO;
    }
}