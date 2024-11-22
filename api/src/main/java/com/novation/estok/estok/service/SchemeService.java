package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.Scheme;
import com.novation.estok.estok.model.SchemeDTO;
import com.novation.estok.estok.repos.SchemeRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SchemeService {

    private final SchemeRepository schemeRepository;

    public SchemeService(final SchemeRepository schemeRepository) {
        this.schemeRepository = schemeRepository;
    }

    public List<SchemeDTO> findAll() {
        final List<Scheme> schemes = schemeRepository.findAll(Sort.by("id"));
        return schemes.stream()
                .map(scheme -> mapToDTO(scheme, new SchemeDTO()))
                .toList();
    }

    public SchemeDTO get(final Long id) {
        return schemeRepository.findById(id)
                .map(scheme -> mapToDTO(scheme, new SchemeDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final SchemeDTO schemeDTO) {
        final Scheme scheme = new Scheme();
        mapToEntity(schemeDTO, scheme);
        return schemeRepository.save(scheme).getId();
    }

    public void update(final Long id, final SchemeDTO schemeDTO) {
        final Scheme scheme = schemeRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(schemeDTO, scheme);
        schemeRepository.save(scheme);
    }

    public void delete(final Long id) {
        schemeRepository.deleteById(id);
    }

    private SchemeDTO mapToDTO(final Scheme scheme, final SchemeDTO schemeDTO) {
        schemeDTO.setId(scheme.getId());
        schemeDTO.setSchemeName(scheme.getSchemeName());
        schemeDTO.setSchemeDescription(scheme.getSchemeDescription());
        return schemeDTO;
    }

    private Scheme mapToEntity(final SchemeDTO schemeDTO, final Scheme scheme) {
        scheme.setSchemeName(schemeDTO.getSchemeName());
        scheme.setSchemeDescription(schemeDTO.getSchemeDescription());
        return scheme;
    }

}
