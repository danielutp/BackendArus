package co.com.sofka.model.afiliacion.gateways;

import co.com.sofka.model.afiliacion.Afiliacion;
import co.com.sofka.model.beneficiario.Beneficiario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AfiliacionRepository {
    Mono<Afiliacion> crearAfiliacion(Afiliacion afiliacion);

    Mono<Afiliacion> actualizarAfiliacion(Integer id, Afiliacion afiliacion);

    Mono<Void> borrarAfiliacion(Integer id);

    Mono<Afiliacion> buscarAfiliacion(Integer id);

    Flux<Afiliacion> listaAfiliacion();
}
