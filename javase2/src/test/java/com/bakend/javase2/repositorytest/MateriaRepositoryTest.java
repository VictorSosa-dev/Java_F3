package com.bakend.javase2.repositorytest;

import com.bakend.javase2.model.Materia;
import com.bakend.javase2.repository.MateriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class MateriaRepositoryTest {


    private MateriaRepository materiaRepository;

    @Autowired
    public MateriaRepositoryTest(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    private Materia materia;

    @BeforeEach
    void setup() {
        materia = new Materia();
        materia.setNombre("Matematicas");
    }

    // given - 'dado': Se espicifica el escenario las precondiciones o configuración
    // when - 'cuando': Las condiciones de las acciones que se van a ejecutar.
    // then - 'entonces': El resultado esperado, las validadciones a realizar.

    @DisplayName("Test de guardar materia")
    @Test
    void testGuardarMateria(){
        // given
        Materia materia1 = new Materia();
        materia1.setNombre("Matematicas");
        // when

        Materia materiaGuardada = materiaRepository.save(materia1);

        // then - Verifcar la salida
        assertThat(materiaGuardada).isNotNull();
        assertThat(materiaGuardada.getId()).isGreaterThan(0);
    }
}
