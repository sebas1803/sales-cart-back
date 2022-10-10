package com.certicom.codechallenge.salescartback.sales.resource;

import java.util.Date;

public interface SaleTotalResource{
    Long getSale_id();
    String getFirstname();
    String getLastname();
    Date getDate();
    Double getSubtotal();
}