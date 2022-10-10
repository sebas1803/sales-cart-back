package com.certicom.codechallenge.salescartback.products.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateProductResource {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    private Double price;
}
