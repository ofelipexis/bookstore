package dev.ofelipexis.bookstore.countrystate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name"})
public class StateResponse {

    private Long id;
    private String name;
    private Long countryId;

    public StateResponse(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.countryId = state.getCountry().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }
}
