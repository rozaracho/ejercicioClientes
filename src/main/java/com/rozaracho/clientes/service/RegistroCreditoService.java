package com.rozaracho.clientes.service;
import com.rozaracho.clientes.Credito;
import com.rozaracho.clientes.RegistroCredito;

import java.util.List;

public interface RegistroCreditoService {
    void save(Credito credito);
    List<RegistroCredito> findAll();
}
