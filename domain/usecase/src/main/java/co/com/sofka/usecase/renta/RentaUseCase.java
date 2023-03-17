package co.com.sofka.usecase.renta;

import co.com.sofka.model.renta.Renta;
import co.com.sofka.model.renta.gateways.RentaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RentaUseCase {

    private final RentaRepository rentaRepository;

    public Mono<Renta> crearRenta(Renta renta) {
        return rentaRepository.crearRenta(renta);
    }

    public Mono<Renta> actualizarRenta(Integer id,Renta renta) {
        return rentaRepository.actualizarRenta(id, renta);
    }

    public Mono<Void> borrarRenta(Integer id) {
        return rentaRepository.borrarRenta(id);
    }

    public Mono<Renta> buscarRenta(Integer id) {
        return rentaRepository.buscarRenta(id);
    }

    public Flux<Renta> listaRenta() {
        return rentaRepository.listaRenta();
    }
}
