package co.com.sofka.jpa.renta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RentaDtoRepository extends CrudRepository<RentaDto, Integer>, QueryByExampleExecutor<RentaDto> {
}
