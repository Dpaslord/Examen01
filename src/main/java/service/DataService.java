package service;

import models.Pelicula;

import java.io.File;
import java.util.List;

public interface DataService {
    public List<Pelicula> findAllPeliculas(File archivo);
}
