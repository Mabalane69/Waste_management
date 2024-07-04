package org.example.waste.repository;

import org.example.waste.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}

