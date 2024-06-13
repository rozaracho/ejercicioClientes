package com.rozaracho.clientes.controller;

import com.rozaracho.clientes.Cliente;
import com.rozaracho.clientes.service.ClienteService;
import com.rozaracho.clientes.util.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/csv/upload")
    public ResponseEntity< ? > uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (CsvUtil.hasCsvFormat(file)) {
            try {
                clienteService.save(file);
                message = "El archivo se subió con éxito: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception e) {
                message = "El archivo no pudo ser subido con éxito: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }
        message = "Por favor, subir el archivo";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @GetMapping("/clientes")
    public ResponseEntity < ? > getClientes() {
        Map< String, Object > respCliente = new LinkedHashMap< String, Object >();
        List<Cliente> studList = clienteService.findAll();
        if (!studList.isEmpty()) {
            respCliente.put("status", 1);
            respCliente.put("data", studList);
            return new ResponseEntity < > (respCliente, HttpStatus.OK);
        } else {
            respCliente.clear();
            respCliente.put("status", 0);
            respCliente.put("message", "No fueron encontrados los datos de los clientes");
            return new ResponseEntity < > (respCliente, HttpStatus.NOT_FOUND);
        }
    }
}