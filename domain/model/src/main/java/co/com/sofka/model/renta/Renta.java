package co.com.sofka.model.renta;
import co.com.sofka.model.afiliacion.Afiliacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Renta {
    private Integer id;
    private Date fechaSolicitud;
    private Double salario;
    private Integer mesesCotizando;
    private List<Afiliacion> afiliacionList;

}
