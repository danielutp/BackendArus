package co.com.sofka.jpa.renta.rentaMappers;


import co.com.sofka.jpa.renta.RentaDto;
import co.com.sofka.model.renta.Renta;

import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListAfiliacionListDto;
import static co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers.afiliacionListDtoAfiliacionList;

public class RentaMappers {
    private RentaMappers() {
        throw new IllegalStateException("Utility class");
    }


    public static Renta rentaDTOConvertirARenta(RentaDto rentaDTO) {
        return Renta.builder()
                .id(rentaDTO.getId())
                .fechaSolicitud(rentaDTO.getFechaSolicitud())
                .mesesCotizando(rentaDTO.getMesesCotizando())
                .salario(rentaDTO.getSalario())
                .afiliacionList(afiliacionListDtoAfiliacionList(rentaDTO.getAfiliacionDtoList()))
                .build();
    }


    public static RentaDto rentaConvertirARentaDTO(Renta renta) {
        RentaDto rentaDTO = new RentaDto();
        rentaDTO.setId(renta.getId());
        rentaDTO.setFechaSolicitud(renta.getFechaSolicitud());
        rentaDTO.setMesesCotizando(renta.getMesesCotizando());
        rentaDTO.setSalario(renta.getSalario());
        rentaDTO.setAfiliacionDtoList(afiliacionListAfiliacionListDto(renta.getAfiliacionList()));
        return rentaDTO;
    }

}
