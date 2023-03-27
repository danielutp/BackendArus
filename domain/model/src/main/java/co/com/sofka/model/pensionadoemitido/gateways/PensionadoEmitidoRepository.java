package co.com.sofka.model.pensionadoemitido.gateways;

import co.com.sofka.model.pensionadoemitido.PensionadoEmitido;
import reactor.core.publisher.Mono;
public interface PensionadoEmitidoRepository {

    Mono<PensionadoEmitido> pensionadoEmitido(PensionadoEmitido pensionadoEmitido);

}
