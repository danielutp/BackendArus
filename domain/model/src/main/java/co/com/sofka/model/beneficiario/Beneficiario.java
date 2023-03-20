package co.com.sofka.model.beneficiario;
import co.com.sofka.model.afiliacion.Afiliacion;
import co.com.sofka.model.persona.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Beneficiario {
    private Integer id;
    private Boolean estudiante;
    private Boolean dependiente;
    private String tipoBeneficiario;
    private Persona persona;
    private List<Afiliacion> afiliacionList;
}
