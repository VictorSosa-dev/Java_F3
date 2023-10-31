package com.example.demo.serivice;

import com.example.demo.models.Casa;
import org.springframework.stereotype.Service;


public interface CasaSerivice {

    void guardar(Casa casa);

    Casa buscar(Long id);
}
