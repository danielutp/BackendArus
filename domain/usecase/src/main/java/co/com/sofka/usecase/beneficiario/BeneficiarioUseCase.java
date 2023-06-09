package co.com.sofka.usecase.beneficiario;

import co.com.sofka.model.beneficiario.Beneficiario;
import co.com.sofka.model.beneficiario.gateways.BeneficiarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BeneficiarioUseCase {

    private final BeneficiarioRepository beneficiarioRepository;


    public Mono<Beneficiario> crearBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.crearBeneficiario(beneficiario);
    }

    public Mono<Beneficiario> actualizarBeneficiario(Integer id,Beneficiario beneficiario) {
        return beneficiarioRepository.actualizarBeneficiario(id, beneficiario);
    }

    public Mono<Void> borrarBeneficiario(Integer id) {
        return beneficiarioRepository.borrarBeneficiario(id);
    }

    public Mono<Beneficiario> buscarBeneficiario(Integer id) {
        return beneficiarioRepository.buscarBeneficiario(id);
    }

    public Flux<Beneficiario> listaBeneficiario() {
        return beneficiarioRepository.listaBeneficiario();
    }


}
