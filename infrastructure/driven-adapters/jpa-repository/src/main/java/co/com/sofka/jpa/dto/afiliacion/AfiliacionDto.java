package co.com.sofka.jpa.dto.afiliacion;

import co.com.sofka.jpa.dto.asesor.AsesorDto;
import co.com.sofka.jpa.dto.beneficiario.BeneficiarioDto;
import co.com.sofka.jpa.dto.causante.CausanteDto;
import co.com.sofka.jpa.dto.renta.RentaDto;
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
@Table(name = "afiliacion")
public class AfiliacionDto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Integer id;

        @NotNull
        @Column(name = "fechaAfiliacion")
        private Date fechaAfiliacion;

        @NotNull
        @Column(name = "fondoPensional")
        private String fondo;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id", referencedColumnName = "id")
        private AsesorDto asesorDto;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id", referencedColumnName = "id")
        private CausanteDto causanteDto;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id", referencedColumnName = "id")
        private BeneficiarioDto beneficiarioDto;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id", referencedColumnName = "id")
        private RentaDto rentaDto;

        @Column(name = "id_sbdcpc")
        private String idBaseDatosCentralPensionesColombia;

}

