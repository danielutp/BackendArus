package co.com.sofka.model.renta.gateways;

import co.com.sofka.model.renta.Renta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RentaRepository {
    Mono<Renta> crearRenta(Renta renta);

    Mono<Renta> actualizarRenta(Integer id, Renta renta);

    Mono<Void> borrarRenta(Integer id);

    Mono<Renta> buscarRenta(Integer id);

    Flux<Renta> listaRenta();



}
