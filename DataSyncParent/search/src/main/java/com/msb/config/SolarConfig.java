package com.msb.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

/**
 * @author: thirteenmj
 * @date: 2022-07-23 23:33
 */
@Configuration
public class SolarConfig {

    @Autowired
    private SolrClient solrClient;

    @Bean
    public SolrTemplate getSolrTemplate() {
        return new SolrTemplate(solrClient);
    }
}
