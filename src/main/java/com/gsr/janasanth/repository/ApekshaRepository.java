package com.gsr.janasanth.repository;

import com.gsr.janasanth.domain.Apeksha;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Apeksha entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ApekshaRepository extends JpaRepository<Apeksha,Long> {
    
}
