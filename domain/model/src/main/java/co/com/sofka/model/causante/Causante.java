package co.com.sofka.model.causante;
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
    private Integer id;
    private String nick;
    private Persona persona;
}
