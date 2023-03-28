package co.com.sofka.jpa.renta;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.jpa.renta.rentaMappers.RentaMappers;
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
        if (repository.findById(id).isPresent()) {
            RentaDto rentaDto = RentaMappers.rentaConvertirARentaDTO(renta);
            rentaDto.setId(id);
            return Mono.just(RentaMappers.rentaDTOConvertirARenta(repository.save(rentaDto)));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la renta con el id :" + id));
        }
    }

    @Override
    public Mono<Void> borrarRenta(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return Mono.empty();
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la renta con el id :" + id));
        }
    }

    @Override
    public Mono<Renta> buscarRenta(Integer id) {
        if (repository.findById(id).isPresent()) {
            return Mono.just(RentaMappers.rentaDTOConvertirARenta(repository.findById(id).get()));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la renta con el id :" + id));
        }
    }

    @Override
    public Flux<Renta> listaRenta() {
        var Lista = repository.findAll();
        return Flux.fromIterable(Lista).map(RentaMappers::rentaDTOConvertirARenta);
    }
}
