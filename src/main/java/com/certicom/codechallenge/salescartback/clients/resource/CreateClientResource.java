package com.certicom.codechallenge.salescartback.clients.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateClientResource {
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String firstname;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String lastname;

    @NotNull
    @NotBlank
    @Size(max = 8)
    private String dni;

    @Size(max = 9)
    private String phone;

    private String email;
}
