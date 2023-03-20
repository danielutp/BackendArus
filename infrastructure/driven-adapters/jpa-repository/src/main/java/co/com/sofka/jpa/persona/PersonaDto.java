package co.com.sofka.jpa.persona;

import co.com.sofka.jpa.asesor.AsesorDto;
import co.com.sofka.jpa.beneficiario.BeneficiarioDto;
import co.com.sofka.jpa.causante.CausanteDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "persona")
public class PersonaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "identificacion")
    private Integer identificacion;

    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "genero")
    private String genero;

    @OneToOne(mappedBy = "personaDto")
    private AsesorDto asesorDto;

    @OneToOne(mappedBy = "personaDto")
    private BeneficiarioDto beneficiarioDto;

    @OneToOne(mappedBy = "personaDto")
    private CausanteDto causanteDto;

}