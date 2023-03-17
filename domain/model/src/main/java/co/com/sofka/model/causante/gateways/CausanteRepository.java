package co.com.sofka.model.causante.gateways;

import co.com.sofka.model.causante.Causante;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CausanteRepository {

    Mono<Causante> crearCausante(Causante causante);

    Mono<Causante> actualizarCausante(Integer id, Causante causante);

    Mono<Void> borrarCausante(Integer id);

    Mono<Causante> buscarCausante(Integer id);

    Flux<Causante> listaCausante();

}
