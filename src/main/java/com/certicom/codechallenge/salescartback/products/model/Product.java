package com.certicom.codechallenge.salescartback.products.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
@With
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    private Double price;
}
