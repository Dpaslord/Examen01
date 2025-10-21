package models;

import lombok.Data;

@Data
public class Pelicula {
    private int id;
    private String titulo;
    private int año;
    private String director;
    private String genero;

    @Override
    public String toString() {
        return  id + "," + titulo + "," + año + "," + director + "," + genero + System.lineSeparator();
    }
}
