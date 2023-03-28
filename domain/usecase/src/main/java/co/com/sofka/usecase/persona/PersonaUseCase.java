package co.com.sofka.usecase.persona;

import co.com.sofka.model.persona.Persona;
import co.com.sofka.model.persona.gateways.PersonaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PersonaUseCase {
    private final PersonaRepository personaRepository;

    public Mono<Persona> crearPersona(Persona persona) {
        return personaRepository.crearPersona(persona);
    }

    public Mono<Persona> actualizarPersona(Integer id,Persona persona) {
        return personaRepository.actualizarPersona(id, persona);
    }

    public Mono<Void> borrarPersona(Integer id) {
        return personaRepository.borrarPersona(id);
    }

    public Mono<Persona> buscarPersona(Integer id) {
        return personaRepository.buscarPersona(id);
    }

    public Flux<Persona> listaPersona() {
        return personaRepository.listaPersona();
    }
}
