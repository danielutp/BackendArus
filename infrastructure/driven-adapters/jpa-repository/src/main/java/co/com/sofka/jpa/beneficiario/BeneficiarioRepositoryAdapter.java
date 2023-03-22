package co.com.sofka.jpa.beneficiario;

import co.com.sofka.jpa.asesor.AsesorDto;
import co.com.sofka.jpa.asesor.asesorMappers.AsesorMappers;
import co.com.sofka.jpa.beneficiario.beneficiarioMappers.BeneficiarioMappers;
import co.com.sofka.jpa.helper.AdapterOperations;
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
        BeneficiarioDto beneficiarioDto = BeneficiarioMappers.beneficiarioConvertirABeneficiarioDTO(beneficiario);
        return Mono.just(BeneficiarioMappers.beneficiarioDTOConvertirAABeneficiario(repository.save(beneficiarioDto)));
    }

    @Override
    public Mono<Beneficiario> actualizarBeneficiario(Integer id, Beneficiario beneficiario) {
        if (repository.findById(id).isPresent()) {
            BeneficiarioDto beneficiarioDto = BeneficiarioMappers.beneficiarioConvertirABeneficiarioDTO(beneficiario);
            beneficiarioDto.setId(id);
            return Mono.just(BeneficiarioMappers.beneficiarioDTOConvertirAABeneficiario(repository.save(beneficiarioDto)));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la beneficiario con el id :" + id));
        }
    }

    @Override
    public Mono<Void> borrarBeneficiario(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return Mono.empty();
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la beneficiario con el id :" + id));
        }
    }

    @Override
    public Mono<Beneficiario> buscarBeneficiario(Integer id) {
        if (repository.findById(id).isPresent()) {
            return Mono.just(BeneficiarioMappers.beneficiarioDTOConvertirAABeneficiario(repository.findById(id).get()));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la beneficiario con el id :" + id));
        }
    }

    @Override
    public Flux<Beneficiario> listaBeneficiario() {
        var Lista = repository.findAll();
        return Flux.fromIterable(Lista).map(BeneficiarioMappers::beneficiarioDTOConvertirAABeneficiario);

    }
}
