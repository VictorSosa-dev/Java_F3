package org.bedu.javase2.ejemplo.ejemplo1.e2.persitence;

import org.bedu.javase2.ejemplo.ejemplo1.e2.model.Equipo;
import org.springframework.data.repository.CrudRepository;

public interface EquipoRepository extends CrudRepository<Equipo, Long> {
    Iterable<Equipo> findAllByNombre(String nombre);
}
