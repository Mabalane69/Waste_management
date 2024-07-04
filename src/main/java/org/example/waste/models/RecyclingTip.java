package org.example.waste.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tip is mandatory")
    private String tip;

    public void setId(Long id) {
        this.id=id;
    }
}

