package pl.project.invoicing.db.mongo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.IfProfileValue
import pl.project.invoicing.db.AbstractDatabaseTest
import pl.project.invoicing.db.Database
import pl.project.invoicing.model.Invoice

@SpringBootTest
@IfProfileValue(name = "spring.profiles.active", value = "mongo")
class MongoDatabaseIntegrationTest extends AbstractDatabaseTest {

    @Autowired
    private Database<Invoice> mongoDatabase

    @Override
    Database getDatabaseInstance() {
        assert mongoDatabase != null
        mongoDatabase
    }

}
