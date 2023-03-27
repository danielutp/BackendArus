package co.com.sofka.usecase.afiliacion;

import co.com.sofka.model.afiliacion.Afiliacion;
import co.com.sofka.model.afiliacion.gateways.AfiliacionRepository;
import co.com.sofka.model.asesor.Asesor;
import co.com.sofka.model.beneficiario.Beneficiario;
import co.com.sofka.model.causante.Causante;
import co.com.sofka.model.persona.Persona;
import co.com.sofka.model.renta.Renta;
import co.com.sofka.model.renta.gateways.RentaRepository;
import co.com.sofka.usecase.renta.RentaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;


@ExtendWith(MockitoExtension.class)
class AfiliacionUseCaseTest {

    @Mock
    private AfiliacionRepository afiliacionRepository;
    @InjectMocks
    private AfiliacionUseCase afiliacionUseCase;
    private static final String MESSAGE = "No se encuentra la renta con el id :";
    Persona persona = new Persona(1,1,"Cedula","daniel","gil", new Date(1995,10,27),"Masculino");
    Renta renta = new Renta(1, new Date(1995,10,27),1232.2,2);
    Asesor asesor = new Asesor(1,"nombre",persona);
    Beneficiario beneficiario = new Beneficiario(1,true,false,"papa",persona);
    Causante causante = new Causante(1,persona);

    Afiliacion afiliacion = new Afiliacion(1, new Date(1995,10,27),"2",renta,asesor,beneficiario,causante,"2");
    Afiliacion afiliacionActualizar = new Afiliacion(1, new Date(1995,10,27),"3",renta,asesor,beneficiario,causante,"2");


    @Test
    void crearAfiliacion() {

        Mockito.when(afiliacionRepository.crearAfiliacion(afiliacion)).thenReturn(Mono.just(afiliacion));

        StepVerifier.create(afiliacionUseCase.crearAfiliacion(afiliacion))
                .expectNextMatches(afiliacion1  -> afiliacion1.getId().equals(1))
                .expectComplete()
                .verify();
    }

    @Test
    void actualizarAfiliacion() {

        Mockito.when(afiliacionRepository.actualizarAfiliacion(1,afiliacion)).thenReturn(Mono.just(afiliacion));

        StepVerifier.create(afiliacionUseCase.crearAfiliacion(afiliacion))
                .expectNextMatches(afiliacionA -> afiliacionA.getId().equals(1))
                .verifyComplete();

        Mockito.when(afiliacionRepository.actualizarAfiliacion(1 , afiliacionActualizar)).thenReturn(Mono.just(afiliacionActualizar));

        StepVerifier.create(afiliacionUseCase.actualizarAfiliacion(1,afiliacionActualizar))
                .expectNextMatches(afiliacionB -> afiliacionB.getFondo().equals("3"))
                .verifyComplete();
    }

    @Test
    void borrarAfiliacion() {
    }

    @Test
    void buscarAfiliacion() {
    }

    @Test
    void listaAfiliacion() {
    }
}