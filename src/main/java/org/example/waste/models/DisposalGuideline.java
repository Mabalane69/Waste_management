package org.example.waste.models;

import jakarta.persistence.GenerationType;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Category ID is mandatory")
    private Long categoryId;

    @NotBlank(message = "Guideline is mandatory")
    private String guideline;

    public void setId(Long id) {
        this.id=id;
    }
}

