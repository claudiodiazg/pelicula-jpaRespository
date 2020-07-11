package com.example.demo.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDTO implements Serializable {
    private Integer id;
    private String name;
    private List<RepartoDTO> repartos;
}
