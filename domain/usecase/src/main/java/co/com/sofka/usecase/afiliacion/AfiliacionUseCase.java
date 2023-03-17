package co.com.sofka.usecase.afiliacion;

import co.com.sofka.model.afiliacion.Afiliacion;
import co.com.sofka.model.afiliacion.gateways.AfiliacionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AfiliacionUseCase {

    private final AfiliacionRepository afiliacionRepository;

    public Mono<Afiliacion> crearAfiliacion(Afiliacion afiliacion) {
        return afiliacionRepository.crearAfiliacion(afiliacion);
    }

    public Mono<Afiliacion> actualizarAfiliacion(Integer id,Afiliacion afiliacion) {
        return afiliacionRepository.actualizarAfiliacion(id, afiliacion);
    }

    public Mono<Void> borrarAfiliacion(Integer id) {
        return afiliacionRepository.borrarAfiliacion(id);
    }

    public Mono<Afiliacion> buscarAfiliacion(Integer id) {
        return afiliacionRepository.buscarAfiliacion(id);
    }

    public Flux<Afiliacion> listaAfiliacion() {
        return afiliacionRepository.listaAfiliacion();
    }

}