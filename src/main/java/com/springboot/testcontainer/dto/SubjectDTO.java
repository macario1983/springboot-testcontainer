package com.springboot.testcontainer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO implements Serializable {

    @JsonIgnore
    private Long id;

    @NotBlank
    private String name;

}
