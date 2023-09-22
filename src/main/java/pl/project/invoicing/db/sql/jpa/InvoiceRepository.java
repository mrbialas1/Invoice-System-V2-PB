package pl.project.invoicing.db.sql.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.project.invoicing.model.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
