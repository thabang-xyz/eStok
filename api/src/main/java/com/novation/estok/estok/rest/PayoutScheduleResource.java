package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.PayoutScheduleDTO;
import com.novation.estok.estok.service.PayoutScheduleService;
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
@RequestMapping(value = "/api/payoutSchedules", produces = MediaType.APPLICATION_JSON_VALUE)
public class PayoutScheduleResource {

    private final PayoutScheduleService payoutScheduleService;

    public PayoutScheduleResource(final PayoutScheduleService payoutScheduleService) {
        this.payoutScheduleService = payoutScheduleService;
    }

    @GetMapping
    public ResponseEntity<List<PayoutScheduleDTO>> getAllPayoutSchedules() {
        return ResponseEntity.ok(payoutScheduleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayoutScheduleDTO> getPayoutSchedule(
            @PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(payoutScheduleService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createPayoutSchedule(
            @RequestBody @Valid final PayoutScheduleDTO payoutScheduleDTO) {
        final Long createdId = payoutScheduleService.create(payoutScheduleDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePayoutSchedule(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final PayoutScheduleDTO payoutScheduleDTO) {
        payoutScheduleService.update(id, payoutScheduleDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayoutSchedule(@PathVariable(name = "id") final Long id) {
        payoutScheduleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
