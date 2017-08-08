package com.gsr.janasanth.service.mapper;

import com.gsr.janasanth.domain.*;
import com.gsr.janasanth.service.dto.ApekshaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Apeksha and its DTO ApekshaDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ApekshaMapper extends EntityMapper <ApekshaDTO, Apeksha> {
    
    
    default Apeksha fromId(Long id) {
        if (id == null) {
            return null;
        }
        Apeksha apeksha = new Apeksha();
        apeksha.setId(id);
        return apeksha;
    }
}
