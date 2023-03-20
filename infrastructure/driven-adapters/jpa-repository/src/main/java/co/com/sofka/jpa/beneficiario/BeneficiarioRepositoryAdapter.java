package co.com.sofka.jpa.beneficiario;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.asesor.Asesor;
import co.com.sofka.model.beneficiario.Beneficiario;
import co.com.sofka.model.beneficiario.gateways.BeneficiarioRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BeneficiarioRepositoryAdapter extends AdapterOperations<Beneficiario, BeneficiarioDto, Integer, BeneficiarioDtoRepository>
        implements BeneficiarioRepository {


    public BeneficiarioRepositoryAdapter(BeneficiarioDtoRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Beneficiario.BeneficiarioBuilder.class).build());
    }


    @Override
    public Mono<Beneficiario> crearBeneficiario(Beneficiario beneficiario) {
        return null;
    }

    @Override
    public Mono<Beneficiario> actualizarBeneficiario(Integer id, Beneficiario beneficiario) {
        return null;
    }

    @Override
    public Mono<Void> borrarBeneficiario(Integer id) {
        return null;
    }

    @Override
    public Mono<Beneficiario> buscarBeneficiario(Integer id) {
        return null;
    }

    @Override
    public Flux<Beneficiario> listaBeneficiario() {
        return null;
    }
}
