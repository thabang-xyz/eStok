package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.StokvelRuleDTO;
import com.novation.estok.estok.service.StokvelRuleService;
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
@RequestMapping(value = "/api/stokvelRules", produces = MediaType.APPLICATION_JSON_VALUE)
public class StokvelRuleResource {

    private final StokvelRuleService stokvelRuleService;

    public StokvelRuleResource(final StokvelRuleService stokvelRuleService) {
        this.stokvelRuleService = stokvelRuleService;
    }

    @GetMapping
    public ResponseEntity<List<StokvelRuleDTO>> getAllStokvelRules() {
        return ResponseEntity.ok(stokvelRuleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StokvelRuleDTO> getStokvelRule(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(stokvelRuleService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createStokvelRule(
            @RequestBody @Valid final StokvelRuleDTO stokvelRuleDTO) {
        final Long createdId = stokvelRuleService.create(stokvelRuleDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateStokvelRule(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final StokvelRuleDTO stokvelRuleDTO) {
        stokvelRuleService.update(id, stokvelRuleDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStokvelRule(@PathVariable(name = "id") final Long id) {
        stokvelRuleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
