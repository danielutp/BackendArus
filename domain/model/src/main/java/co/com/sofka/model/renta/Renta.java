package co.com.sofka.model.renta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Renta {
    Integer id;
    Date fechaSolicitud;
    Double salario;
    Integer mesesCotizando;

}
