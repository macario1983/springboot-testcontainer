package com.springboot.testcontainer.controller;

import com.springboot.testcontainer.dto.PersonDTO;
import com.springboot.testcontainer.model.Person;
import com.springboot.testcontainer.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonService service;

    @GetMapping("{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Person> insert(@Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(personDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(service.update(id, personDTO));
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

