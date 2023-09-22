package pl.project.invoicing.db.jpa;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.project.invoicing.db.Database;
import pl.project.invoicing.model.Company;
import pl.project.invoicing.model.Invoice;

@Configuration
@ConditionalOnProperty(name = "invoicing-system.database", havingValue = "jpa")
public class JpaDatabaseConfiguration {

  @Bean
  public Database<Invoice> invoiceJpaDatabase(InvoiceRepository repository) {
    return new JpaDatabase<>(repository);
  }

  @Bean
  public Database<Company> companyJpaDatabase(CompanyRepository repository) {
    return new JpaDatabase<>(repository);
  }

}
