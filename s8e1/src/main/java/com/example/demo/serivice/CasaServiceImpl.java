package com.example.demo.serivice;

import com.example.demo.models.Casa;
import com.example.demo.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CasaServiceImpl implements CasaSerivice{


    private final CasaRepository casaRepository;

    @Autowired
    public CasaServiceImpl(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    @Override
    public void guardar(Casa casa) {
        if (casa.getJefeDeFamilia() == null)
            throw new RuntimeException("Se debe tener un padre de familia");

        casa.setJefeDeFamilia(casa.getJefeDeFamilia().toUpperCase());

        casa.setOtros(casa.getOtros().stream().map(nombre ->
                nombre.toUpperCase()).collect(Collectors.toList()));

        casaRepository.save(casa);
    }

    @Override
    public Casa buscar(Long id) {
        return casaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No se encontro la casa"));
    }
}
