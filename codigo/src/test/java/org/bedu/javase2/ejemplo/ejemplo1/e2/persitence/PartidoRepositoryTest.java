package org.bedu.javase2.ejemplo.ejemplo1.e2.persitence;


import org.bedu.javase2.ejemplo.ejemplo1.e2.model.Equipo;
import org.bedu.javase2.ejemplo.ejemplo1.e2.model.Partido;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.javase2.ejemplo.ejemplo1")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PartidoRepositoryTest {

    //Practicar las pruebas unitarias, para buscar un partido por su nombre en la tabla de Equipos.
    //Para esto, se debe crear un método en el repositorio de Partido que reciba el nombre del equipo y regrese
    //un iterable de partidos.
    @Autowired
    private PartidoRepository partidoRepository;
    @Autowired
    private EquipoRepository equipoRepository;

    Equipo equipo1;
    Equipo equipo2;

    @BeforeAll
    void cleanDatabase(){
        partidoRepository.deleteAll();
        equipoRepository.deleteAll();

        equipo1 = new Equipo();
        equipo1.setNombre("Equipo 1");
        equipoRepository.save(equipo1);

        equipo2 = new Equipo();
        equipo2.setNombre("Equipo 2");
        equipoRepository.save(equipo2);
    }

    @Test
    @DisplayName("Puede buscar por nombre de equipo")
    void canFindAllByEquipo1NombreAndEquipo2Nombre(){
        Partido partido = new Partido();

        partido.setEquipo1(equipo1);
        partido.setEquipo2(equipo2);
        partido.setMarcadorEquipo1(1);
        partido.setMarcadorEquipo2(2);
        partidoRepository.save(partido);

        Iterable<Partido> listaPartidos = partidoRepository.findAllByEquipo1NombreAndEquipo2Nombre(equipo1.getNombre(), equipo2.getNombre());

    }

}
