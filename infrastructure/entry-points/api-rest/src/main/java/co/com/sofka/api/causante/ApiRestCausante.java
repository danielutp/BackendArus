package co.com.sofka.api.causante;
import co.com.sofka.model.causante.Causante;
import co.com.sofka.model.causante.gateways.CausanteRepository;
import co.com.sofka.model.persona.Persona;
import co.com.sofka.usecase.causante.CausanteUseCase;
import co.com.sofka.usecase.persona.PersonaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestCausante {
    private final CausanteRepository causanteRepository;

    @PostMapping(path = "/crearCausante")
    public Mono<Causante> crearCausante(@RequestBody Causante causante){
        return causanteRepository.crearCausante(causante);
    }

    @PutMapping(path = "/actualizarCausante/{id}")
    public Mono<Causante> actualizarCausante(@PathVariable Integer id,@RequestBody Causante causante) {
      return causanteRepository.actualizarCausante(id,causante);
    }
    @DeleteMapping(path = "/borrarCausante/{id}")
    public Mono<Void> borrarCausante(@PathVariable Integer id) {
        return causanteRepository.borrarCausante(id);
    }
    @GetMapping(path = "/buscarCausante/{id}")
    public Mono<Causante> buscarCausante(@PathVariable Integer id) {
        return causanteRepository.buscarCausante(id);
    }
    @GetMapping(path = "/listaCausante")
    public Flux<Causante> listaCausante() {
        return causanteRepository.listaCausante();
    }

}
