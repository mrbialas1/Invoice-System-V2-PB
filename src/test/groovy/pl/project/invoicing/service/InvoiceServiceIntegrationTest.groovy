package pl.project.invoicing.service

import pl.project.invoicing.db.Database
import pl.project.invoicing.db.memory.InMemoryDatabase
import pl.project.invoicing.model.Invoice
import pl.project.invoicing.service.invoice.InvoiceService
import spock.lang.Specification

import static pl.project.invoicing.helpers.TestHelpers.invoice

class InvoiceServiceIntegrationTest extends Specification {

    private InvoiceService service
    private List<Invoice> invoices

    def setup() {
        Database db = new InMemoryDatabase()
        service = new InvoiceService(db)

        invoices = (1L..12).collect { invoice(it) }
    }

    def "should save invoices returning sequential id, invoice should have id set to correct value, get by id returns saved invoice"() {
        when:
        def ids = invoices.collect{ service.save(it) }

        then:
        (1..invoices.size() - 1).forEach { assert ids[it] == ids[0] + it }
    }

    def "get by id returns empty optional when there is no invoice with given id"() {
        expect:
        !service.getById(1).isPresent()
    }

    def "get all returns empty collection if there were no invoices"() {
        expect:
        service.getAll().isEmpty()
    }

    def "get all returns all invoices in the database, deleted invoice is not returned"() {
        given:
        invoices.forEach{it.id = service.save(it) }

        expect:
        service.getAll().size() == invoices.size()
        service.getAll().forEach { assert it == invoices.get((int)it.getId() - 1) }

        when:
        service.delete(1)

        then:
        service.getAll().size() == invoices.size() - 1
        service.getAll().forEach { assert it == invoices.get((int)it.getId() - 1) }
        service.getAll().forEach { assert it.getId() != 1 }
    }

    def "can delete all invoices"() {
        given:
        invoices.forEach{ service.save(it) }

        when:
        invoices.forEach{ service.delete(it.getId()) }

        then:
        service.getAll().isEmpty()
    }

    def "deleting not existing invoice returns Optional.empty()"() {
        expect:
        service.delete(123) == Optional.empty()
    }

    def "it's possible to update the invoice, previous invoice is returned"() {
        given:
        def originalInvoice = invoices.get(0)
        long id = service.save(originalInvoice)

        when:
        def result = service.update(id, invoices.get(1))

        then:
        service.getById(id).get() == invoices.get(1)
        result == Optional.of(originalInvoice)
    }

    def "updating not existing invoice returns Optional.empty()"() {
        expect:
        service.update(213, invoices.get(1)) == Optional.empty()
    }

}
