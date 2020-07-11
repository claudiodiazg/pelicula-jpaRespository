package com.example.demo.service;

import com.example.demo.dto.PeliculaDTO;
import com.example.demo.model.Pelicula;

import java.util.List;

public interface PeliculaService {
    List<Pelicula> getAllMovies();
    Pelicula getMovieById(int id);
    int save(PeliculaDTO peliculaDTO);
    void delete(int id);
    void update (PeliculaDTO peliculaDTO, Integer idPelicula);
}
