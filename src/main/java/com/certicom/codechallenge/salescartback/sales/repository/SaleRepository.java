package com.certicom.codechallenge.salescartback.sales.repository;

import com.certicom.codechallenge.salescartback.sales.model.Sale;
import com.certicom.codechallenge.salescartback.sales.resource.SaleDetailTotalResource;
import com.certicom.codechallenge.salescartback.sales.resource.SaleTotalResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT sd.sale_id, c.firstname, c.lastname, s.date, sd.quantity*p.price as subtotal " +
            "FROM clients c JOIN sales s ON c.id = s.client_id JOIN sales_detail sd ON s.id = sd.sale_id JOIN products p ON sd.product_id = p.id", nativeQuery = true)
    List<SaleTotalResource> findSalesWithTotal();

    @Query(value = "SELECT sd.sale_id, p.name, p.price, sd.quantity, sd.quantity*p.price as subtotal " +
            "FROM products p JOIN sales_detail sd ON p.id = sd.product_id", nativeQuery = true)
    List<SaleDetailTotalResource> findSalesDetailTotal();

    @Query(value = "SELECT * FROM sales WHERE date LIKE %?2% ", nativeQuery = true)
    List<Sale> findSalesByDate(@Param("date") Date date);

    @Modifying
    @Query(value = "INSERT INTO sales_detail(quantity, product_id, sale_id) VALUES (:quantity, :productId, :saleId)", nativeQuery = true)
    @Transactional
    void registerProductToSale(@Param("quantity") Long quantity, @Param("productId") Long productId, @Param("saleId") Long saleId);
}
