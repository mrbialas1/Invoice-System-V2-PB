package pl.project.invoicing.service;

import java.util.List;
import java.util.Optional;
import pl.project.invoicing.db.Database;
import pl.project.invoicing.model.Invoice;

public class InvoiceService {

  private final Database database;

  public InvoiceService(Database database) {
    this.database = database;
  }

  public int save(Invoice invoice) {
    return database.save(invoice);
  }

  public Optional<Invoice> getById(int id) {
    return database.getById(id);
  }

  public List<Invoice> getAll() {
    return database.getAll();
  }

  public void update(int id, Invoice updatedInvoice) {
    database.update(id, updatedInvoice);
  }

  public void delete(int id) {
    database.delete(id);
  }

}
