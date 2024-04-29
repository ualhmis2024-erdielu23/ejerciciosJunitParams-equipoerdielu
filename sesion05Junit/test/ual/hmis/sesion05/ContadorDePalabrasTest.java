package ual.hmis.sesion05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContadorDePalabrasTest {

    @ParameterizedTest
    @CsvSource({
            "'input.txt', 'a, a, b, c', 'a, b, c'",
            "'input.txt', 'hola, mundo, mundo, java, hola', 'hola, mundo, java'",
            "'input.txt', '', ''"
    })
    void testObtenerPalabrasEnOrdenAlfabetico(String fileName, String input, String expectedOutput) throws IOException {
        String rutaArchivo = Objects.requireNonNull(getClass().getResource(fileName)).getPath();
        ContadorDePalabras contador = new ContadorDePalabras(rutaArchivo);
        List<String> palabras = Arrays.asList(input.split(", "));
        TestHelper.escribirArchivo(rutaArchivo, palabras);
        List<String> resultado = contador.obtenerPalabrasEnOrdenAlfabetico();
        assertEquals(Arrays.asList(expectedOutput.split(", ")), resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "'input.txt', 'a, a, b, c', 'a:2, b:1, c:1'",
            "'input.txt', 'hola, mundo, mundo, java, hola', 'hola:2, mundo:2, java:1'"
    })
    void testObtenerPalabrasPorNumeroDeOcurrencias(String fileName, String input, String expectedOutput) throws IOException {
        String rutaArchivo = Objects.requireNonNull(getClass().getResource(fileName)).getPath();
        ContadorDePalabras contador = new ContadorDePalabras(rutaArchivo);
        List<String> palabras = Arrays.asList(input.split(", "));
        TestHelper.escribirArchivo(rutaArchivo, palabras);
        List<String> resultado = contador.obtenerPalabrasPorNumeroDeOcurrencias();
        assertEquals(Arrays.asList(expectedOutput.split(", ")), resultado);
    }
}
