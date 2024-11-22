package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.PayoutSchedule;
import com.novation.estok.estok.model.PayoutScheduleDTO;
import com.novation.estok.estok.repos.PayoutScheduleRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PayoutScheduleService {

    private final PayoutScheduleRepository payoutScheduleRepository;

    public PayoutScheduleService(final PayoutScheduleRepository payoutScheduleRepository) {
        this.payoutScheduleRepository = payoutScheduleRepository;
    }

    public List<PayoutScheduleDTO> findAll() {
        final List<PayoutSchedule> payoutSchedules = payoutScheduleRepository.findAll(Sort.by("id"));
        return payoutSchedules.stream()
                .map(payoutSchedule -> mapToDTO(payoutSchedule, new PayoutScheduleDTO()))
                .toList();
    }

    public PayoutScheduleDTO get(final Long id) {
        return payoutScheduleRepository.findById(id)
                .map(payoutSchedule -> mapToDTO(payoutSchedule, new PayoutScheduleDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PayoutScheduleDTO payoutScheduleDTO) {
        final PayoutSchedule payoutSchedule = new PayoutSchedule();
        mapToEntity(payoutScheduleDTO, payoutSchedule);
        return payoutScheduleRepository.save(payoutSchedule).getId();
    }

    public void update(final Long id, final PayoutScheduleDTO payoutScheduleDTO) {
        final PayoutSchedule payoutSchedule = payoutScheduleRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(payoutScheduleDTO, payoutSchedule);
        payoutScheduleRepository.save(payoutSchedule);
    }

    public void delete(final Long id) {
        payoutScheduleRepository.deleteById(id);
    }

    private PayoutScheduleDTO mapToDTO(final PayoutSchedule payoutSchedule,
            final PayoutScheduleDTO payoutScheduleDTO) {
        payoutScheduleDTO.setId(payoutSchedule.getId());
        payoutScheduleDTO.setAmount(payoutSchedule.getAmount());
        return payoutScheduleDTO;
    }

    private PayoutSchedule mapToEntity(final PayoutScheduleDTO payoutScheduleDTO,
            final PayoutSchedule payoutSchedule) {
        payoutSchedule.setAmount(payoutScheduleDTO.getAmount());
        return payoutSchedule;
    }

}
