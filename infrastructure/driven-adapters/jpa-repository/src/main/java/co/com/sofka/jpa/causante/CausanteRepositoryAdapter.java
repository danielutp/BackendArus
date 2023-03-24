package co.com.sofka.jpa.causante;

import co.com.sofka.jpa.causante.causanteMappers.CausanteMappers;
import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.jpa.persona.PersonaDto;
import co.com.sofka.jpa.persona.personaMappers.PersonaMappers;
import co.com.sofka.model.causante.Causante;
import co.com.sofka.model.causante.gateways.CausanteRepository;
import co.com.sofka.model.persona.gateways.PersonaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Repository
public class CausanteRepositoryAdapter extends AdapterOperations<Causante, CausanteDto, Integer, CausanteDtoRepository>
        implements CausanteRepository {

    private final RestTemplate restTemplate;
    private  final PersonaRepository personaRepository;


    public CausanteRepositoryAdapter(CausanteDtoRepository repository, ObjectMapper mapper, RestTemplate restTemplate, PersonaRepository personaRepository) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Causante.CausanteBuilder.class).build());
        this.restTemplate = restTemplate;
        this.personaRepository = personaRepository;
    }

    @Override
    public Mono<Causante> crearCausante(Causante causante) {
        return personaRepository.buscarPersona(causante.getPersona().getId())
                .map(PersonaMappers::personaConvertirAPersonaDTO)
                .flatMap(personaDto-> validatePersonaPensionado(causante, personaDto));

      }

    private Mono<Causante> validatePersonaPensionado(Causante causante, PersonaDto personaDto) {
        return Objects.isNull(validarPensionado(personaDto.getIdentificacion()))
                ? Mono.error(new NullPointerException("Malo"))
                : Mono.just(CausanteMappers.causanteDTOConvertirAACausante(repository.save(CausanteMappers.causanteConvertirACausanteDTO(causante))));
    }

    @Override
    public Mono<Causante> actualizarCausante(Integer id, Causante causante) {
        if (repository.findById(id).isPresent()) {
            CausanteDto causanteDto = CausanteMappers.causanteConvertirACausanteDTO(causante);
            causanteDto.setId(id);
            return Mono.just(CausanteMappers.causanteDTOConvertirAACausante(repository.save(causanteDto)));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la persona con el id :" + id));
        }
    }

    @Override
    public Mono<Void> borrarCausante(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return Mono.empty();
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la causante con el id :" + id));
        }
    }

    @Override
    public Mono<Causante> buscarCausante(Integer id) {
        if (repository.findById(id).isPresent()) {
            return Mono.just(CausanteMappers.causanteDTOConvertirAACausante(repository.findById(id).get()));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la persona con el id :" + id));
        }
    }

    @Override
    public Flux<Causante> listaCausante() {
        var Lista = repository.findAll();
        return Flux.fromIterable(Lista).map(CausanteMappers::causanteDTOConvertirAACausante);
    }

    @Override
    public Mono<Boolean> validarPensionado(Integer identificacion) {
        var response = restTemplate.getForObject("http://localhost:8080/api/verificarPensionado/"+identificacion, Boolean.class);
        return Mono.just(response);
    }

}