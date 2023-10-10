package org.bedu.javase2.ejemplo.ejemplo1.e2.controller;

import org.bedu.javase2.ejemplo.ejemplo1.e2.model.Equipo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @PostMapping
    public ResponseEntity<Void> crearEquipo(@RequestBody Equipo equipo){
        System.out.println("Equipo: " + equipo);
        return ResponseEntity.created(URI.create("1")).build();
    }

    @GetMapping("/hola")
    public String HolaMundo(){
        return "Hola Mundo";
    }

}
