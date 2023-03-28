package co.com.sofka.jpa.persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDtoRepository extends CrudRepository<PersonaDto, Integer>, QueryByExampleExecutor<PersonaDto> {

    PersonaDto findByIdentificacion(Integer identificacion);
}
