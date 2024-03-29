package pl.project.invoicing.helpers

import pl.project.invoicing.model.Car
import pl.project.invoicing.model.Company
import pl.project.invoicing.model.Invoice
import pl.project.invoicing.model.InvoiceEntry
import pl.project.invoicing.model.Vat

import java.time.LocalDate

class TestHelpers {

    static company(long id) {
        Company.builder()
                .taxIdentificationNumber("$id")
                .address("ul. Bukowińska 24d/$id 02-703 Warszawa, Polska")
                .name("iCode Trust $id Sp. z o.o")
                .pensionInsurance((BigDecimal.TEN * BigDecimal.valueOf(id)).setScale(2))
                .healthInsurance((BigDecimal.valueOf(100) * BigDecimal.valueOf(id)).setScale(2))
                .build()
    }

    static product(long id) {
        InvoiceEntry.builder()
                .description("Programming course $id")
                .quantity(1.52)
                .netPrice(BigDecimal.valueOf(id * 1000).setScale(2))
                .vatValue(BigDecimal.valueOf(id * 1000 * 0.08).setScale(2))
                .vatRate(Vat.VAT_8)
                .expenseRelatedToCar(id % 2 == 0 ? null :
                        Car.builder()
                                .registrationNumber("XYZ")
                                .personalUse(false)
                                .build()
                )
                .build()
    }

    static invoice(long id) {
        Invoice.builder()
                .date(LocalDate.now())
                .number("123/4242/43221/$id")
                .buyer(company(id + 10))
                .seller(company(id))
                .entries((1..id).collect({ product(it) }))
                .build()
    }

    static Invoice resetIds(Invoice invoice) {
        invoice.getBuyer().id = null
        invoice.getSeller().id = null
        invoice.entries.forEach {
            it.id = null
            it.expenseRelatedToCar?.id = null
        }
        invoice
    }

    static List<Invoice> resetIds(List<Invoice> invoices) {
        invoices.forEach { invoice -> resetIds(invoice) }
    }

}
