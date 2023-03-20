package co.com.sofka.jpa.renta;

import co.com.sofka.jpa.afiliacion.AfiliacionDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "causante")
public class RentaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fechaSolicitud")
    private Date fechaSolicitud;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "mesesCotizando")
    private Integer mesesCotizando;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rentaDto")
    private List<AfiliacionDto> afiliacionDtoList;
}
