package co.com.sofka.publishers;

import co.com.sofka.model.pensionadoemitido.PensionadoEmitido;
import co.com.sofka.model.pensionadoemitido.gateways.PensionadoEmitidoRepository;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@EnableDirectAsyncGateway
@RequiredArgsConstructor
public class PublicadorRabbitmq implements PensionadoEmitidoRepository {
    private final DirectAsyncGateway disparadorComando;

    static final String CAUSANTE_PENSIONADO = "causante.pensionado";

    @Override
    public Mono<PensionadoEmitido> pensionadoEmitido(PensionadoEmitido pensionadoEmitido) {
        final Command<PensionadoEmitido> command = new Command<>(CAUSANTE_PENSIONADO,UUID.randomUUID().toString(),pensionadoEmitido);
        return disparadorComando.sendCommand(command,"SBDCPC").thenReturn(pensionadoEmitido);
    }
}