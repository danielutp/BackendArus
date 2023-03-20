package co.com.sofka.jpa.afiliacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacionDtoRepository extends CrudRepository<AfiliacionDto, Integer>, QueryByExampleExecutor<AfiliacionDto> {
}
