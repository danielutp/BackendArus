package co.com.sofka.model.afiliacion;
import co.com.sofka.model.asesor.Asesor;
import co.com.sofka.model.beneficiario.Beneficiario;
import co.com.sofka.model.causante.Causante;
import co.com.sofka.model.renta.Renta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Afiliacion {

    private Integer id;
    private Date fechaAfiliacion;
    private String fondo;
    private Renta renta;
    private Asesor asesor;
    private Beneficiario beneficiario;
    private Causante causante;
    private String idSbdcpc;
}
