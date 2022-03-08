package com.springboot.testcontainer.mapper;


import com.springboot.testcontainer.dto.SubjectDTO;
import com.springboot.testcontainer.model.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO toDTO(Subject subject);

    Subject toModel(SubjectDTO subjectDTO);

}
