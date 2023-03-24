package co.com.sofka.api.persona;
import co.com.sofka.model.persona.Persona;
import co.com.sofka.model.renta.Renta;
import co.com.sofka.usecase.persona.PersonaUseCase;
import co.com.sofka.usecase.renta.RentaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(
        origins = {"http://localhost:4200"},
        methods = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestPersona {
    private final PersonaUseCase personaUseCase;

    @PostMapping(path = "/crearPersona")
    public Mono<Persona> crearPersona(@RequestBody Persona persona){
        return personaUseCase.crearPersona(persona);
    }

    @PutMapping(path = "/actualizarPersona/{id}")
    public Mono<Persona> actualizarPersona(@PathVariable Integer id,@RequestBody Persona persona) {
      return personaUseCase.actualizarPersona(id,persona);
    }
    @DeleteMapping(path = "/borrarPersona/{id}")
    public Mono<Void> borrarPersona(@PathVariable Integer id) {
        return personaUseCase.borrarPersona(id);
    }
    @GetMapping(path = "/buscarPersona/{id}")
    public Mono<Persona> buscarPersona(@PathVariable Integer id) {
        return personaUseCase.buscarPersona(id);
    }
    @GetMapping(path = "/listaPersona")
    public Flux<Persona> listaPersona() {
        return personaUseCase.listaPersona();
    }

}
