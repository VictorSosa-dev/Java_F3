package com.example.demo.controller;

import com.example.demo.model.Cita;
import com.example.demo.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cita")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void guardarCita(@RequestBody Cita cita){
        citaService.guardarCita(cita);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Cita buscarCita(@PathVariable Long id){
        return citaService.buscarCita(id);
    }

}
