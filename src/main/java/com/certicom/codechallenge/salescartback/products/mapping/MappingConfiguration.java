package com.certicom.codechallenge.salescartback.products.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("productMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }
}
