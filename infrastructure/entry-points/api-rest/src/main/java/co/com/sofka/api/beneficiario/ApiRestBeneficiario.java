package co.com.sofka.api.beneficiario;
import co.com.sofka.model.beneficiario.Beneficiario;
import co.com.sofka.model.beneficiario.gateways.BeneficiarioRepository;
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
public class ApiRestBeneficiario {
    private final BeneficiarioRepository beneficiarioRepository;

    @PostMapping(path = "/crearBeneficiario")
    public Mono<Beneficiario> crearBeneficiario(@RequestBody Beneficiario beneficiario){
        return beneficiarioRepository.crearBeneficiario(beneficiario);
    }

    @PutMapping(path = "/actualizarBeneficiario/{id}")
    public Mono<Beneficiario> actualizarBeneficiario(@PathVariable Integer id,@RequestBody Beneficiario beneficiario) {
      return beneficiarioRepository.actualizarBeneficiario(id,beneficiario);
    }
    @DeleteMapping(path = "/borrarBeneficiario/{id}")
    public Mono<Void> borrarBeneficiario(@PathVariable Integer id) {
        return beneficiarioRepository.borrarBeneficiario(id);
    }
    @GetMapping(path = "/buscarBeneficiario/{id}")
    public Mono<Beneficiario> buscarBeneficiario(@PathVariable Integer id) {
        return beneficiarioRepository.buscarBeneficiario(id);
    }
    @GetMapping(path = "/listaBeneficiario")
    public Flux<Beneficiario> listaBeneficiario() {
        return beneficiarioRepository.listaBeneficiario();
    }

}
