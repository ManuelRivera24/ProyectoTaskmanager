package org.example.service;

import org.example.exception.DatosInvalidosException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidacionServiceTest {
    ValidacionService vs;

    @BeforeEach
    void setUp() {
        vs = new ValidacionService();
    }

    @Test
    void testValidarId_incorrecto_null() {
        assertThrows(DatosInvalidosException.class,
                () -> vs.validarId(null));
    }

    @Test
    void testValidarId_incorrecto_negativo() {
        assertThrows(DatosInvalidosException.class,
                () -> vs.validarId(-1));
    }

    @Test
    void testValidarId_correcto() {
        assertDoesNotThrow(() -> vs.validarId(1));
    }

    @Test
    void testValidarNombreTarea_incorrecto_null() {
        assertThrows(DatosInvalidosException.class,
                () -> vs.validarNombreTarea(null));
    }

    @Test
    void testValidarNombreTarea_incorrecto_vacio() {
        assertThrows(DatosInvalidosException.class,
                () -> vs.validarNombreTarea(""));
    }

    @Test
    void testValidarNombreTarea_correcto() {
        assertDoesNotThrow(() -> vs.validarNombreTarea("Tarea válida"));
    }
}
