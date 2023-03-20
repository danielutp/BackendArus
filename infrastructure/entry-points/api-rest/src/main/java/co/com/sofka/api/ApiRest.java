package co.com.sofka.api;
import co.com.sofka.model.renta.Renta;
import co.com.sofka.usecase.renta.RentaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final RentaUseCase rentaUseCase;

    @PostMapping(path = "/crearRenta")
    public Mono<Renta> crearRenta(@RequestBody Renta renta){
        return rentaUseCase.crearRenta(renta);
    }

    @PutMapping(path = "/actualizarRenta")
    public Mono<Renta> commandName(@RequestBody Integer id, Renta renta) {
      return rentaUseCase.actualizarRenta(id,renta);
    }
}
