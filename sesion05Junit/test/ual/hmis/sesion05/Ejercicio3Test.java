package ual.hmis.sesion05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Ejercicio3Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/ual/hmis/sesion05/test_data.csv")
    @CsvSource("password,expected",
            "123,password demasiado corto",
            "12345,********",
            "1234567890,************",
            "12345678901234567890123456789012345678901,password demasiado largo")
    public void testMaskPassword(String password, String expected) {
        Ejercicio3 ejercicio = new Ejercicio3();
        String result = ejercicio.maskPassword(password);
        assertEquals(expected, result);
    }

    // Método para cargar datos desde un archivo CSV
    public static List<String[]> readTestDataFromCSV(String fileName) throws IOException {
        List<String[]> testData = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                testData.add(data);
            }
        }
        return testData;
    }
}
