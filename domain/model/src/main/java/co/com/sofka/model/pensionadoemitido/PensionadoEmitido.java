package co.com.sofka.model.pensionadoemitido;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PensionadoEmitido {

    private final Integer idfondo = 1;

    private Integer identificacion;

}
