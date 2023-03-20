package co.com.sofka.jpa.causante;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CausanteDtoRepository extends CrudRepository<CausanteDto, Integer>, QueryByExampleExecutor<CausanteDto> {
}
