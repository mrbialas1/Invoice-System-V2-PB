package pl.project.invoicing.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pl.project.invoicing.db.Database;
import pl.project.invoicing.model.Invoice;

@Service
public class InvoiceService {

  private final Database database;

  public InvoiceService(Database database) {
    this.database = database;
  }

  public long save(Invoice invoice) {
    return database.save(invoice);
  }

  public Optional<Invoice> getById(long id) {
    return database.getById(id);
  }

  public List<Invoice> getAll() {
    return database.getAll();
  }

  public Optional<Invoice> update(long id, Invoice updatedInvoice) {
    return database.update(id, updatedInvoice);
  }

  public Optional<Invoice> delete(long id) {
    return database.delete(id);
  }

}
