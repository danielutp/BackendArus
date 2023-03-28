package co.com.sofka.jpa.afiliacion;

import co.com.sofka.jpa.afiliacion.afiliacionmappers.AfiliacionMappers;
import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.afiliacion.Afiliacion;
import co.com.sofka.model.afiliacion.gateways.AfiliacionRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class AfiliacionRepositoryAdapter extends AdapterOperations <Afiliacion, AfiliacionDto, Integer, AfiliacionDtoRepository>
        implements AfiliacionRepository {


    public AfiliacionRepositoryAdapter(AfiliacionDtoRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Afiliacion.AfiliacionBuilder.class).build());   }


    @Override
    public Mono<Afiliacion> crearAfiliacion(Afiliacion afiliacion) {
        return Mono.just(save(afiliacion));
    }

    @Override
    public Mono<Afiliacion> actualizarAfiliacion(Integer id, Afiliacion afiliacion) {
        if (repository.findById(id).isPresent()) {
            AfiliacionDto afiliacionDto = AfiliacionMappers.afiliacionConvertirAAfiliacionDTO(afiliacion);
            afiliacionDto.setId(id);
            return Mono.just(AfiliacionMappers.afiliacionDtoConvertirAAfiliacion(repository.save(afiliacionDto)));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la afiliacion con el id :" + id));
        }
    }

    @Override
    public Mono<Void> borrarAfiliacion(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return Mono.empty();
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la afiliacion con el id :" + id));
        }
    }

    @Override
    public Mono<Afiliacion> buscarAfiliacion(Integer id) {
        if (repository.findById(id).isPresent()) {
            return Mono.just(AfiliacionMappers.afiliacionDtoConvertirAAfiliacion(repository.findById(id).get()));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la afiliacion con el id :" + id));
        }
    }

    @Override
    public Flux<Afiliacion> listaAfiliacion() {
        var Lista = repository.findAll();
        return Flux.fromIterable(Lista).map(AfiliacionMappers::afiliacionDtoConvertirAAfiliacion);
    }
}


