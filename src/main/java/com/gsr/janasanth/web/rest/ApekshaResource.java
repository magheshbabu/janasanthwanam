package com.gsr.janasanth.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.gsr.janasanth.service.ApekshaService;
import com.gsr.janasanth.web.rest.util.HeaderUtil;
import com.gsr.janasanth.web.rest.util.PaginationUtil;
import com.gsr.janasanth.service.dto.ApekshaDTO;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing Apeksha.
 */
@RestController
@RequestMapping("/api")
public class ApekshaResource {

    private final Logger log = LoggerFactory.getLogger(ApekshaResource.class);

    private static final String ENTITY_NAME = "apeksha";

    private final ApekshaService apekshaService;

    public ApekshaResource(ApekshaService apekshaService) {
        this.apekshaService = apekshaService;
    }

    /**
     * POST  /apekshas : Create a new apeksha.
     *
     * @param apekshaDTO the apekshaDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new apekshaDTO, or with status 400 (Bad Request) if the apeksha has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/apekshas")
    @Timed
    public ResponseEntity<ApekshaDTO> createApeksha(@Valid @RequestBody ApekshaDTO apekshaDTO) throws URISyntaxException {
        log.debug("REST request to save Apeksha : {}", apekshaDTO);
        if (apekshaDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new apeksha cannot already have an ID")).body(null);
        }
        ApekshaDTO result = apekshaService.save(apekshaDTO);
        return ResponseEntity.created(new URI("/api/apekshas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /apekshas : Updates an existing apeksha.
     *
     * @param apekshaDTO the apekshaDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated apekshaDTO,
     * or with status 400 (Bad Request) if the apekshaDTO is not valid,
     * or with status 500 (Internal Server Error) if the apekshaDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/apekshas")
    @Timed
    public ResponseEntity<ApekshaDTO> updateApeksha(@Valid @RequestBody ApekshaDTO apekshaDTO) throws URISyntaxException {
        log.debug("REST request to update Apeksha : {}", apekshaDTO);
        if (apekshaDTO.getId() == null) {
            return createApeksha(apekshaDTO);
        }
        ApekshaDTO result = apekshaService.save(apekshaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, apekshaDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /apekshas : get all the apekshas.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of apekshas in body
     */
    @GetMapping("/apekshas")
    @Timed
    public ResponseEntity<List<ApekshaDTO>> getAllApekshas(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Apekshas");
        Page<ApekshaDTO> page = apekshaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/apekshas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /apekshas/:id : get the "id" apeksha.
     *
     * @param id the id of the apekshaDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the apekshaDTO, or with status 404 (Not Found)
     */
    @GetMapping("/apekshas/{id}")
    @Timed
    public ResponseEntity<ApekshaDTO> getApeksha(@PathVariable Long id) {
        log.debug("REST request to get Apeksha : {}", id);
        ApekshaDTO apekshaDTO = apekshaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(apekshaDTO));
    }

    /**
     * DELETE  /apekshas/:id : delete the "id" apeksha.
     *
     * @param id the id of the apekshaDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/apekshas/{id}")
    @Timed
    public ResponseEntity<Void> deleteApeksha(@PathVariable Long id) {
        log.debug("REST request to delete Apeksha : {}", id);
        apekshaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/apekshas?query=:query : search for the apeksha corresponding
     * to the query.
     *
     * @param query the query of the apeksha search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/apekshas")
    @Timed
    public ResponseEntity<List<ApekshaDTO>> searchApekshas(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Apekshas for query {}", query);
        Page<ApekshaDTO> page = apekshaService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/apekshas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
