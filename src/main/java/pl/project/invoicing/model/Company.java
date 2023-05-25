package pl.project.invoicing.model;

import lombok.Data;

@Data
public class Company {
  private String name;
  private String taxIdentificationNumber;
  private String address;

  public Company(String taxIdentificationNumber, String address, String name) {
    this.taxIdentificationNumber = taxIdentificationNumber;
    this.address = address;
    this.name = name;
  }
}
