package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.StokvelDTO;
import com.novation.estok.estok.service.StokvelService;
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
@RequestMapping(value = "/api/stokvels", produces = MediaType.APPLICATION_JSON_VALUE)
public class StokvelResource {

    private final StokvelService stokvelService;

    public StokvelResource(final StokvelService stokvelService) {
        this.stokvelService = stokvelService;
    }

    @GetMapping
    public ResponseEntity<List<StokvelDTO>> getAllStokvels() {
        return ResponseEntity.ok(stokvelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StokvelDTO> getStokvel(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(stokvelService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createStokvel(@RequestBody @Valid final StokvelDTO stokvelDTO) {
        final Long createdId = stokvelService.create(stokvelDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateStokvel(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final StokvelDTO stokvelDTO) {
        stokvelService.update(id, stokvelDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStokvel(@PathVariable(name = "id") final Long id) {
        stokvelService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
