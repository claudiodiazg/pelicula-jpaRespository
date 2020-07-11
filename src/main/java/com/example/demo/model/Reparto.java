package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reparto {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="re_id")
    private Integer id;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "pel_id")
    @JsonIgnore
    private Pelicula pelicula;


}