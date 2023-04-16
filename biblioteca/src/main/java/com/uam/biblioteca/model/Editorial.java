package com.uam.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Table(name ="EDITORIAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Editorial {
    @Id
    @SequenceGenerator(name = "editorial_seq", sequenceName = "editorial_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editorial_seq")
    private  Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "editorial",cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Libro> detalles;

}
