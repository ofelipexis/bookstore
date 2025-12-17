package dev.ofelipexis.bookstore.countrystate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class StateController {

    private StateRepository repository;

    public StateController(StateRepository repository) {
        this.repository = repository;
    }

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/states")
    @Transactional
    public ResponseEntity<StateResponse> create(@RequestBody @Valid StateRequest request) {
        State state = request.toModel(
                id -> manager.find(Country.class, id)
        );
        repository.save(state);
        return ResponseEntity.ok().body(new StateResponse(state));
    }
}
