package com.bakend.javase2.repositorytest;

import com.bakend.javase2.model.Estudiante;
import com.bakend.javase2.repository.EstudianteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EstudianteRepositoryTest {

    private EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteRepositoryTest(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    private Estudiante estudiante;

    // given - 'dado': Se espicifica el escenario las precondiciones o configuración
    // when - 'cuando': Las condiciones de las acciones que se van a ejecutar.
    // then - 'entonces': El resultado esperado, las validadciones a realizar.

    @Test
    @DisplayName("Test save estudiante")
    public void testSaveEstudiante() {
        //given
        estudiante = new Estudiante();
        estudiante.setNombreCompleto("Juan Perez");

        //when
        Estudiante estudienteDB = estudianteRepository.save(estudiante);
        //then
        assertThat(estudiante).isNotNull();
        assertThat(estudiante.getId()).isGreaterThan(0);
    }
}
