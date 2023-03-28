package co.com.sofka.api.asesor;
import co.com.sofka.model.asesor.Asesor;
import co.com.sofka.usecase.asesor.AsesorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestAsesor {
    private final AsesorUseCase asesorUseCase;

    @PostMapping(path = "/crearAsesor")
    public Mono<Asesor> crearAsesor(@RequestBody Asesor asesor){
        return asesorUseCase.crearAsesor(asesor);
    }

    @PutMapping(path = "/actualizarAsesor/{id}")
    public Mono<Asesor> actualizarAsesor(@PathVariable Integer id,@RequestBody Asesor asesor) {
      return asesorUseCase.actualizarAsesor(id,asesor);
    }
    @DeleteMapping(path = "/borrarAsesor/{id}")
    public Mono<Void> borrarAsesor(@PathVariable Integer id) {
        return asesorUseCase.borrarAsesor(id);
    }
    @GetMapping(path = "/buscarAsesor/{id}")
    public Mono<Asesor> buscarAsesor(@PathVariable Integer id) {
        return asesorUseCase.buscarAsesor(id);
    }
    @GetMapping(path = "/listaAsesor")
    public Flux<Asesor> listaAsesor() {
        return asesorUseCase.listaAsesor();
    }

}
