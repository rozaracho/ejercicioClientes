package com.rozaracho.clientes.service;

import com.rozaracho.clientes.Cliente;
import com.rozaracho.clientes.Credito;
import com.rozaracho.clientes.RegistroCredito;
import com.rozaracho.clientes.repository.ClienteRepository;
import com.rozaracho.clientes.repository.RegistroCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistroCreditoServiceImpl implements RegistroCreditoService{
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    RegistroCreditoRepository creditoRepository;

    @Override
    public void save(Credito credito) {

        try {
            Cliente origen = clienteRepository.getReferenceById(credito.idOrigen);
            Cliente destino = clienteRepository.getReferenceById(credito.idDestino);

            Integer creditosOrigenActual = origen.getCreditos() - credito.creditos;
            destino.setCreditos(destino.getCreditos() + credito.creditos);
            origen.setCreditos(creditosOrigenActual);
            clienteRepository.save(origen);
            clienteRepository.save(destino);
            creditoRepository.save(new RegistroCredito(credito.creditos));

        } catch (Exception ex) {
            throw new RuntimeException("No se pudo guardar los datos del credito: " + ex.getMessage());
        }


    }
    @Override
    public List <RegistroCredito> findAll() {
        return creditoRepository.findAll();
    }
}