package co.com.sofka.jpa.afiliacion;

import co.com.sofka.jpa.asesor.AsesorDto;
import co.com.sofka.jpa.beneficiario.BeneficiarioDto;
import co.com.sofka.jpa.causante.CausanteDto;
import co.com.sofka.jpa.renta.RentaDto;
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
        private Integer id;

        @Column(name = "fechaAfiliacion")
        private Date fechaAfiliacion;

        @Column(name = "fondo")
        private String fondo;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idAsesor", referencedColumnName = "id")
        private AsesorDto asesorDto;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idCausante", referencedColumnName = "id")
        private CausanteDto causanteDto;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idBeneficiario", referencedColumnName = "id")
        private BeneficiarioDto beneficiarioDto;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idRenta", referencedColumnName = "id")
        private RentaDto rentaDto;

        @Column(name = "id_sbdcpc")
        private String idBaseDatosCentralPensionesColombia;

}

