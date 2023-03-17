package co.com.sofka.model.persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Persona {

    Integer id;
    Integer identificacion;
    String tipoIdentificacion;
    String nombres;
    String apellidos;
    Date fechaNacimiento;
    String genero;

}