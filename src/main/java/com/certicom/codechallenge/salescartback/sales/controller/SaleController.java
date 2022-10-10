package com.certicom.codechallenge.salescartback.sales.controller;

import com.certicom.codechallenge.salescartback.sales.mapping.SalesMapper;
import com.certicom.codechallenge.salescartback.sales.resource.*;
import com.certicom.codechallenge.salescartback.sales.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Tag(name = "Sale")
@RestController
@RequestMapping(value = "api/v1/sales", produces = {"application/json"})
public class SaleController {

    private final SaleService saleService;
    private final SalesMapper salesMapper;

    public SaleController(SaleService saleService, SalesMapper salesMapper) {
        this.saleService = saleService;
        this.salesMapper = salesMapper;
    }

    @Operation(summary = "Get all sales")
    @GetMapping()
    public List<SaleResource> getAllSales() {
        return salesMapper.toResource(saleService.findAllSales());
    }

    @Operation(summary = "Get all sales with calculated total")
    @GetMapping("calculated")
    public List<SaleTotalResource> getAllSalesWithTotal(){
        return saleService.findAllSalesWithTotal();
    }

    @Operation(summary = "Get all sales with detail")
    @GetMapping("detail")
    public List<SaleDetailTotalResource> getAllSalesDetailWithTotal(){
        return saleService.findAllSalesDetailWithTotal();
    }

    @Operation(summary = "Get sale by id")
    @GetMapping("{id}")
    public SaleResource getSaleById(@PathVariable("id") Long id) {
        return salesMapper.toResource(saleService.findSaleById(id));
    }

    @Operation(summary = "Get sales by date")
    @GetMapping("date")
    public List<SaleResource> getSalesByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return salesMapper.toResource(saleService.findSalesByDate(date));
    }

    @Operation(summary = "Create a new sale")
    @PostMapping("client/{clientId}")
    public SaleResource addSale(@PathVariable("clientId") Long clientId, @RequestBody CreateSaleResource resource) {
        return salesMapper.toResource(saleService.createSale(clientId, salesMapper.toModel(resource)));
    }

    @Operation(summary = "Add product to sale")
    @PostMapping("product/{productId}/sale/{saleId}")
    public ResponseEntity<?> addProductToSale(@PathVariable Long productId, @PathVariable Long saleId, @RequestParam Long quantity) {
        return saleService.addProductToSale(quantity, productId, saleId);
    }

    @Operation(summary = "Update sale by id")
    @PutMapping("{id}")
    public SaleResource updateSale(@PathVariable("id") Long id, @RequestBody UpdateSaleResource resource) {
        return salesMapper.toResource(saleService.updateSale(id, salesMapper.toModel(resource)));
    }

    @Operation(summary = "Delete sale by id")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSale(@PathVariable("id") Long id) {
        return saleService.deleteSale(id);
    }
}
