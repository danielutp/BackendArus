package co.com.sofka.model.beneficiario;
import co.com.sofka.model.persona.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
