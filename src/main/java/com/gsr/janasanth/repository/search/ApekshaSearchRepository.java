package com.gsr.janasanth.repository.search;

import com.gsr.janasanth.domain.Apeksha;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Apeksha entity.
 */
public interface ApekshaSearchRepository extends ElasticsearchRepository<Apeksha, Long> {
}
