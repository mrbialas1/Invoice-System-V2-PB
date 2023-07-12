package pl.project.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Company {

  @ApiModelProperty(value = "Tax identification number", required = true, example = "798-673-18-66")
  private String taxIdentificationNumber;

  @ApiModelProperty(value = "Company address", required = true, example = "ul. Kozielska 23, 44-100 Gliwice")
  private String address;

  @ApiModelProperty(value = "Company name", required = true, example = "InInvoices")
  private String name;

  public Company(String taxIdentificationNumber, String address, String name) {
    this.taxIdentificationNumber = taxIdentificationNumber;
    this.address = address;
    this.name = name;
  }

}
