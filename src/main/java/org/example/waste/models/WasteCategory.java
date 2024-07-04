package org.example.waste.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

   public void setId(Long id){
       this.id=id;
   }
}

