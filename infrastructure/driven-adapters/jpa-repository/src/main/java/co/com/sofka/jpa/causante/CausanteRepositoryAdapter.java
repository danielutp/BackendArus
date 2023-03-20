package co.com.sofka.jpa.causante;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.causante.Causante;
import co.com.sofka.model.causante.gateways.CausanteRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CausanteRepositoryAdapter extends AdapterOperations<Causante, CausanteDto, Integer, CausanteDtoRepository>
        implements CausanteRepository {


    public CausanteRepositoryAdapter(CausanteDtoRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Causante.CausanteBuilder.class).build());
    }

    @Override
    public Mono<Causante> crearCausante(Causante causante) {
        return null;
    }

    @Override
    public Mono<Causante> actualizarCausante(Integer id, Causante causante) {
        return null;
    }

    @Override
    public Mono<Void> borrarCausante(Integer id) {
        return null;
    }

    @Override
    public Mono<Causante> buscarCausante(Integer id) {
        return null;
    }

    @Override
    public Flux<Causante> listaCausante() {
        return null;
    }
}
