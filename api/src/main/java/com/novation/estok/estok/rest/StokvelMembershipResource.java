package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.StokvelMembershipDTO;
import com.novation.estok.estok.service.StokvelMembershipService;
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
@RequestMapping(value = "/api/stokvelMemberships", produces = MediaType.APPLICATION_JSON_VALUE)
public class StokvelMembershipResource {

    private final StokvelMembershipService stokvelMembershipService;

    public StokvelMembershipResource(final StokvelMembershipService stokvelMembershipService) {
        this.stokvelMembershipService = stokvelMembershipService;
    }

    @GetMapping
    public ResponseEntity<List<StokvelMembershipDTO>> getAllStokvelMemberships() {
        return ResponseEntity.ok(stokvelMembershipService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StokvelMembershipDTO> getStokvelMembership(
            @PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(stokvelMembershipService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createStokvelMembership(
            @RequestBody @Valid final StokvelMembershipDTO stokvelMembershipDTO) {
        final Long createdId = stokvelMembershipService.create(stokvelMembershipDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateStokvelMembership(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final StokvelMembershipDTO stokvelMembershipDTO) {
        stokvelMembershipService.update(id, stokvelMembershipDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStokvelMembership(@PathVariable(name = "id") final Long id) {
        stokvelMembershipService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
