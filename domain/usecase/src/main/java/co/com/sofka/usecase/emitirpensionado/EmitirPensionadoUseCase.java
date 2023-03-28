package co.com.sofka.usecase.emitirpensionado;

import co.com.sofka.model.pensionadoemitido.PensionadoEmitido;
import co.com.sofka.model.pensionadoemitido.gateways.PensionadoEmitidoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EmitirPensionadoUseCase {

    private final PensionadoEmitidoRepository pensionadoEmitidoRepository;

    public Mono<PensionadoEmitido> emitirPorComando(PensionadoEmitido pensionadoEmitido){
        return pensionadoEmitidoRepository.pensionadoEmitido(pensionadoEmitido);
    }


}
