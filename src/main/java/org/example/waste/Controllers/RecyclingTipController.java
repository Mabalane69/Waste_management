package org.example.waste.Controllers;

import org.example.waste.models.RecyclingTip;
import org.example.waste.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipRepository repository;

    @GetMapping
    public List<RecyclingTip> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getById(@PathVariable Long id) {
        Optional<RecyclingTip> recyclingTip = repository.findById(id);
        if (recyclingTip.isPresent()) {
            return new ResponseEntity<>(recyclingTip.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> create(@Valid @RequestBody RecyclingTip recyclingTip) {
        return new ResponseEntity<>(repository.save(recyclingTip), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> update(@PathVariable Long id, @Valid @RequestBody RecyclingTip recyclingTip) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        recyclingTip.setId(id);
        return new ResponseEntity<>(repository.save(recyclingTip), HttpStatus.OK);
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

