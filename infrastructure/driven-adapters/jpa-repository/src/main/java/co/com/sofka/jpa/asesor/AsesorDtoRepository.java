package co.com.sofka.jpa.asesor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorDtoRepository extends CrudRepository<AsesorDto, Integer>, QueryByExampleExecutor<AsesorDto> {
}
