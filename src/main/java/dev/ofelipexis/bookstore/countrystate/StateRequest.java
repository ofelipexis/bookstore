package dev.ofelipexis.bookstore.countrystate;

import dev.ofelipexis.bookstore.shared.validators.IdExists;
import dev.ofelipexis.bookstore.shared.validators.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.function.Function;

public class StateRequest {

    @NotBlank(message = "Nome do estado não pode estar em branco")
    @UniqueValue(fieldName = "name", domainClass = State.class, message = "Estado já cadastrado")
    private String name;
    @NotNull
    @IdExists(fieldName = "id", domainClass = Country.class, message = "País não encontrado")
    private Long countryId;

    public StateRequest(String name, Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toModel(Function<Long, Country> findCountry) {
        @NotNull
        Country country = findCountry.apply(this.countryId);

        Assert.state(Objects.nonNull(country), "País não encontrado");

        return new State(this.name, country);
    }
}
