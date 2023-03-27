package co.com.sofka.api.causante;
import co.com.sofka.model.causante.Causante;
import co.com.sofka.model.pensionadoemitido.PensionadoEmitido;
import co.com.sofka.model.persona.gateways.PersonaRepository;
import co.com.sofka.usecase.causante.CausanteUseCase;
import co.com.sofka.usecase.emitirpensionado.EmitirPensionadoUseCase;
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
public class ApiRestCausante {
    private final CausanteUseCase causanteUseCase;

    private final PersonaRepository personaRepository;

    private final EmitirPensionadoUseCase emitirPensionadoUseCase;

    @PostMapping(path = "/crearCausante")
    public Mono<Causante> crearCausante(@RequestBody Causante causante){
        personaRepository.buscarPersona(causante.getPersona().getId()).map(ele->{
           return emitirPensionadoUseCase.emitirPorComando(PensionadoEmitido.builder().identificacion(ele.getIdentificacion()).build()).subscribe();
        }).subscribe();

        return causanteUseCase.crearCausante(causante);
    }

    @PutMapping(path = "/actualizarCausante/{id}")
    public Mono<Causante> actualizarCausante(@PathVariable Integer id,@RequestBody Causante causante) {
      return causanteUseCase.actualizarCausante(id,causante);
    }
    @DeleteMapping(path = "/borrarCausante/{id}")
    public Mono<Void> borrarCausante(@PathVariable Integer id) {
        return causanteUseCase.borrarCausante(id);
    }
    @GetMapping(path = "/buscarCausante/{id}")
    public Mono<Causante> buscarCausante(@PathVariable Integer id) {
        return causanteUseCase.buscarCausante(id);
    }
    @GetMapping(path = "/listaCausante")
    public Flux<Causante> listaCausante() {
        return causanteUseCase.listaCausante();
    }

    @GetMapping("/emitirPensionado/{id}")
        public Mono<PensionadoEmitido> buscarCausantePorComando(@PathVariable PensionadoEmitido pensionadoEmitido){
        return emitirPensionadoUseCase.emitirPorComando(pensionadoEmitido);
    }

}
