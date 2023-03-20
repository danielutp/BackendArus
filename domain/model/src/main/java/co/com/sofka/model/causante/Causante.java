package co.com.sofka.model.causante;
import co.com.sofka.model.afiliacion.Afiliacion;
import co.com.sofka.model.beneficiario.Beneficiario;
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
public class Causante {

    private Integer id;
    private Persona persona;
    private List<Afiliacion> afiliacionList;
}
