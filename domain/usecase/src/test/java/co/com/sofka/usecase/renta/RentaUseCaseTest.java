package co.com.sofka.usecase.renta;

import co.com.sofka.model.renta.Renta;
import co.com.sofka.model.renta.gateways.RentaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentaUseCaseTest {

    @Mock
    private RentaRepository rentaRepository;
    @InjectMocks
    private RentaUseCase rentaUseCase;
    private static final String MESSAGE = "No se encuentra la renta con el id :";

    @Test
    void crearRenta() {

        Renta renta = new Renta(1, new Date(1995,10,27),1232.2,2);

        Mockito.when(rentaRepository.crearRenta(renta)).thenReturn(Mono.just(renta));

        StepVerifier.create(rentaUseCase.crearRenta(renta))
                .expectNextMatches(rentaP -> rentaP.getId().equals(1))
                .expectComplete()
                .verify();
    }

    @Test
    void actualizarRentaExcepcion() {
        Renta renta = new Renta(1, new Date(1995,10,27),1232.2,2);

        when(rentaRepository.actualizarRenta( 1,renta)).thenReturn(Mono.error(new IllegalArgumentException(MESSAGE)));
        StepVerifier.create(rentaUseCase.actualizarRenta( 1,renta))
                .verifyErrorMessage(MESSAGE );
    }



    @Test
    void actualizarRenta() {

        Renta renta = new Renta(1, new Date(1995,10,27),1232.2,2);
        Renta rentaActualizar = new Renta(1, new Date(1995,10,27),1200.2,5);

        Mockito.when(rentaRepository.crearRenta(renta)).thenReturn(Mono.just(renta));

        StepVerifier.create(rentaUseCase.crearRenta(renta))
                .expectNextMatches(rentaA -> rentaA.getId().equals(1))
                .verifyComplete();

        Mockito.when(rentaRepository.actualizarRenta(1 , rentaActualizar)).thenReturn(Mono.just(rentaActualizar));

        StepVerifier.create(rentaUseCase.actualizarRenta(1,rentaActualizar))
                .expectNextMatches(rentaB -> rentaB.getMesesCotizando().equals(5))
                .verifyComplete();
    }

    @Test
    void borrarRenta() {
        when(rentaRepository.borrarRenta(1)).thenReturn(Mono.empty());
        StepVerifier.create(rentaUseCase.borrarRenta(1))
                .verifyComplete();
    }

    @Test
    void borrarRentaExcepcion() {

        Mockito.when(rentaRepository.borrarRenta(1)).thenReturn(Mono.error(new IllegalArgumentException(MESSAGE)));

        StepVerifier.create(rentaUseCase.borrarRenta(1))
                .expectErrorMatches(throwable -> throwable instanceof IllegalArgumentException && throwable.getMessage().equals(MESSAGE))
                .verify();

    }


    @Test
    void buscarRenta() {

        Renta renta = new Renta(1, new Date(1995,10,27),1232.2,2);

        when(rentaRepository.buscarRenta(1)).thenReturn(Mono.just(renta));

        StepVerifier.create(rentaUseCase.buscarRenta(1))
                .assertNext(rentae -> {
                    assertEquals(1, rentae.getId());
                    assertEquals(2, rentae.getMesesCotizando());
                })
                .verifyComplete();
    }


    @Test
    void buscarRentaExcepciones() {
        Renta renta = new Renta(1, new Date(1995,10,27),1232.2,2);
        when(rentaRepository.buscarRenta(1)).thenReturn(Mono.error(new IllegalArgumentException(MESSAGE)));
        StepVerifier.create(rentaUseCase.buscarRenta(1))
                .verifyErrorMessage(MESSAGE);
    }

    @Test
    void listaRenta() {

        Renta renta = new Renta(1, new Date(1995,10,27),1232.2,2);

        when(rentaRepository.listaRenta()).thenReturn(Flux.just(renta));

        StepVerifier.create(rentaUseCase.listaRenta())
                .expectNextMatches(rentaA -> rentaA.getId().equals(1))
                .expectComplete()
                .verify();
    }
}