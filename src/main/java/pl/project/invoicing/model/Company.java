package pl.project.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

  @ApiModelProperty(value = "Tax identification number", required = true, example = "798-673-18-66")
  private String taxIdentificationNumber;

  @ApiModelProperty(value = "Company address", required = true, example = "ul. Kozielska 23, 44-100 Gliwice")
  private String address;

  @ApiModelProperty(value = "Company name", required = true, example = "InInvoices")
  private String name;

  @ApiModelProperty(value = "Company cars")
  private List<Car> cars;

  @Builder.Default
  @ApiModelProperty(value = "Pension insurance amount", required = true, example = "1567.24")
  private BigDecimal pensionInsurance = BigDecimal.ZERO;

  @Builder.Default
  @ApiModelProperty(value = "Health insurance amount", required = true, example = "521.33")
  private BigDecimal healthInsurance = BigDecimal.ZERO;

  public Company(String taxIdentificationNumber, String address, String name) {
    this.taxIdentificationNumber = taxIdentificationNumber;
    this.address = address;
    this.name = name;
  }

}
