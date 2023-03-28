package co.com.sofka.jpa.beneficiario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioDtoRepository extends CrudRepository<BeneficiarioDto, Integer>, QueryByExampleExecutor<BeneficiarioDto> {
}
