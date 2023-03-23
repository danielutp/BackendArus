package co.com.sofka.api.afiliacion;
import co.com.sofka.model.afiliacion.Afiliacion;
import co.com.sofka.model.afiliacion.gateways.AfiliacionRepository;
import co.com.sofka.model.asesor.Asesor;
import co.com.sofka.model.asesor.gateways.AsesorRepository;
import co.com.sofka.usecase.afiliacion.AfiliacionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestAfiliacion {
    private final AfiliacionUseCase afiliacionUseCase;

    @PostMapping(path = "/crearAfiliacion")
    public Mono<Afiliacion> crearAfiliacion(@RequestBody Afiliacion afiliacion){
        return afiliacionUseCase.crearAfiliacion(afiliacion);
    }

    @PutMapping(path = "/actualizarAfiliacion/{id}")
    public Mono<Afiliacion> actualizarAfiliacion(@PathVariable Integer id, @RequestBody Afiliacion afiliacion) {
      return afiliacionUseCase.actualizarAfiliacion(id,afiliacion);
    }
    @DeleteMapping(path = "/borrarAfiliacion/{id}")
    public Mono<Void> borrarAfiliacion(@PathVariable Integer id) {
        return afiliacionUseCase.borrarAfiliacion(id);
    }
    @GetMapping(path = "/buscarAfiliacion/{id}")
    public Mono<Afiliacion> buscarAfiliacion(@PathVariable Integer id) {
        return afiliacionUseCase.buscarAfiliacion(id);
    }
    @GetMapping(path = "/listaAfiliacion")
    public Flux<Afiliacion> listaAfiliacion() {
        return afiliacionUseCase.listaAfiliacion();
    }

}
