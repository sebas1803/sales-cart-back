package com.certicom.codechallenge.salescartback.sales.resource;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CreateSaleResource {
    @NotNull
    private Date date;
}
