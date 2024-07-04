package org.example.waste.Controllers;

import org.example.waste.models.DisposalGuideline;
import org.example.waste.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineRepository repository;

    @GetMapping
    public List<DisposalGuideline> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getById(@PathVariable Long id) {
        Optional<DisposalGuideline> disposalGuideline = repository.findById(id);
        if (disposalGuideline.isPresent()) {
            return new ResponseEntity<>(disposalGuideline.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> create(@Valid @RequestBody DisposalGuideline disposalGuideline) {
        return new ResponseEntity<>(repository.save(disposalGuideline), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> update(@PathVariable Long id, @Valid @RequestBody DisposalGuideline disposalGuideline) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        disposalGuideline.setId(id);
        return new ResponseEntity<>(repository.save(disposalGuideline), HttpStatus.OK);
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

