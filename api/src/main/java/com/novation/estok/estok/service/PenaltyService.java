package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.Penalty;
import com.novation.estok.estok.model.PenaltyDTO;
import com.novation.estok.estok.repos.PenaltyRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PenaltyService {

    private final PenaltyRepository penaltyRepository;

    public PenaltyService(final PenaltyRepository penaltyRepository) {
        this.penaltyRepository = penaltyRepository;
    }

    public List<PenaltyDTO> findAll() {
        final List<Penalty> penalties = penaltyRepository.findAll(Sort.by("id"));
        return penalties.stream()
                .map(penalty -> mapToDTO(penalty, new PenaltyDTO()))
                .toList();
    }

    public PenaltyDTO get(final Long id) {
        return penaltyRepository.findById(id)
                .map(penalty -> mapToDTO(penalty, new PenaltyDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PenaltyDTO penaltyDTO) {
        final Penalty penalty = new Penalty();
        mapToEntity(penaltyDTO, penalty);
        return penaltyRepository.save(penalty).getId();
    }

    public void update(final Long id, final PenaltyDTO penaltyDTO) {
        final Penalty penalty = penaltyRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(penaltyDTO, penalty);
        penaltyRepository.save(penalty);
    }

    public void delete(final Long id) {
        penaltyRepository.deleteById(id);
    }

    private PenaltyDTO mapToDTO(final Penalty penalty, final PenaltyDTO penaltyDTO) {
        penaltyDTO.setId(penalty.getId());
        penaltyDTO.setReason(penalty.getReason());
        return penaltyDTO;
    }

    private Penalty mapToEntity(final PenaltyDTO penaltyDTO, final Penalty penalty) {
        penalty.setReason(penaltyDTO.getReason());
        return penalty;
    }

}
