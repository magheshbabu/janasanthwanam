package com.gsr.janasanth.service;

import com.gsr.janasanth.service.dto.ApekshaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Apeksha.
 */
public interface ApekshaService {

    /**
     * Save a apeksha.
     *
     * @param apekshaDTO the entity to save
     * @return the persisted entity
     */
    ApekshaDTO save(ApekshaDTO apekshaDTO);

    /**
     *  Get all the apekshas.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ApekshaDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" apeksha.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ApekshaDTO findOne(Long id);

    /**
     *  Delete the "id" apeksha.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the apeksha corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ApekshaDTO> search(String query, Pageable pageable);
}
