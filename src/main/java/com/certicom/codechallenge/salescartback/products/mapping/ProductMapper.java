package com.certicom.codechallenge.salescartback.products.mapping;

import com.certicom.codechallenge.salescartback.products.model.Product;
import com.certicom.codechallenge.salescartback.products.resource.CreateProductResource;
import com.certicom.codechallenge.salescartback.products.resource.ProductResource;
import com.certicom.codechallenge.salescartback.products.resource.UpdateProductResource;
import com.certicom.codechallenge.salescartback.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public ProductResource toResource(Product model) {
        return mapper.map(model, ProductResource.class);
    }

    public List<ProductResource> toResource(List<Product> model) {
        return mapper.mapList(model, ProductResource.class);
    }

    public Product toModel(CreateProductResource resource) {
        return mapper.map(resource, Product.class);
    }

    public Product toModel(UpdateProductResource resource) {
        return mapper.map(resource, Product.class);
    }
}
