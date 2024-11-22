package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.PaymentMethodDTO;
import com.novation.estok.estok.service.PaymentMethodService;
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
@RequestMapping(value = "/api/paymentMethods", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentMethodResource {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodResource(final PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethodDTO>> getAllPaymentMethods() {
        return ResponseEntity.ok(paymentMethodService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodDTO> getPaymentMethod(
            @PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(paymentMethodService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createPaymentMethod(
            @RequestBody @Valid final PaymentMethodDTO paymentMethodDTO) {
        final Long createdId = paymentMethodService.create(paymentMethodDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePaymentMethod(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final PaymentMethodDTO paymentMethodDTO) {
        paymentMethodService.update(id, paymentMethodDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable(name = "id") final Long id) {
        paymentMethodService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
