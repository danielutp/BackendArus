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

    private Integer id;
    private Integer identificacion;
    private String tipoIdentificacion;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String genero;

}