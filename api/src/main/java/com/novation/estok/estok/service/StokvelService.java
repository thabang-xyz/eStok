package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.Stokvel;
import com.novation.estok.estok.model.StokvelDTO;
import com.novation.estok.estok.repos.StokvelRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class StokvelService {

    private final StokvelRepository stokvelRepository;

    public StokvelService(final StokvelRepository stokvelRepository) {
        this.stokvelRepository = stokvelRepository;
    }

    public List<StokvelDTO> findAll() {
        final List<Stokvel> stokvels = stokvelRepository.findAll(Sort.by("id"));
        return stokvels.stream()
                .map(stokvel -> mapToDTO(stokvel, new StokvelDTO()))
                .toList();
    }

    public StokvelDTO get(final Long id) {
        return stokvelRepository.findById(id)
                .map(stokvel -> mapToDTO(stokvel, new StokvelDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final StokvelDTO stokvelDTO) {
        final Stokvel stokvel = new Stokvel();
        mapToEntity(stokvelDTO, stokvel);
        return stokvelRepository.save(stokvel).getId();
    }

    public void update(final Long id, final StokvelDTO stokvelDTO) {
        final Stokvel stokvel = stokvelRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(stokvelDTO, stokvel);
        stokvelRepository.save(stokvel);
    }

    public void delete(final Long id) {
        stokvelRepository.deleteById(id);
    }

    private StokvelDTO mapToDTO(final Stokvel stokvel, final StokvelDTO stokvelDTO) {
        stokvelDTO.setId(stokvel.getId());
        stokvelDTO.setName(stokvel.getName());
        return stokvelDTO;
    }

    private Stokvel mapToEntity(final StokvelDTO stokvelDTO, final Stokvel stokvel) {
        stokvel.setName(stokvelDTO.getName());
        return stokvel;
    }

}
