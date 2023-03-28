package co.com.sofka.jpa.afiliacion.afiliacionmappers;

import co.com.sofka.jpa.afiliacion.AfiliacionDto;
import co.com.sofka.model.afiliacion.Afiliacion;

import static co.com.sofka.jpa.asesor.asesorMappers.AsesorMappers.asesorDTOConvertirAAsesor;
import static co.com.sofka.jpa.asesor.asesorMappers.AsesorMappers.asesorConvertirAAsesorDTO;
import static co.com.sofka.jpa.beneficiario.beneficiarioMappers.BeneficiarioMappers.beneficiarioDTOConvertirAABeneficiario;
import static co.com.sofka.jpa.beneficiario.beneficiarioMappers.BeneficiarioMappers.beneficiarioConvertirABeneficiarioDTO;
import static co.com.sofka.jpa.causante.causanteMappers.CausanteMappers.causanteDTOConvertirAACausante;
import static co.com.sofka.jpa.causante.causanteMappers.CausanteMappers.causanteConvertirACausanteDTO;
import static co.com.sofka.jpa.renta.rentaMappers.RentaMappers.rentaDTOConvertirARenta;
import static co.com.sofka.jpa.renta.rentaMappers.RentaMappers.rentaConvertirARentaDTO;

public class AfiliacionMappers {

    private AfiliacionMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static AfiliacionDto afiliacionConvertirAAfiliacionDTO(Afiliacion afiliacion) {
        return AfiliacionDto.builder()
                .id(afiliacion.getId())
                .fechaAfiliacion(afiliacion.getFechaAfiliacion())
                .asesorDto(asesorConvertirAAsesorDTO(afiliacion.getAsesor()))
                .causanteDto(causanteConvertirACausanteDTO(afiliacion.getCausante()))
                .beneficiarioDto(beneficiarioConvertirABeneficiarioDTO(afiliacion.getBeneficiario()))
                .rentaDto(rentaConvertirARentaDTO(afiliacion.getRenta()))
                .idBaseDatosCentralPensionesColombia(afiliacion.getIdSbdcpc())
                .build();
    }

    public static Afiliacion afiliacionDtoConvertirAAfiliacion(AfiliacionDto afiliacionDTO) {
        return Afiliacion.builder()
                .id(afiliacionDTO.getId())
                .fechaAfiliacion(afiliacionDTO.getFechaAfiliacion())
                .asesor(asesorDTOConvertirAAsesor(afiliacionDTO.getAsesorDto()))
                .causante(causanteDTOConvertirAACausante(afiliacionDTO.getCausanteDto()))
                .beneficiario(beneficiarioDTOConvertirAABeneficiario(afiliacionDTO.getBeneficiarioDto()))
                .renta(rentaDTOConvertirARenta(afiliacionDTO.getRentaDto()))
                .idSbdcpc(afiliacionDTO.getIdBaseDatosCentralPensionesColombia())
                .build();
    }

}