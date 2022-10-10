package com.certicom.codechallenge.salescartback.sales.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("salesMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public SalesMapper salesMapper() {
        return new SalesMapper();
    }
}
