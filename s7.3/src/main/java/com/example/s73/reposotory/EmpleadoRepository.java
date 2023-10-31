package com.example.s73.reposotory;

import com.example.s73.entity.Empleado;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmpleadoRepository {

    static Map<String, Empleado> empleadoMap;

    static {
        empleadoMap = new HashMap<>();
        empleadoMap.put("1", new Empleado("1", "Juan"));
        empleadoMap.put("2", new Empleado("2", "Pedro"));
        empleadoMap.put("3", new Empleado("3", "Maria"));
        empleadoMap.put("4", new Empleado("4", "Yuli"));
        empleadoMap.put("5", new Empleado("5", "Luis"));
        empleadoMap.put("6", new Empleado("6", "Carlos"));
        empleadoMap.put("7", new Empleado("7", "Jorge"));
        empleadoMap.put("8", new Empleado("8", "Javier"));
        empleadoMap.put("9", new Empleado("9", "Jhon"));
        empleadoMap.put("10", new Empleado("10", "Jhonatan"));
    }

    public Mono<Empleado> findEmpleadoById(String id) {
        return Mono.just(empleadoMap.get(id));
    }

    public Flux<Empleado> findAllEmpleados() {
        return Flux.fromIterable(empleadoMap.values());
    }

    public Mono<Empleado> updateEmpleado(Empleado employee) {
        Empleado existeEmpleado = empleadoMap.get(employee.getId());
        if (existeEmpleado != null) {
            existeEmpleado.setNombre(employee.getNombre());
        }
        return Mono.just(existeEmpleado);
    }

}
