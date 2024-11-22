package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.PaymentMethod;
import com.novation.estok.estok.model.PaymentMethodDTO;
import com.novation.estok.estok.repos.PaymentMethodRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(final PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethodDTO> findAll() {
        final List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll(Sort.by("id"));
        return paymentMethods.stream()
                .map(paymentMethod -> mapToDTO(paymentMethod, new PaymentMethodDTO()))
                .toList();
    }

    public PaymentMethodDTO get(final Long id) {
        return paymentMethodRepository.findById(id)
                .map(paymentMethod -> mapToDTO(paymentMethod, new PaymentMethodDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PaymentMethodDTO paymentMethodDTO) {
        final PaymentMethod paymentMethod = new PaymentMethod();
        mapToEntity(paymentMethodDTO, paymentMethod);
        return paymentMethodRepository.save(paymentMethod).getId();
    }

    public void update(final Long id, final PaymentMethodDTO paymentMethodDTO) {
        final PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(paymentMethodDTO, paymentMethod);
        paymentMethodRepository.save(paymentMethod);
    }

    public void delete(final Long id) {
        paymentMethodRepository.deleteById(id);
    }

    private PaymentMethodDTO mapToDTO(final PaymentMethod paymentMethod,
            final PaymentMethodDTO paymentMethodDTO) {
        paymentMethodDTO.setId(paymentMethod.getId());
        paymentMethodDTO.setMethodName(paymentMethod.getMethodName());
        return paymentMethodDTO;
    }

    private PaymentMethod mapToEntity(final PaymentMethodDTO paymentMethodDTO,
            final PaymentMethod paymentMethod) {
        paymentMethod.setMethodName(paymentMethodDTO.getMethodName());
        return paymentMethod;
    }

}
