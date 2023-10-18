package com.bakend.javase2.repositorytest;

import com.bakend.javase2.model.Curso;
import com.bakend.javase2.model.Estudiante;
import com.bakend.javase2.model.Materia;
import com.bakend.javase2.repository.CursoRepository;
import com.bakend.javase2.repository.MateriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CursoRepositoryTest {

    private CursoRepository cursoRepository;
    private MateriaRepository materiaRepository;

    @Autowired
    public CursoRepositoryTest(CursoRepository cursoRepository, MateriaRepository materiaRepository) {
        this.cursoRepository = cursoRepository;
        this.materiaRepository = materiaRepository;
    }

    private Curso curso;
    private Materia materia;

    @BeforeEach
    void serUp(){
        materia = new Materia();
        materia.setNombre("Matematicas");
        materiaRepository.save(materia);
    }

    @Test
    @DisplayName("Test guardar curso")
    void saveCursoTest() {
        //given
        curso = new Curso();
        curso.setCiclo("2020-2021");
        curso.setMateria(materia);
        Curso cursoDb = cursoRepository.save(curso);
        //when
        assertThat(cursoDb).isNotNull();
        assertThat(cursoDb.getId()).isGreaterThan(0);
        assertThat(cursoDb.getMateria()).isNotNull();
        //then
    }

    @Test
    @DisplayName("Test agregar calificacion")
    void saveCalificacion(){
        //given
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto("Juan");
        curso = new Curso();
        curso.setCiclo("2020-2021");
        curso.setMateria(materia);
        curso.setCalificaciones(Map.of(estudiante, 10));
        Curso cursoDb = cursoRepository.save(curso);
        //when

        //then
        assertThat(cursoDb).isNotNull();
        assertThat(cursoDb.getId()).isGreaterThan(0);
        assertThat(cursoDb.getMateria()).isNotNull();
        assertThat(cursoDb.getCalificaciones()).isNotEmpty();
    }

}
