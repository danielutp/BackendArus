package co.com.sofka.jpa.beneficiario.beneficiarioMappers;

import co.com.sofka.jpa.beneficiario.BeneficiarioDto;
import co.com.sofka.model.beneficiario.Beneficiario;

import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListAfiliacionListDto;
import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListDtoAfiliacionList;
import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaDTOToAPersona;
import static co.com.sofka.jpa.persona.personaMappers.PersonaMappers.personaToPersonaDTO;

public class BeneficiarioMappers {

    private BeneficiarioMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static Beneficiario beneficiarioDTOToABeneficiario(BeneficiarioDto beneficiarioDTO) {
        return Beneficiario.builder()
                .id(beneficiarioDTO.getId())
                .persona(personaDTOToAPersona(beneficiarioDTO.getPersonaDto()))
                .estudiante(beneficiarioDTO.getEstudiante())
                .dependiente(beneficiarioDTO.getDependiente())
                .tipoBeneficiario(beneficiarioDTO.getTipoBeneficiario())
                .afiliacionList(afiliacionListDtoAfiliacionList(beneficiarioDTO.getAfiliacionDtoList()))
                .build();
    }

    public static BeneficiarioDto beneficiarioToBeneficiarioDTO(Beneficiario beneficiario) {
        BeneficiarioDto beneficiarioDTO = new BeneficiarioDto();
        beneficiarioDTO.setId(beneficiario.getId());
        beneficiarioDTO.setEstudiante(beneficiario.getEstudiante());
        beneficiarioDTO.setDependiente(beneficiario.getDependiente());
        beneficiarioDTO.setTipoBeneficiario(beneficiario.getTipoBeneficiario());
        beneficiarioDTO.setPersonaDto(personaToPersonaDTO(beneficiario.getPersona()));
        beneficiarioDTO.setAfiliacionDtoList(afiliacionListAfiliacionListDto(beneficiario.getAfiliacionList()));
        return beneficiarioDTO;
    }
}