package com.certicom.codechallenge.salescartback.products.controller;

import com.certicom.codechallenge.salescartback.products.mapping.ProductMapper;
import com.certicom.codechallenge.salescartback.products.model.Product;
import com.certicom.codechallenge.salescartback.products.resource.CreateProductResource;
import com.certicom.codechallenge.salescartback.products.resource.ProductResource;
import com.certicom.codechallenge.salescartback.products.resource.UpdateProductResource;
import com.certicom.codechallenge.salescartback.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product")
@RestController
@RequestMapping(value = "api/v1/products", produces = {"application/json"})
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Operation(summary = "Get all products")
    @GetMapping()
    public List<ProductResource> getAllProducts() {
        return productMapper.toResource(productService.getAllProducts());
    }

    @Operation(summary = "Get product by id")
    @GetMapping("{id}")
    public ProductResource getProductById(@PathVariable("id") Long id) {
        return productMapper.toResource(productService.findProductById(id));
    }

    @Operation(summary = "Create a new product")
    @PostMapping()
    public ProductResource addProduct(@RequestBody CreateProductResource resource) {
        return productMapper.toResource(productService.createProduct(productMapper.toModel(resource)));
    }

    @Operation(summary = "Update product by id")
    @PutMapping("{id}")
    public ProductResource updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductResource resource) {
        return productMapper.toResource(productService.updateProduct(id, productMapper.toModel(resource)));
    }

    @Operation(summary = "Delete product by id")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
}
