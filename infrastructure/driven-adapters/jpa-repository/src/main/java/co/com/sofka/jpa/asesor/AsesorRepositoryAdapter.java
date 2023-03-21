package co.com.sofka.jpa.asesor;

import co.com.sofka.jpa.afiliacion.AfiliacionDto;
import co.com.sofka.jpa.afiliacion.afiliacionMappers.AfiliacionMappers;
import co.com.sofka.jpa.asesor.asesorMappers.AsesorMappers;
import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.jpa.renta.RentaDto;
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
        return Mono.just(save(asesor));
    }

    @Override
    public Mono<Asesor> actualizarAsesor(Integer id, Asesor asesor) {
        if (repository.findById(id).isPresent()) {
            AsesorDto asesorDto = AsesorMappers.asesorConvertirAAsesorDTO(asesor);
            asesorDto.setId(id);
            return Mono.just(AsesorMappers.asesorDTOConvertirAAsesor(repository.save(asesorDto)));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la asesor con el id :" + id));
        }
    }

    @Override
    public Mono<Void> borrarAsesor(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return Mono.empty();
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la asesor con el id :" + id));
        }
    }

    @Override
    public Mono<Asesor> buscarAsesor(Integer id) {
        if (repository.findById(id).isPresent()) {
            return Mono.just(AsesorMappers.asesorDTOConvertirAAsesor(repository.findById(id).get()));
        }else {
            return Mono.error(new IllegalArgumentException("No se encuentra la asesor con el id :" + id));
        }
    }

    @Override
    public Flux<Asesor> listaAsesor() {
        var Lista = repository.findAll();
        return Flux.fromIterable(Lista).map(AsesorMappers::asesorDTOConvertirAAsesor);
    }
}


