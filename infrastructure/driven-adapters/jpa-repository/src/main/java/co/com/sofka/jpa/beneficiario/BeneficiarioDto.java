package co.com.sofka.jpa.beneficiario;

import co.com.sofka.jpa.afiliacion.AfiliacionDto;
import co.com.sofka.jpa.persona.PersonaDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "beneficiario")
public class BeneficiarioDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estudiante")
    private Boolean estudiante;

    @Column(name = "dependiente")
    private Boolean dependiente;

    @Column(name = "tipoBeneficiario")
    private String tipoBeneficiario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona", referencedColumnName = "id")
    private PersonaDto personaDto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiarioDto")
    private List<AfiliacionDto> afiliacionDtoList;

}
