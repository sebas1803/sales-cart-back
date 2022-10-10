package com.certicom.codechallenge.salescartback.sales.mapping;

import com.certicom.codechallenge.salescartback.sales.model.Sale;
import com.certicom.codechallenge.salescartback.sales.resource.CreateSaleResource;
import com.certicom.codechallenge.salescartback.sales.resource.SaleResource;
import com.certicom.codechallenge.salescartback.sales.resource.UpdateSaleResource;
import com.certicom.codechallenge.salescartback.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SalesMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public SaleResource toResource(Sale model) {
        return mapper.map(model, SaleResource.class);
    }

    public List<SaleResource> toResource(List<Sale> model) {
        return mapper.mapList(model, SaleResource.class);
    }

    public Sale toModel(CreateSaleResource resource) {
        return mapper.map(resource, Sale.class);
    }

    public Sale toModel(UpdateSaleResource resource) {
        return mapper.map(resource, Sale.class);
    }
}
