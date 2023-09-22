package pl.project.invoicing

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.project.invoicing.db.memory.InMemoryDatabase
import pl.project.invoicing.service.invoice.InvoiceService
import spock.lang.Specification

@SpringBootTest
class InvoiceApplicationTest extends Specification{

    @Autowired
    private InvoiceService invoiceService = new InvoiceService(new InMemoryDatabase())

    def "invoice service is created"() {
        expect:
        invoiceService
    }

}
