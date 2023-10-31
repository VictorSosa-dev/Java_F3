package com.example.demo.controllers;

import com.example.demo.models.Casa;
import com.example.demo.serivice.CasaSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casa")
public class CasaController {

    private final CasaSerivice serivice;

    @Autowired
    public CasaController(CasaSerivice serivice) {
        this.serivice = serivice;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void guardarCasa(@RequestBody Casa casa) {
        serivice.guardar(casa);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Casa getCasa(@PathVariable Long id) {
        return serivice.buscar(id);
    }
}
