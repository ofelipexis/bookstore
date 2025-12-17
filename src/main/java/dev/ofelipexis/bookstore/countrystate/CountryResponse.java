package dev.ofelipexis.bookstore.countrystate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name"})
public class CountryResponse {

    private Long id;
    private String name;

    public CountryResponse(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
