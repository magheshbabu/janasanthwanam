package com.gsr.janasanth.service.impl;

import com.gsr.janasanth.service.ApekshaService;
import com.gsr.janasanth.domain.Apeksha;
import com.gsr.janasanth.repository.ApekshaRepository;
import com.gsr.janasanth.repository.search.ApekshaSearchRepository;
import com.gsr.janasanth.service.dto.ApekshaDTO;
import com.gsr.janasanth.service.mapper.ApekshaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Apeksha.
 */
@Service
@Transactional
public class ApekshaServiceImpl implements ApekshaService{

    private final Logger log = LoggerFactory.getLogger(ApekshaServiceImpl.class);

    private final ApekshaRepository apekshaRepository;

    private final ApekshaMapper apekshaMapper;

    private final ApekshaSearchRepository apekshaSearchRepository;

    public ApekshaServiceImpl(ApekshaRepository apekshaRepository, ApekshaMapper apekshaMapper, ApekshaSearchRepository apekshaSearchRepository) {
        this.apekshaRepository = apekshaRepository;
        this.apekshaMapper = apekshaMapper;
        this.apekshaSearchRepository = apekshaSearchRepository;
    }

    /**
     * Save a apeksha.
     *
     * @param apekshaDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ApekshaDTO save(ApekshaDTO apekshaDTO) {
        log.debug("Request to save Apeksha : {}", apekshaDTO);
        Apeksha apeksha = apekshaMapper.toEntity(apekshaDTO);
        apeksha = apekshaRepository.save(apeksha);
        ApekshaDTO result = apekshaMapper.toDto(apeksha);
        apekshaSearchRepository.save(apeksha);
        return result;
    }

    /**
     *  Get all the apekshas.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ApekshaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Apekshas");
        return apekshaRepository.findAll(pageable)
            .map(apekshaMapper::toDto);
    }

    /**
     *  Get one apeksha by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ApekshaDTO findOne(Long id) {
        log.debug("Request to get Apeksha : {}", id);
        Apeksha apeksha = apekshaRepository.findOne(id);
        return apekshaMapper.toDto(apeksha);
    }

    /**
     *  Delete the  apeksha by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Apeksha : {}", id);
        apekshaRepository.delete(id);
        apekshaSearchRepository.delete(id);
    }

    /**
     * Search for the apeksha corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ApekshaDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Apekshas for query {}", query);
        Page<Apeksha> result = apekshaSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(apekshaMapper::toDto);
    }
}
