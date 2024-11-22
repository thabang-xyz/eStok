package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.StokvelFund;
import com.novation.estok.estok.model.StokvelFundDTO;
import com.novation.estok.estok.repos.StokvelFundRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class StokvelFundService {

    private final StokvelFundRepository stokvelFundRepository;

    public StokvelFundService(final StokvelFundRepository stokvelFundRepository) {
        this.stokvelFundRepository = stokvelFundRepository;
    }

    public List<StokvelFundDTO> findAll() {
        final List<StokvelFund> stokvelFunds = stokvelFundRepository.findAll(Sort.by("id"));
        return stokvelFunds.stream()
                .map(stokvelFund -> mapToDTO(stokvelFund, new StokvelFundDTO()))
                .toList();
    }

    public StokvelFundDTO get(final Long id) {
        return stokvelFundRepository.findById(id)
                .map(stokvelFund -> mapToDTO(stokvelFund, new StokvelFundDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final StokvelFundDTO stokvelFundDTO) {
        final StokvelFund stokvelFund = new StokvelFund();
        mapToEntity(stokvelFundDTO, stokvelFund);
        return stokvelFundRepository.save(stokvelFund).getId();
    }

    public void update(final Long id, final StokvelFundDTO stokvelFundDTO) {
        final StokvelFund stokvelFund = stokvelFundRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(stokvelFundDTO, stokvelFund);
        stokvelFundRepository.save(stokvelFund);
    }

    public void delete(final Long id) {
        stokvelFundRepository.deleteById(id);
    }

    private StokvelFundDTO mapToDTO(final StokvelFund stokvelFund,
            final StokvelFundDTO stokvelFundDTO) {
        stokvelFundDTO.setId(stokvelFund.getId());
        stokvelFundDTO.setName(stokvelFund.getName());
        return stokvelFundDTO;
    }

    private StokvelFund mapToEntity(final StokvelFundDTO stokvelFundDTO,
            final StokvelFund stokvelFund) {
        stokvelFund.setName(stokvelFundDTO.getName());
        return stokvelFund;
    }

}
