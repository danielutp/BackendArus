package co.com.sofka.model.asesor.gateways;

import co.com.sofka.model.asesor.Asesor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AsesorRepository {
    Mono<Asesor> crearAsesor(Asesor asesor);

    Mono<Asesor> actualizarAsesor(Integer id, Asesor asesor);

    Mono<Void> borrarAsesor(Integer id);

    Mono<Asesor> buscarAsesor(Integer id);

    Flux<Asesor> listaAsesor();

}
