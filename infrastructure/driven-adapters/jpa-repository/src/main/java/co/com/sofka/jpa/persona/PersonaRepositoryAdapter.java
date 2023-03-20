package co.com.sofka.jpa.persona;

import co.com.sofka.jpa.helper.AdapterOperations;
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
        return null;
    }

    @Override
    public Mono<Persona> actualizarPersona(Integer id, Persona persona) {
        return null;
    }

    @Override
    public Mono<Void> borrarPersona(Integer id) {
        return null;
    }

    @Override
    public Mono<Persona> buscarPersona(Integer id) {
        return null;
    }

    @Override
    public Flux<Persona> listaPersona() {
        return null;
    }
}
