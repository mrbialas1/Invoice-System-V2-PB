package pl.project.invoicing.db.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.IfProfileValue
import pl.project.invoicing.db.AbstractDatabaseTest
import pl.project.invoicing.db.Database
import pl.project.invoicing.db.sql.jpa.InvoiceRepository
import pl.project.invoicing.db.sql.jpa.JpaDatabase

@DataJpaTest
@IfProfileValue(name = "spring.profiles.active", value = "jpa")
class JpaDatabaseIntegrationTest extends AbstractDatabaseTest {

    @Autowired
    private InvoiceRepository invoiceRepository

    @Override
    Database getDatabaseInstance() {
        assert invoiceRepository != null
        new JpaDatabase(invoiceRepository)
    }

}
