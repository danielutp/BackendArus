package co.com.sofka.jpa.dto.beneficiario;

import co.com.sofka.jpa.dto.afiliacion.AfiliacionDto;
import co.com.sofka.jpa.dto.persona.PersonaDto;
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

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "estudiante")
    private Boolean estudiante;

    @NotNull
    @Column(name = "dependiente")
    private Boolean dependiente;

    @NotNull
    @Column(name = "tipoBeneficiario")
    private String tipoBeneficiario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private PersonaDto personaDto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiarioDto")
    private List<AfiliacionDto> afiliacionDtoList;

}
