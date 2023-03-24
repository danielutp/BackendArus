package co.com.sofka.jpa.persona;

import co.com.sofka.model.persona.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PersonaDtoRepository extends CrudRepository<PersonaDto, Integer>, QueryByExampleExecutor<PersonaDto> {

}
