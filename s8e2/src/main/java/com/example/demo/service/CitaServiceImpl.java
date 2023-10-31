package com.example.demo.service;

import com.example.demo.model.Cita;
import com.example.demo.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaServiceImpl implements CitaService{

    private final CitaRepository citaRepository;

    @Autowired
    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public void guardarCita(Cita cita) {
        if(citaRepository.findAllByContenido(cita.getContenido()).size() > 0){
            throw new RuntimeException("La cita ya fue registrada");
        }

        citaRepository.save(cita);
    }

    @Override
    public Cita buscarCita(Long id) {
        return citaRepository.findById(id).get();
    }
}
