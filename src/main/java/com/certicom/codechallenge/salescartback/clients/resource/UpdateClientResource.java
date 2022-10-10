package com.certicom.codechallenge.salescartback.clients.resource;

import lombok.Data;

@Data
public class UpdateClientResource {
    private String firstname;
    private String lastname;
    private String dni;
    private String phone;
    private String email;
}
