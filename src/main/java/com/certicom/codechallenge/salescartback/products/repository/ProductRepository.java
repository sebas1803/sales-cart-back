package com.certicom.codechallenge.salescartback.products.repository;

import com.certicom.codechallenge.salescartback.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
