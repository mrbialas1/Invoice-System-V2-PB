package pl.project.invoicing.db.file

import pl.project.invoicing.db.AbstractDatabaseTest
import pl.project.invoicing.db.Database
import pl.project.invoicing.helpers.TestHelpers
import pl.project.invoicing.model.Invoice
import pl.project.invoicing.utils.FilesService
import pl.project.invoicing.utils.JsonService

import java.nio.file.Files
import java.nio.file.Path

class FileBasedDatabaseIntegrationTest extends AbstractDatabaseTest {

    Path dbPath

    @Override
    Database getDatabaseInstance() {
        def filesService = new FilesService()

        def idPath = File.createTempFile('ids', '.txt').toPath()
        def idService = new IdProvider(idPath, filesService)

        dbPath = File.createTempFile('invoices', '.txt').toPath()
        new FileBasedDatabase(dbPath, idService, filesService, new JsonService(), Invoice)
    }

    def "file based database writes invoices to correct file"() {
        given:
        def db = getDatabaseInstance()

        when:
        db.save(TestHelpers.invoice(4))

        then:
        1 == Files.readAllLines(dbPath).size()

        when:
        db.save(TestHelpers.invoice(5))

        then:
        2 == Files.readAllLines(dbPath).size()
    }
}
