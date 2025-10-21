import data.CsvDataReader;
import service.FiltradoService;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        FiltradoService filtradoService = new FiltradoService();
        filtradoService.filtrarPorGenero("Thriller");
        filtradoService.filtrarPorDirector("Robert Zemeckis");
    }
}
