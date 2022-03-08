package com.springboot.testcontainer.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class Subject implements Serializable {

    @Id
    @SequenceGenerator(name = "subject_id_seq", sequenceName = "subject_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_id_seq")
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    private String name;

}
