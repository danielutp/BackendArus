package co.com.sofka.jpa.dto.persona;

import co.com.sofka.jpa.dto.asesor.AsesorDto;
import co.com.sofka.jpa.dto.beneficiario.BeneficiarioDto;
import co.com.sofka.jpa.dto.causante.CausanteDto;
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

    @NotNull
    @Column(name = "identificacion")
    private Integer identificacion;

    @NotNull
    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;

    @NotNull
    @Column(name = "nombres")
    private String nombres;

    @NotNull
    @Column(name = "apellidos")
    private String apellidos;

    @NotNull
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @NotNull
    @Column(name = "genero")
    private String genero;

    @OneToOne(mappedBy = "personaDto")
    private AsesorDto asesorDto;

    @OneToOne(mappedBy = "personaDto")
    private BeneficiarioDto beneficiarioDto;

    @OneToOne(mappedBy = "personaDto")
    private CausanteDto causanteDto;

}