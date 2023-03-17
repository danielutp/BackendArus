package co.com.sofka.model.beneficiario.gateways;

import co.com.sofka.model.beneficiario.Beneficiario;
import co.com.sofka.model.causante.Causante;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeneficiarioRepository {
    Mono<Beneficiario> crearBeneficiario(Beneficiario beneficiario);

    Mono<Beneficiario> actualizarBeneficiario(Integer id, Beneficiario beneficiario);

    Mono<Void> borrarBeneficiario(Integer id);

    Mono<Beneficiario> buscarBeneficiario(Integer id);

    Flux<Beneficiario> listaBeneficiario();
}
