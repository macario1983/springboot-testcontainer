package com.springboot.testcontainer.controller;

import com.springboot.testcontainer.dto.SubjectDTO;
import com.springboot.testcontainer.model.Subject;
import com.springboot.testcontainer.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("subjects")
public class SubjectController {

    private final SubjectService service;

    @GetMapping("{id}")
    public ResponseEntity<Subject> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Subject>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Subject> insert(@Valid @RequestBody SubjectDTO subjectDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(subjectDTO));
    }

    @PutMapping
    public ResponseEntity<Subject> update(@PathVariable Long id, @Valid @RequestBody SubjectDTO subjectDTO) {
        return ResponseEntity.ok(service.update(id, subjectDTO));
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
