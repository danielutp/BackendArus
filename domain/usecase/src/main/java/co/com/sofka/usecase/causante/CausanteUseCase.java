package co.com.sofka.usecase.causante;

import co.com.sofka.model.causante.Causante;
import co.com.sofka.model.causante.gateways.CausanteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CausanteUseCase {

    private final CausanteRepository causanteRepository;

    public Mono<Causante> crearCausante(Causante causante) {
        return causanteRepository.crearCausante(causante);
    }

    public Mono<Causante> actualizarCausante(Integer id,Causante causante) {
        return causanteRepository.actualizarCausante(id, causante);
    }

    public Mono<Void> borrarCausante(Integer id) {
        return causanteRepository.borrarCausante(id);
    }

    public Mono<Causante> buscarCausante(Integer id) {
        return causanteRepository.buscarCausante(id);
    }

    public Flux<Causante> listaCausante() {
        return causanteRepository.listaCausante();
    }

}
