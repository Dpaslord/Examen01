package data;

import models.Pelicula;
import service.DataService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvDataReader implements DataService {
    @Override
    public List<Pelicula> findAllPeliculas(File archivo) {
        var salida = new ArrayList<Pelicula>();
        try (var br = new BufferedReader(new FileReader(archivo))) {

            var contenido = br.lines();
            contenido.forEach(line -> {
                List<String> lineArray = Arrays.asList(line.split(","));
                var pelicula = new Pelicula();

                pelicula.setId(Integer.parseInt(lineArray.get(0)));
                pelicula.setTitulo(lineArray.get(1));
                pelicula.setAño(Integer.parseInt(lineArray.get(2)));
                pelicula.setDirector(lineArray.get(3));
                pelicula.setGenero(lineArray.get(4));
                salida.add(pelicula);
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }
}
