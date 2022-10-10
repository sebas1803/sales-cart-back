package com.certicom.codechallenge.salescartback.sales.resource;

import lombok.Data;

@Data
public class SaleDetailResource {
    private Long id;
    private Long saleId;
    private Long productId;
    private Long quantity;
}
