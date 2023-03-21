package co.com.sofka.jpa.persona;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.jpa.persona.personaMappers.PersonaMappers;
import co.com.sofka.model.persona.Persona;
import co.com.sofka.model.persona.gateways.PersonaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonaRepositoryAdapter extends AdapterOperations<Persona, PersonaDto, Integer, PersonaDtoRepository>
        implements PersonaRepository {


        public PersonaRepositoryAdapter(PersonaDtoRepository repository, ObjectMapper mapper) {
            super(repository, mapper, d -> mapper.mapBuilder(d, Persona.PersonaBuilder.class).build());
        }

    @Override
    public Mono<Persona> crearPersona(Persona persona) {
        return Mono.just(save(persona));
    }

    @Override
    public Mono<Persona> actualizarPersona(Integer id, Persona persona) {
        if (repository.findById(id).isPresent()) {
            PersonaDto personaDto = PersonaMappers.personaConvertirAPersonaDTO(persona);
            personaDto.setId(id);
            return Mono.just(PersonaMappers.personaDTOConvertirAPersona(repository.save(personaDto)));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la persona con el id :" + id));
        }
    }

    @Override
    public Mono<Void> borrarPersona(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return Mono.empty();
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la persona con el id :" + id));
        }
    }

    @Override
    public Mono<Persona> buscarPersona(Integer id) {
        if (repository.findById(id).isPresent()) {
            return Mono.just(PersonaMappers.personaDTOConvertirAPersona(repository.findById(id).get()));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la persona con el id :" + id));
        }
    }

    @Override
    public Flux<Persona> listaPersona() {
        var Lista = repository.findAll();
        return Flux.fromIterable(Lista).map(PersonaMappers::personaDTOConvertirAPersona);

    }
}
