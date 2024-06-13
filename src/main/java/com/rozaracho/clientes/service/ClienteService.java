package com.rozaracho.clientes.service;

import com.rozaracho.clientes.Cliente;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClienteService {
    void save(MultipartFile file);
    List<Cliente> findAll();
}
