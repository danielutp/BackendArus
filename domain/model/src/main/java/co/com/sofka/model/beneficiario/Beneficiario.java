package co.com.sofka.model.beneficiario;
import co.com.sofka.model.persona.Persona;
import com.sun.deploy.perf.PerfRollup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Beneficiario {
    Integer id;
    Boolean estudiante;
    Boolean dependiente;
    String tipoBeneficiario;
    Persona persona;
}
