package co.com.sofka.api.beneficiario;
import co.com.sofka.model.beneficiario.Beneficiario;
import co.com.sofka.usecase.beneficiario.BeneficiarioUseCase;
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
public class ApiRestBeneficiario {
    private final BeneficiarioUseCase beneficiarioUseCase;

    @PostMapping(path = "/crearBeneficiario")
    public Mono<Beneficiario> crearBeneficiario(@RequestBody Beneficiario beneficiario){
        return beneficiarioUseCase.crearBeneficiario(beneficiario);
    }

    @PutMapping(path = "/actualizarBeneficiario/{id}")
    public Mono<Beneficiario> actualizarBeneficiario(@PathVariable Integer id,@RequestBody Beneficiario beneficiario) {
      return beneficiarioUseCase.actualizarBeneficiario(id,beneficiario);
    }
    @DeleteMapping(path = "/borrarBeneficiario/{id}")
    public Mono<Void> borrarBeneficiario(@PathVariable Integer id) {
        return beneficiarioUseCase.borrarBeneficiario(id);
    }
    @GetMapping(path = "/buscarBeneficiario/{id}")
    public Mono<Beneficiario> buscarBeneficiario(@PathVariable Integer id) {
        return beneficiarioUseCase.buscarBeneficiario(id);
    }
    @GetMapping(path = "/listaBeneficiario")
    public Flux<Beneficiario> listaBeneficiario() {
        return beneficiarioUseCase.listaBeneficiario();
    }

}
