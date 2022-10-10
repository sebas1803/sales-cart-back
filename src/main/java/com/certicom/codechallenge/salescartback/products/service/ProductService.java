package com.certicom.codechallenge.salescartback.products.service;

import com.certicom.codechallenge.salescartback.products.exception.ProductNotFoundException;
import com.certicom.codechallenge.salescartback.products.model.Product;
import com.certicom.codechallenge.salescartback.products.repository.ProductRepository;
import com.certicom.codechallenge.salescartback.sales.exception.SaleNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id" + productId + "was not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product product) {
        return productRepository.findById(productId).map(
                        request -> productRepository.save(
                                request.withName(product.getName())
                                        .withPrice(product.getPrice())))
                .orElseThrow(() -> new ProductNotFoundException("Product with id" + productId + "was not found"));
    }

    public ResponseEntity<?> deleteProduct(Long productId) {
        return productRepository.findById(productId).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new SaleNotFoundException("Product with id" + productId + "was not found"));
    }
}
