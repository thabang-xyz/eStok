package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.StokvelFundDTO;
import com.novation.estok.estok.service.StokvelFundService;
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
@RequestMapping(value = "/api/stokvelFunds", produces = MediaType.APPLICATION_JSON_VALUE)
public class StokvelFundResource {

    private final StokvelFundService stokvelFundService;

    public StokvelFundResource(final StokvelFundService stokvelFundService) {
        this.stokvelFundService = stokvelFundService;
    }

    @GetMapping
    public ResponseEntity<List<StokvelFundDTO>> getAllStokvelFunds() {
        return ResponseEntity.ok(stokvelFundService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StokvelFundDTO> getStokvelFund(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(stokvelFundService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createStokvelFund(
            @RequestBody @Valid final StokvelFundDTO stokvelFundDTO) {
        final Long createdId = stokvelFundService.create(stokvelFundDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateStokvelFund(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final StokvelFundDTO stokvelFundDTO) {
        stokvelFundService.update(id, stokvelFundDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStokvelFund(@PathVariable(name = "id") final Long id) {
        stokvelFundService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
