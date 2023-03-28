package co.com.sofka.jpa.renta.rentaMappers;

import co.com.sofka.jpa.renta.RentaDto;
import co.com.sofka.model.renta.Renta;

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
                .build();
    }


    public static RentaDto rentaConvertirARentaDTO(Renta renta) {
        RentaDto rentaDTO = new RentaDto();
        rentaDTO.setId(renta.getId());
        rentaDTO.setFechaSolicitud(renta.getFechaSolicitud());
        rentaDTO.setMesesCotizando(renta.getMesesCotizando());
        rentaDTO.setSalario(renta.getSalario());
        return rentaDTO;
    }

}
