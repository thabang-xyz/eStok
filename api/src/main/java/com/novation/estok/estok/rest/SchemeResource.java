package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.SchemeDTO;
import com.novation.estok.estok.service.SchemeService;
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
@RequestMapping(value = "/api/schemes", produces = MediaType.APPLICATION_JSON_VALUE)
public class SchemeResource {

    private final SchemeService schemeService;

    public SchemeResource(final SchemeService schemeService) {
        this.schemeService = schemeService;
    }

    @GetMapping
    public ResponseEntity<List<SchemeDTO>> getAllSchemes() {
        return ResponseEntity.ok(schemeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchemeDTO> getScheme(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(schemeService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createScheme(@RequestBody @Valid final SchemeDTO schemeDTO) {
        final Long createdId = schemeService.create(schemeDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateScheme(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final SchemeDTO schemeDTO) {
        schemeService.update(id, schemeDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheme(@PathVariable(name = "id") final Long id) {
        schemeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
