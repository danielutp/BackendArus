package co.com.sofka.jpa.renta;

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
@Table(name = "renta")
public class RentaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fechaSolicitud")
    private Date fechaSolicitud;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "mesesCotizando")
    private Integer mesesCotizando;

}