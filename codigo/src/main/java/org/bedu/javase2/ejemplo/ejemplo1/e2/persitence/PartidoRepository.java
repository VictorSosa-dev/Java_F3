package org.bedu.javase2.ejemplo.ejemplo1.e2.persitence;

import org.bedu.javase2.ejemplo.ejemplo1.e2.model.Partido;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PartidoRepository extends CrudRepository<Partido, Long> {

    Iterable<Partido> findAllByEquipo1NombreAndEquipo2Nombre(String nombreEquipo1, String nombreEquipo2);
}
