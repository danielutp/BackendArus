package co.com.sofka.model.causante;
import co.com.sofka.model.beneficiario.Beneficiario;
import co.com.sofka.model.persona.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Causante {

    Integer id;
    Persona persona;
    Beneficiario beneficiario;
}
