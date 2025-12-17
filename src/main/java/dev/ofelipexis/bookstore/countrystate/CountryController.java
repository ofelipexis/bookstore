package dev.ofelipexis.bookstore.countrystate;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class CountryController {

    private CountryRepository repository;

    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/countries")
    @Transactional
    public ResponseEntity<CountryResponse> create(@RequestBody @Valid CountryRequest request) {
        Country country = request.toModel();
        repository.save(country);
        return ResponseEntity.ok().body(new CountryResponse(country));
    }
}
