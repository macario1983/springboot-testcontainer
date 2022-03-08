package com.springboot.testcontainer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class Person implements Serializable {

    @Id
    @SequenceGenerator(name = "person_id_seq", sequenceName = "person_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    @EqualsAndHashCode.Include
    private Long id;

    @Size(min = 3, max = 50)
    @NotBlank
    private String name;

    @Positive
    private Integer age;

    @Valid
    @NotEmpty
    @JoinTable(
            name = "person_subject",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Subject> subjects;

}
