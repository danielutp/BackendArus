package co.com.sofka.model.persona.gateways;

import co.com.sofka.model.persona.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaRepository {
    Mono<Persona> crearPersona(Persona persona);

    Mono<Persona> actualizarPersona(Integer id, Persona persona);

    Mono<Void> borrarPersona(Integer id);

    Mono<Persona> buscarPersona(Integer id);

    Flux<Persona> listaPersona();
}

