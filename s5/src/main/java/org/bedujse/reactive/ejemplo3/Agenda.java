package org.bedujse.reactive.ejemplo3;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Agenda {
    private final String nombreCompleto;
    private final String telefono;
}
