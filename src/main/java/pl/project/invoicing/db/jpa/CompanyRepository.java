package pl.project.invoicing.db.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.project.invoicing.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
