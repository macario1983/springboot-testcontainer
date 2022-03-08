package com.springboot.testcontainer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO implements Serializable {

    @JsonIgnore
    private Long id;

    @Size(min = 3, max = 50)
    @NotBlank
    private String name;

    @Positive
    private Integer age;

    @Valid
    @NotEmpty
    private List<SubjectDTO> subjects;


}
