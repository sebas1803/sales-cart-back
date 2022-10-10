package com.certicom.codechallenge.salescartback.sales.service;

import com.certicom.codechallenge.salescartback.clients.exception.ClientNotFoundException;
import com.certicom.codechallenge.salescartback.clients.model.Client;
import com.certicom.codechallenge.salescartback.clients.repository.ClientRepository;
import com.certicom.codechallenge.salescartback.products.exception.ProductNotFoundException;
import com.certicom.codechallenge.salescartback.products.repository.ProductRepository;
import com.certicom.codechallenge.salescartback.sales.exception.SaleNotFoundException;
import com.certicom.codechallenge.salescartback.sales.model.Sale;
import com.certicom.codechallenge.salescartback.sales.repository.SaleRepository;
import com.certicom.codechallenge.salescartback.sales.resource.SaleDetailTotalResource;
import com.certicom.codechallenge.salescartback.sales.resource.SaleTotalResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository, ClientRepository clientRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public List<SaleTotalResource> findAllSalesWithTotal() {
        return saleRepository.findSalesWithTotal();
    }

    public List<SaleDetailTotalResource> findAllSalesDetailWithTotal() {
        return saleRepository.findSalesDetailTotal();
    }

    public Sale findSaleById(Long saleId) {
        return saleRepository.findById(saleId)
                .orElseThrow(() -> new SaleNotFoundException("Sale with id" + saleId + "was not found"));
    }

    public List<Sale> findSalesByDate(Date date) {
        return saleRepository.findSalesByDate(date);
    }

    public ResponseEntity<?> addProductToSale(Long quantity, Long productId, Long saleId) {
        if (productRepository.findById(productId).isEmpty())
            throw new ProductNotFoundException("Product with id" + productId + "was not found");
        if (saleRepository.findById(saleId).isEmpty())
            throw new SaleNotFoundException("Sale with id" + saleId + "was not found");

        saleRepository.registerProductToSale(quantity, productId, saleId);
        return ResponseEntity.ok("Product registered to sale");
    }

    public Sale createSale(Long clientId, Sale sale) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("Client not found with Id " + clientId));
        sale.setClient(client);
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long saleId, Sale sale) {
        return saleRepository.findById(saleId).map(request -> saleRepository.save(sale))
                .orElseThrow(() -> new SaleNotFoundException("Sale with id" + saleId + "was not found"));
    }

    public ResponseEntity<?> deleteSale(Long saleId) {
        return saleRepository.findById(saleId).map(sale -> {
            saleRepository.delete(sale);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new SaleNotFoundException("Sale with id" + saleId + "was not found"));
    }
}
