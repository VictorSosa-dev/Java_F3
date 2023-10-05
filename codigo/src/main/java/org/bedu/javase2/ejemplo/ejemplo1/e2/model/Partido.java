package org.bedu.javase2.ejemplo.ejemplo1.e2.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "partidos")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marcador_equipo_1")
    private int marcadorEquipo1;

    @Column(name = "marcador_equipo_2")
    private int marcadorEquipo2;

    @ManyToOne
    @JoinColumn(name = "equipos1_fk", referencedColumnName = "id")
    private Equipo equipo1;

    @ManyToOne
    @JoinColumn(name = "equipos2_fk", referencedColumnName = "id")
    private Equipo equipo2;

    public Partido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMarcadorEquipo1() {
        return marcadorEquipo1;
    }

    public void setMarcadorEquipo1(int marcadorEquipo1) {
        this.marcadorEquipo1 = marcadorEquipo1;
    }

    public int getMarcadorEquipo2() {
        return marcadorEquipo2;
    }

    public void setMarcadorEquipo2(int marcadorEquipo2) {
        this.marcadorEquipo2 = marcadorEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return marcadorEquipo1 == partido.marcadorEquipo1 && marcadorEquipo2 == partido.marcadorEquipo2 && Objects.equals(id, partido.id) && Objects.equals(equipo1, partido.equipo1) && Objects.equals(equipo2, partido.equipo2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marcadorEquipo1, marcadorEquipo2, equipo1, equipo2);
    }
}
