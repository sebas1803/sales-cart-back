package com.certicom.codechallenge.salescartback.sales.resource;

public interface SaleDetailTotalResource {
    Long getSale_id();
    String getName();
    Double getPrice();
    Long getQuantity();
    Double getSubtotal();
}