package com.certicom.codechallenge.salescartback.sales.resource;

import lombok.Data;
import java.util.Date;

@Data
public class UpdateSaleResource {
    private Long clientId;
    private Date date;
}
