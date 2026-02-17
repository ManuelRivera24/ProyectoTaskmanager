package org.example.service;

import org.example.exception.DatosInvalidosException;
import org.example.exception.OperacionInvalidaException;
import org.example.exception.TareaNoEncontradaException;
import org.example.model.Tarea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TareaServiceTest {

    TareaService tareaService;
    @BeforeEach
    void init() {
        tareaService = new TareaService();
        tareaService.agregarTarea(1, "Tarea1", "descripcion1");
    }

    @Test
    void testAgregarTarea_idDuplicado() {
        assertThrows(DatosInvalidosException.class,
                () -> tareaService.agregarTarea(1, "Misma Tarea", "Duplicada"));
    }

    @Test
    void testCompletarTarea_correcto() {
        tareaService.completarTarea(1);

        Tarea tarea = tareaService.buscarPorId(1);

        assertTrue(tarea.isEstado());
    }

    @Test
    void testCompletarTarea_noExiste() {
        assertThrows(OperacionInvalidaException.class,
                () -> tareaService.completarTarea(99));
    }

    @Test
    void testBuscarPorId_correcto() {
        Tarea tarea = tareaService.buscarPorId(1);

        assertEquals(1, tarea.getId());
        assertEquals("Tarea1", tarea.getNombre());
    }

    @Test
    void testBuscarPorId_noExiste() {
        assertThrows(TareaNoEncontradaException.class,
                () -> tareaService.buscarPorId(99));
    }

    @Test
    void testEliminarTarea_correcto() {
        tareaService.eliminarTarea(1);

        assertThrows(TareaNoEncontradaException.class,
                () -> tareaService.buscarPorId(1));
    }

    @Test
    void testEliminarTarea_noExiste() {
        assertThrows(TareaNoEncontradaException.class,
                () -> tareaService.eliminarTarea(99));
    }
}