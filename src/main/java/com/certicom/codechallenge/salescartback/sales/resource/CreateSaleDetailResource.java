package com.certicom.codechallenge.salescartback.sales.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateSaleDetailResource {
    @NotNull
    @NotBlank
    private Long quantity;
}
