package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pelicula {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="pel_id")
    private Integer id;
    private String name;


    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="pelicula")
    private List<Reparto> repartos;
}