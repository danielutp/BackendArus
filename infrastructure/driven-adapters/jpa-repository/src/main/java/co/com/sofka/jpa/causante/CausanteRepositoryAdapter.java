package co.com.sofka.jpa.causante;

import co.com.sofka.jpa.causante.causanteMappers.CausanteMappers;
import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.jpa.persona.PersonaDto;
import co.com.sofka.jpa.persona.personaMappers.PersonaMappers;
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
        CausanteDto causanteDto = CausanteMappers.causanteConvertirACausanteDTO(causante);
        return Mono.just(save(CausanteMappers.causanteDTOConvertirAACausante(causanteDto)));
    }

    @Override
    public Mono<Causante> actualizarCausante(Integer id, Causante causante) {
        if (repository.findById(id).isPresent()) {
            CausanteDto causanteDto = CausanteMappers.causanteConvertirACausanteDTO(causante);
            causanteDto.setId(id);
            return Mono.just(CausanteMappers.causanteDTOConvertirAACausante(repository.save(causanteDto)));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la persona con el id :" + id));
        }
    }

    @Override
    public Mono<Void> borrarCausante(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return Mono.empty();
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la causante con el id :" + id));
        }
    }

    @Override
    public Mono<Causante> buscarCausante(Integer id) {
        if (repository.findById(id).isPresent()) {
            return Mono.just(CausanteMappers.causanteDTOConvertirAACausante(repository.findById(id).get()));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la persona con el id :" + id));
        }
    }

    @Override
    public Flux<Causante> listaCausante() {
        var Lista = repository.findAll();
        return Flux.fromIterable(Lista).map(CausanteMappers::causanteDTOConvertirAACausante);
    }
}