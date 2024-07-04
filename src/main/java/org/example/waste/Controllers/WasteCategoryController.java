package org.example.waste.Controllers;

import org.example.waste.models.WasteCategory;
import org.example.waste.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryRepository repository;

    @GetMapping
    public List<WasteCategory> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getById(@PathVariable Long id) {
        Optional<WasteCategory> wasteCategory = repository.findById(id);
        if (wasteCategory.isPresent()) {
            return new ResponseEntity<>(wasteCategory.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<WasteCategory> create(@Valid @RequestBody WasteCategory wasteCategory) {
        return new ResponseEntity<>(repository.save(wasteCategory), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> update(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategory) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wasteCategory.setId(id);
        return new ResponseEntity<>(repository.save(wasteCategory), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
