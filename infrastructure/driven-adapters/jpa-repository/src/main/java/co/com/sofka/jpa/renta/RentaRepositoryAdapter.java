package co.com.sofka.jpa.renta;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.renta.Renta;
import co.com.sofka.model.renta.gateways.RentaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class RentaRepositoryAdapter extends AdapterOperations<Renta, RentaDto, Integer, RentaDtoRepository>
        implements RentaRepository {


    public RentaRepositoryAdapter(RentaDtoRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Renta.RentaBuilder.class).build());
    }

    @Override
    public Mono<Renta> crearRenta(Renta renta) {
        return Mono.just(save(renta));
    }

    @Override
    public Mono<Renta> actualizarRenta(Integer id, Renta renta) {
        return null;
    }

    @Override
    public Mono<Void> borrarRenta(Integer id) {
        return null;
    }

    @Override
    public Mono<Renta> buscarRenta(Integer id) {
        return null;
    }

    @Override
    public Flux<Renta> listaRenta() {
        return null;
    }
}
