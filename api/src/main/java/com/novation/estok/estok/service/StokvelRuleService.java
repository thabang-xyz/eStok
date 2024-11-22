package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.StokvelRule;
import com.novation.estok.estok.model.StokvelRuleDTO;
import com.novation.estok.estok.repos.StokvelRuleRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class StokvelRuleService {

    private final StokvelRuleRepository stokvelRuleRepository;

    public StokvelRuleService(final StokvelRuleRepository stokvelRuleRepository) {
        this.stokvelRuleRepository = stokvelRuleRepository;
    }

    public List<StokvelRuleDTO> findAll() {
        final List<StokvelRule> stokvelRules = stokvelRuleRepository.findAll(Sort.by("id"));
        return stokvelRules.stream()
                .map(stokvelRule -> mapToDTO(stokvelRule, new StokvelRuleDTO()))
                .toList();
    }

    public StokvelRuleDTO get(final Long id) {
        return stokvelRuleRepository.findById(id)
                .map(stokvelRule -> mapToDTO(stokvelRule, new StokvelRuleDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final StokvelRuleDTO stokvelRuleDTO) {
        final StokvelRule stokvelRule = new StokvelRule();
        mapToEntity(stokvelRuleDTO, stokvelRule);
        return stokvelRuleRepository.save(stokvelRule).getId();
    }

    public void update(final Long id, final StokvelRuleDTO stokvelRuleDTO) {
        final StokvelRule stokvelRule = stokvelRuleRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(stokvelRuleDTO, stokvelRule);
        stokvelRuleRepository.save(stokvelRule);
    }

    public void delete(final Long id) {
        stokvelRuleRepository.deleteById(id);
    }

    private StokvelRuleDTO mapToDTO(final StokvelRule stokvelRule,
            final StokvelRuleDTO stokvelRuleDTO) {
        stokvelRuleDTO.setId(stokvelRule.getId());
        stokvelRuleDTO.setRulename(stokvelRule.getRulename());
        return stokvelRuleDTO;
    }

    private StokvelRule mapToEntity(final StokvelRuleDTO stokvelRuleDTO,
            final StokvelRule stokvelRule) {
        stokvelRule.setRulename(stokvelRuleDTO.getRulename());
        return stokvelRule;
    }

}
