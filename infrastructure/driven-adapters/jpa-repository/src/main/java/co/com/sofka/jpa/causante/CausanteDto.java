package co.com.sofka.jpa.causante;

import co.com.sofka.jpa.afiliacion.AfiliacionDto;
import co.com.sofka.jpa.persona.PersonaDto;
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
@Table(name = "causante")
public class CausanteDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona", referencedColumnName = "id")
    private PersonaDto personaDto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "causanteDto")
    private List<AfiliacionDto> afiliacionDtoList;

}
