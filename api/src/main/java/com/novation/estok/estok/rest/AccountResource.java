package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.AccountDTO;
import com.novation.estok.estok.service.AccountService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(final AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createAccount(@RequestBody @Valid final AccountDTO accountDTO) {
        final Long createdId = accountService.create(accountDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAccount(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final AccountDTO accountDTO) {
        accountService.update(id, accountDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable(name = "id") final Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
