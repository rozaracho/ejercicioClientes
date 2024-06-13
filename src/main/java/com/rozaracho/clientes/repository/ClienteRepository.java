package com.rozaracho.clientes.repository;

import com.rozaracho.clientes.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {

}
