package com.rozaracho.clientes.util;

import com.rozaracho.clientes.Cliente;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
    public static String TYPE = "text/csv";
    public static boolean hasCsvFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<Cliente> csvClientesToList(InputStream is) {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(bReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Cliente> clientes = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(csvRecord.get("ID")));
                cliente.setNombre(csvRecord.get("Nombre"));
                cliente.setEmail(csvRecord.get("Email"));
                cliente.setCreditos(Integer.valueOf(csvRecord.get("Creditos")));
                clientes.add(cliente);
            }
            return clientes;
        } catch (IOException e) {
            throw new RuntimeException("CSV falló al parsearse: " + e.getMessage());
        }
    }
}
