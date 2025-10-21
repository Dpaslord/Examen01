package service;

import data.CsvDataReader;
import models.Pelicula;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class FiltradoService implements ServicioFiltradoPeliculas {
    @Override
    public void filtrarPorGenero(String genero) {
        var csv = new CsvDataReader();
        List<Pelicula> peliculas;
        peliculas = csv.findAllPeliculas(new File("peliculas.csv"));
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(genero))) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(genero);
                if (Objects.equals(pelicula.getGenero().trim(), genero)) {
                    System.out.println(pelicula);
                    bw.write(pelicula.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void filtrarPorDirector(String director) {
        var csv = new CsvDataReader();
        List<Pelicula> peliculas;
        peliculas = csv.findAllPeliculas(new File("peliculas.csv"));
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(director))) {
            for (Pelicula pelicula : peliculas) {
                if (pelicula.getDirector().equalsIgnoreCase(director)) {
                    bw.write(pelicula.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
