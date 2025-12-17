package dev.ofelipexis.bookstore.countrystate;

import dev.ofelipexis.bookstore.shared.validators.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CountryRequest {

    @NotBlank(message = "Nome do país não pode estar em branco")
    @UniqueValue(fieldName = "name", domainClass = Country.class, message = "País já cadastrado")
    private String name;

    public String getName() {
        return name;
    }

    public Country toModel() {
        return new Country(this.name);
    }
}
