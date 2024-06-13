package com.rozaracho.clientes.service;

import com.rozaracho.clientes.Cliente;
import com.rozaracho.clientes.repository.ClienteRepository;
import com.rozaracho.clientes.util.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public void save(MultipartFile file) {
        try {
            List<Cliente> clientes = CsvUtil.csvClientesToList(file.getInputStream());
            clienteRepository.saveAll(clientes);
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo guardar los datos del cliente: " + ex.getMessage());
        }
    }
    @Override
    public List <Cliente> findAll() {
        return clienteRepository.findAll();
    }
}