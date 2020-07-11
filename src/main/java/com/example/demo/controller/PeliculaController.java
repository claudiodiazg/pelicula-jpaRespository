package com.example.demo.controller;

import com.example.demo.dto.PeliculaDTO;
import com.example.demo.model.Pelicula;
import com.example.demo.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/movies")
@RestController
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("")
    private List<Pelicula> getAllMovies() {
        return peliculaService.getAllMovies();
    }

    @GetMapping("/{id}")
    private Pelicula getMovie(@PathVariable("id") int id) {
        return peliculaService.getMovieById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteMovie(@PathVariable("id") int id) {
        peliculaService.delete(id);
    }

    @PostMapping("")
    private int saveMovie(@RequestBody PeliculaDTO peliculaDTO) {
        return peliculaService.save(peliculaDTO);
    }

    @PutMapping("/{id}")
    private void updateMovie(@Valid @PathVariable(value = "id", required = true) int idPelicula, @RequestBody PeliculaDTO peliculaDTO) {
        peliculaService.update(peliculaDTO, idPelicula);
    }
}