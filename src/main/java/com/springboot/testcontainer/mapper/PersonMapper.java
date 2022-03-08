package com.springboot.testcontainer.mapper;


import com.springboot.testcontainer.dto.PersonDTO;
import com.springboot.testcontainer.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO toDTO(Person person);

    Person toModel(PersonDTO personDTO);

}
