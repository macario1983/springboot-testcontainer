package com.springboot.testcontainer.integration.controller;

import br.com.six2six.fixturefactory.Fixture;
import com.springboot.testcontainer.dto.SubjectDTO;
import com.springboot.testcontainer.model.Subject;
import com.springboot.testcontainer.service.SubjectService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

class SubjectControllerTest extends AbstractControllerTest {

    @Autowired
    private SubjectService service;

    @Test
    public void subject_InsertAndReturn201() throws Exception {

        SubjectDTO subjectDTO = Fixture.from(SubjectDTO.class).gimme("valid");

        mockMvc.perform(MockMvcRequestBuilders.post("/subjects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(subjectDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void subject_FindByIdAndReturn200() throws Exception {

        SubjectDTO subjectDTO = Fixture.from(SubjectDTO.class).gimme("valid");

        Subject subject = service.insert(subjectDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/subjects/" + subject.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(subject.getId()), Long.class))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(subject.getName())));
    }

    @Test
    public void subject_FindByAllAndReturn200() throws Exception {

        List<SubjectDTO> subjectsDTO = Fixture.from(SubjectDTO.class).gimme(3, "valid");

        subjectsDTO.forEach(personDTO -> service.insert(personDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/subjects")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }
}