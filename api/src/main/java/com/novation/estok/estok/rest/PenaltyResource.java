package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.PenaltyDTO;
import com.novation.estok.estok.service.PenaltyService;
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
@RequestMapping(value = "/api/penalties", produces = MediaType.APPLICATION_JSON_VALUE)
public class PenaltyResource {

    private final PenaltyService penaltyService;

    public PenaltyResource(final PenaltyService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @GetMapping
    public ResponseEntity<List<PenaltyDTO>> getAllPenalties() {
        return ResponseEntity.ok(penaltyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PenaltyDTO> getPenalty(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(penaltyService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createPenalty(@RequestBody @Valid final PenaltyDTO penaltyDTO) {
        final Long createdId = penaltyService.create(penaltyDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePenalty(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final PenaltyDTO penaltyDTO) {
        penaltyService.update(id, penaltyDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePenalty(@PathVariable(name = "id") final Long id) {
        penaltyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
