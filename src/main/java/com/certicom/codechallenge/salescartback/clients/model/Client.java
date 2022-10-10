package com.certicom.codechallenge.salescartback.clients.model;

import com.certicom.codechallenge.salescartback.sales.model.Sale;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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