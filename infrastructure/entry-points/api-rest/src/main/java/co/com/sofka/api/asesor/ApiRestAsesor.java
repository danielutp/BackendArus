package co.com.sofka.api.asesor;
import co.com.sofka.model.asesor.Asesor;
import co.com.sofka.model.asesor.gateways.AsesorRepository;
import co.com.sofka.model.causante.Causante;
import co.com.sofka.model.causante.gateways.CausanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestAsesor {
    private final AsesorRepository asesorRepository;

    @PostMapping(path = "/crearAsesor")
    public Mono<Asesor> crearAsesor(@RequestBody Asesor asesor){
        return asesorRepository.crearAsesor(asesor);
    }

    @PutMapping(path = "/actualizarAsesor/{id}")
    public Mono<Asesor> actualizarAsesor(@PathVariable Integer id,@RequestBody Asesor asesor) {
      return asesorRepository.actualizarAsesor(id,asesor);
    }
    @DeleteMapping(path = "/borrarAsesor/{id}")
    public Mono<Void> borrarAsesor(@PathVariable Integer id) {
        return asesorRepository.borrarAsesor(id);
    }
    @GetMapping(path = "/buscarAsesor/{id}")
    public Mono<Asesor> buscarAsesor(@PathVariable Integer id) {
        return asesorRepository.buscarAsesor(id);
    }
    @GetMapping(path = "/listaAsesor")
    public Flux<Asesor> listaAsesor() {
        return asesorRepository.listaAsesor();
    }

}
