package com.rozaracho.clientes;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class RegistroCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    Integer cantCreditos;
    @Temporal(TemporalType.DATE)
    Date fechaEnvio;

    public RegistroCredito(Integer cantCreditos) {
        this.cantCreditos = cantCreditos;
        this.fechaEnvio = new Date();
    }

    public RegistroCredito() {
    }
}
