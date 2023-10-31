package com.example.demo.service;

import com.example.demo.model.Cita;

public interface CitaService {

    void guardarCita(Cita cita);

    Cita buscarCita(Long id);
}
