package co.com.sofka.jpa.asesor;

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
@Table(name = "asesor")
public class AsesorDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", referencedColumnName = "id")
    private PersonaDto personaDto;

}