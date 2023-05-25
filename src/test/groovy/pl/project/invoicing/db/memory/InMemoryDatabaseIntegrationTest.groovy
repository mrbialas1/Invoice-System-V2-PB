package pl.project.invoicing.db.memory

import pl.project.invoicing.db.AbstractDatabaseTest
import pl.project.invoicing.db.Database

class InMemoryDatabaseIntegrationTest extends AbstractDatabaseTest {

    @Override
    Database getDatabaseInstance() {
        return new InMemoryDatabase()
    }
}
