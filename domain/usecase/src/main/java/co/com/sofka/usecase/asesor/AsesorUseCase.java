package co.com.sofka.usecase.asesor;

import co.com.sofka.model.asesor.Asesor;
import co.com.sofka.model.asesor.gateways.AsesorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AsesorUseCase {
    private final AsesorRepository asesorRepository;

    public Mono<Asesor> crearAsesor(Asesor asesor) {
        return asesorRepository.crearAsesor(asesor);
    }

    public Mono<Asesor> actualizarAsesor(Integer id,Asesor asesor) {
        return asesorRepository.actualizarAsesor(id, asesor);
    }

    public Mono<Void> borrarAsesor(Integer id) {
        return asesorRepository.borrarAsesor(id);
    }

    public Mono<Asesor> buscarAsesor(Integer id) {
        return asesorRepository.buscarAsesor(id);
    }

    public Flux<Asesor> listaAsesor() {
        return asesorRepository.listaAsesor();
    }
}
