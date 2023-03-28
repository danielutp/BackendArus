package co.com.sofka.api.renta;
import co.com.sofka.model.renta.Renta;
import co.com.sofka.usecase.renta.RentaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestRenta {
    private final RentaUseCase rentaUseCase;

    @PostMapping(path = "/crearRenta")
    public Mono<Renta> crearRenta(@RequestBody Renta renta){
        return rentaUseCase.crearRenta(renta);
    }

    @PutMapping(path = "/actualizarRenta/{id}")
    public Mono<Renta> actualizarRenta(@PathVariable Integer id,@RequestBody Renta renta) {
      return rentaUseCase.actualizarRenta(id,renta);
    }
    @DeleteMapping(path = "/borrarRenta/{id}")
    public Mono<Void> borrarRenta(@PathVariable Integer id) {
        return rentaUseCase.borrarRenta(id);
    }
    @GetMapping(path = "/buscarRenta/{id}")
    public Mono<Renta> buscarRenta(@PathVariable Integer id) {
        return rentaUseCase.buscarRenta(id);
    }
    @GetMapping(path = "/listaRenta")
    public Flux<Renta> listaRenta() {
        return rentaUseCase.listaRenta();
    }

}
