package pl.project.invoicing.controller.tax;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.project.invoicing.model.Company;
import pl.project.invoicing.service.TaxCalculatorResult;
import pl.project.invoicing.service.TaxCalculatorService;

@RestController
@AllArgsConstructor
public class TaxCalculatorController implements TaxCalculatorApi {

  private final TaxCalculatorService taxService;

  @Override
  public TaxCalculatorResult calculateTaxes(@RequestBody Company company) {
    return taxService.calculateTaxes(company);
  }
}
