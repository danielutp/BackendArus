package co.com.sofka.model.asesor;
import co.com.sofka.model.persona.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Asesor {
    private Integer id;
    private String nombre;
    private Persona persona;

}