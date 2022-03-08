package com.springboot.testcontainer.service;

import com.springboot.testcontainer.dto.SubjectDTO;
import com.springboot.testcontainer.exception.SubjectNotFoundException;
import com.springboot.testcontainer.mapper.SubjectMapper;
import com.springboot.testcontainer.model.Subject;
import com.springboot.testcontainer.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SubjectService {

    private final SubjectRepository repository;
    private final SubjectMapper subjectMapper;

    public Subject findById(final Long id) {
        return repository.findById(id).orElseThrow(SubjectNotFoundException::new);
    }

    public List<Subject> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Subject insert(SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.toModel(subjectDTO);
        return repository.save(subject);
    }

    @Transactional
    public Subject update(final Long id, SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.toModel(subjectDTO);
        return repository.save(subject);
    }

    @Transactional
    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
