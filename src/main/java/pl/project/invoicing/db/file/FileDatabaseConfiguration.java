package pl.project.invoicing.db.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.project.invoicing.db.Database;
import pl.project.invoicing.model.Company;
import pl.project.invoicing.model.Invoice;
import pl.project.invoicing.utils.FilesService;
import pl.project.invoicing.utils.JsonService;

@Configuration
@ConditionalOnProperty(name = "invoicing-system.database", havingValue = "file")
public class FileDatabaseConfiguration {

  @Bean
  public IdProvider idProvider(
      FilesService filesService,
      @Value("${invoicing-system.database.directory}") String databaseDirectory,
      @Value("${invoicing-system.database.id.file}") String idFile
  ) throws IOException {
    Path idFilePath = Files.createTempFile(databaseDirectory, idFile);
    return new IdProvider(idFilePath, filesService);
  }

  @Bean
  public Database<Invoice> invoiceFileBasedDatabase(
      IdProvider idProvider,
      FilesService filesService,
      JsonService jsonService,
      @Value("${invoicing-system.database.directory}") String databaseDirectory,
      @Value("${invoicing-system.database.invoices.file}") String invoicesFile
  ) throws IOException {
    Path databaseFilePath = Files.createTempFile(databaseDirectory, invoicesFile);
    return new FileBasedDatabase<>(databaseFilePath, idProvider, filesService, jsonService, Invoice.class);
  }

  @Bean
  public Database<Company> companyFileBasedDatabase(
      IdProvider idProvider,
      FilesService filesService,
      JsonService jsonService,
      @Value("${invoicing-system.database.directory}") String databaseDirectory,
      @Value("${invoicing-system.database.companies.file}") String companiesFile
  ) throws IOException {
    Path databaseFilePath = Files.createTempFile(databaseDirectory, companiesFile);
    return new FileBasedDatabase<>(databaseFilePath, idProvider, filesService, jsonService, Company.class);
  }

}
