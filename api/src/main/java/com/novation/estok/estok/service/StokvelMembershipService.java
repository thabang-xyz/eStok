package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.StokvelMembership;
import com.novation.estok.estok.model.StokvelMembershipDTO;
import com.novation.estok.estok.repos.StokvelMembershipRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class StokvelMembershipService {

    private final StokvelMembershipRepository stokvelMembershipRepository;

    public StokvelMembershipService(final StokvelMembershipRepository stokvelMembershipRepository) {
        this.stokvelMembershipRepository = stokvelMembershipRepository;
    }

    public List<StokvelMembershipDTO> findAll() {
        final List<StokvelMembership> stokvelMemberships = stokvelMembershipRepository.findAll(Sort.by("id"));
        return stokvelMemberships.stream()
                .map(stokvelMembership -> mapToDTO(stokvelMembership, new StokvelMembershipDTO()))
                .toList();
    }

    public StokvelMembershipDTO get(final Long id) {
        return stokvelMembershipRepository.findById(id)
                .map(stokvelMembership -> mapToDTO(stokvelMembership, new StokvelMembershipDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final StokvelMembershipDTO stokvelMembershipDTO) {
        final StokvelMembership stokvelMembership = new StokvelMembership();
        mapToEntity(stokvelMembershipDTO, stokvelMembership);
        return stokvelMembershipRepository.save(stokvelMembership).getId();
    }

    public void update(final Long id, final StokvelMembershipDTO stokvelMembershipDTO) {
        final StokvelMembership stokvelMembership = stokvelMembershipRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(stokvelMembershipDTO, stokvelMembership);
        stokvelMembershipRepository.save(stokvelMembership);
    }

    public void delete(final Long id) {
        stokvelMembershipRepository.deleteById(id);
    }

    private StokvelMembershipDTO mapToDTO(final StokvelMembership stokvelMembership,
            final StokvelMembershipDTO stokvelMembershipDTO) {
        stokvelMembershipDTO.setId(stokvelMembership.getId());
        stokvelMembershipDTO.setName(stokvelMembership.getName());
        return stokvelMembershipDTO;
    }

    private StokvelMembership mapToEntity(final StokvelMembershipDTO stokvelMembershipDTO,
            final StokvelMembership stokvelMembership) {
        stokvelMembership.setName(stokvelMembershipDTO.getName());
        return stokvelMembership;
    }

}
