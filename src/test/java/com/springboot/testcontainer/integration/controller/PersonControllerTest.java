package com.springboot.testcontainer.integration.controller;

import br.com.six2six.fixturefactory.Fixture;
import com.springboot.testcontainer.dto.PersonDTO;
import com.springboot.testcontainer.model.Person;
import com.springboot.testcontainer.service.PersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

class PersonControllerTest extends AbstractControllerTest {

    @Autowired
    private PersonService service;

    @Test
    public void person_InsertAndReturn201() throws Exception {

        PersonDTO personDTO = Fixture.from(PersonDTO.class).gimme("valid");

        mockMvc.perform(MockMvcRequestBuilders.post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void person_FindByIdAndReturn200() throws Exception {

        PersonDTO personDTO = Fixture.from(PersonDTO.class).gimme("valid");

        Person person = service.insert(personDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/persons/" + person.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(person.getId()), Long.class))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(person.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age", Matchers.is(person.getAge())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects", Matchers.hasSize(person.getSubjects().size())));
    }

    @Test
    public void person_FindByAllAndReturn200() throws Exception {

        List<PersonDTO> personsDTO = Fixture.from(PersonDTO.class).gimme(3, "valid");

        personsDTO.forEach(personDTO -> service.insert(personDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/persons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }
}