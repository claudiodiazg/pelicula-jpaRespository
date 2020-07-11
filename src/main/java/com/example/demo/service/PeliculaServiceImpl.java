package com.example.demo.service;

import com.example.demo.dto.PeliculaDTO;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Reparto;
import com.example.demo.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Pelicula> getAllMovies() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        return (!peliculas.isEmpty())?peliculas:null;
    }

    public Pelicula getMovieById(int id) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(id);
        if (pelicula.isPresent())
            return pelicula.get();
        return null;
    }

    public int save(PeliculaDTO peliculaDTO) {

        List<Reparto> repartos;

        repartos = peliculaDTO.getRepartos().stream().map(
                reparto ->
                    Reparto.builder().name(reparto.getName()).build()

        ).collect(Collectors.toList());


        Pelicula pelicula = Pelicula.builder()
                .name(peliculaDTO.getName())
                .repartos(repartos)
                .build();

        for (Reparto rep: repartos ){

            rep.setPelicula(pelicula);
        }

       return peliculaRepository.save(pelicula).getId();
    }

    public void delete(int id) {
        peliculaRepository.deleteById(id);
    }

    public void update (PeliculaDTO peliculaDTO, Integer idPelicula){
        if (idPelicula!=null){
            Optional<Pelicula> pelicula = peliculaRepository.findById(idPelicula);
            if (pelicula.isPresent()) {
                List<Reparto> repartos = peliculaDTO.getRepartos().stream().map(repartoDTO ->
                        new Reparto(repartoDTO.getId(), repartoDTO.getName(), pelicula.get())
                ).collect(Collectors.toList());

                pelicula.get().setName(peliculaDTO.getName());
                pelicula.get().setRepartos(repartos);
                peliculaRepository.save(pelicula.get());
            }
        }
    }
}