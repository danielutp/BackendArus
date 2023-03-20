package co.com.sofka.jpa.afiliacion;

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
        return null;
    }

    @Override
    public Mono<Afiliacion> actualizarAfiliacion(Integer id, Afiliacion afiliacion) {
        return null;
    }

    @Override
    public Mono<Void> borrarAfiliacion(Integer id) {
        return null;
    }

    @Override
    public Mono<Afiliacion> buscarAfiliacion(Integer id) {
        return null;
    }

    @Override
    public Flux<Afiliacion> listaAfiliacion() {
        return null;
    }
}


