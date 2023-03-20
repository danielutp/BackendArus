package co.com.sofka.jpa.afiliacion.afiliacionMappers;

import co.com.sofka.jpa.afiliacion.AfiliacionDto;
import co.com.sofka.model.afiliacion.Afiliacion;

import java.util.List;
import java.util.stream.Collectors;

import static co.com.sofka.jpa.asesor.asesorMappers.AsesorMappers.asesorDTOToAAsesor;
import static co.com.sofka.jpa.asesor.asesorMappers.AsesorMappers.asesorToAsesorDTO;
import static co.com.sofka.jpa.beneficiario.beneficiarioMappers.BeneficiarioMappers.beneficiarioDTOToABeneficiario;
import static co.com.sofka.jpa.beneficiario.beneficiarioMappers.BeneficiarioMappers.beneficiarioToBeneficiarioDTO;
import static co.com.sofka.jpa.causante.causanteMappers.CausanteMappers.causanteDTOToACausante;
import static co.com.sofka.jpa.causante.causanteMappers.CausanteMappers.causanteToCausanteDTO;
import static co.com.sofka.jpa.renta.rentaMappers.RentaMappers.rentaDTOToARenta;
import static co.com.sofka.jpa.renta.rentaMappers.RentaMappers.rentaToRentaDTO;

public class AfiliacionMappers {

    private AfiliacionMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static AfiliacionDto afiliacionAfiliacionDTO(Afiliacion afiliacion) {
        return AfiliacionDto.builder()
                .id(afiliacion.getId())
                .fechaAfiliacion(afiliacion.getFechaAfiliacion())
                .asesorDto(asesorToAsesorDTO(afiliacion.getAsesor()))
                .causanteDto(causanteToCausanteDTO(afiliacion.getCausante()))
                .beneficiarioDto(beneficiarioToBeneficiarioDTO(afiliacion.getBeneficiario()))
                .rentaDto(rentaToRentaDTO(afiliacion.getRenta()))
                .idBaseDatosCentralPensionesColombia(afiliacion.getIdSbdcpc())
                .build();
    }

    public static Afiliacion afiliacionDTOAfiliacion(AfiliacionDto afiliacionDTO) {
        return Afiliacion.builder()
                .id(afiliacionDTO.getId())
                .fechaAfiliacion(afiliacionDTO.getFechaAfiliacion())
                .asesor(asesorDTOToAAsesor(afiliacionDTO.getAsesorDto()))
                .causante(causanteDTOToACausante(afiliacionDTO.getCausanteDto()))
                .beneficiario(beneficiarioDTOToABeneficiario(afiliacionDTO.getBeneficiarioDto()))
                .renta(rentaDTOToARenta(afiliacionDTO.getRentaDto()))
                .idSbdcpc(afiliacionDTO.getIdBaseDatosCentralPensionesColombia())
                .build();
    }

     public static List<AfiliacionDto> afiliacionListAfiliacionListDto(List<Afiliacion> afiliacion) {
         return afiliacion.stream()
                 .map(AfiliacionMappers::afiliacionAfiliacionDTO)
                 .collect(Collectors.toList());
     }


        public static List<Afiliacion> afiliacionListDtoAfiliacionList(List<AfiliacionDto> afiliacionDTO) {
            return afiliacionDTO.stream()
                    .map(AfiliacionMappers::afiliacionDTOAfiliacion)
                    .collect(Collectors.toList());
        }



}
