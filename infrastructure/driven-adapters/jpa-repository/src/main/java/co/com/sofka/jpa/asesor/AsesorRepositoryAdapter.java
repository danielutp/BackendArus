package co.com.sofka.jpa.asesor;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.asesor.Asesor;
import co.com.sofka.model.asesor.gateways.AsesorRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class AsesorRepositoryAdapter extends AdapterOperations <Asesor, AsesorDto, Integer, AsesorDtoRepository>
        implements AsesorRepository {


    public AsesorRepositoryAdapter(AsesorDtoRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Asesor.AsesorBuilder.class).build());   }


    @Override
    public Mono<Asesor> crearAsesor(Asesor asesor) {
        return null;
    }

    @Override
    public Mono<Asesor> actualizarAsesor(Integer id, Asesor asesor) {
        return null;
    }

    @Override
    public Mono<Void> borrarAsesor(Integer id) {
        return null;
    }

    @Override
    public Mono<Asesor> buscarAsesor(Integer id) {
        return null;
    }

    @Override
    public Flux<Asesor> listaAsesor() {
        return null;
    }
}


