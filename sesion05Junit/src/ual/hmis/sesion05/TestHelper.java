package ual.hmis.sesion05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestHelper {
    public static void escribirArchivo(String rutaArchivo, List<String> palabras) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String palabra : palabras) {
                writer.write(palabra);
                writer.newLine();
            }
        }
    }
}
