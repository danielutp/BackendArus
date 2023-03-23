package co.com.sofka.jpa.causante;

import co.com.sofka.jpa.persona.PersonaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "causante")
public class CausanteDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nick;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", referencedColumnName = "id")
    private PersonaDto personaDto;

}
