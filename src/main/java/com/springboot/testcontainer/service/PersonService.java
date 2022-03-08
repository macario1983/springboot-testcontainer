package com.springboot.testcontainer.service;

import com.springboot.testcontainer.dto.PersonDTO;
import com.springboot.testcontainer.exception.PersonNotFoundException;
import com.springboot.testcontainer.mapper.PersonMapper;
import com.springboot.testcontainer.model.Person;
import com.springboot.testcontainer.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public Person findById(Long id) {
        return repository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Person insert(PersonDTO personDTO) {
        Person person = mapper.toModel(personDTO);
        return repository.save(person);
    }

    @Transactional
    public Person update(Long id, PersonDTO personDTO) {
        Person person = mapper.toModel(personDTO);
        return repository.save(person);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
