package co.com.sofka.jpa.dto.causante;

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
@Table(name = "causante")
public class CausanteDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private PersonaDto personaDto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "causanteDto")
    private List<AfiliacionDto> afiliacionDtoList;

}
