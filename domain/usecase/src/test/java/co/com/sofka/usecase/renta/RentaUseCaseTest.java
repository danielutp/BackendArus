package co.com.sofka.usecase.renta;

import co.com.sofka.model.renta.Renta;
import co.com.sofka.model.renta.gateways.RentaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RentaUseCaseTest {

    @Mock
    private RentaRepository rentaRepository;
    @InjectMocks
    private RentaUseCase rentaUseCase;
    private static final String MESSAGE = "No se encuentra la renta con el id :";

    @Test
    void crearRenta() {
    }

    @Test
    void crearRentaExcepcion() {

        Renta renta = new Renta(1, new Date(1995,10,27),1232.2,2, List.of());

        Mockito.when(rentaRepository.crearRenta(renta)).thenReturn(Mono.error(new IllegalArgumentException(MESSAGE)));

        StepVerifier.create(rentaUseCase.crearRenta(renta))
                .expectErrorMatches(throwable -> throwable instanceof IllegalArgumentException && throwable.getMessage().equals(MESSAGE))
                .verify();

    }


    @Test
    void actualizarRenta() {
    }

    @Test
    void borrarRenta() {
    }

    @Test
    void buscarRenta() {
    }

    @Test
    void listaRenta() {
    }
}