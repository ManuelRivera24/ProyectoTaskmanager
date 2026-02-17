package org.example.service;

import org.example.exception.DatosInvalidosException;
import org.example.exception.OperacionInvalidaException;
import org.example.exception.TareaNoEncontradaException;
import org.example.model.Tarea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TareaService {
    private static final Logger log = LoggerFactory.getLogger(TareaService.class);
    private final List<Tarea> tareas = new ArrayList<>();
    private final ValidacionService validacionService = new ValidacionService();

    public void validaciones(int id, String nombre, String descripcion) {
        validacionService.validarId(id);
        validacionService.validarNombreTarea(nombre);
        validarIdUnico(id);
    }

    public List<Tarea> listarTareas() {
        return tareas;
    }

    public void agregarTarea(int id, String nombre, String descripcion) {
        validaciones(id, nombre, descripcion);
//        log.info("Tarea registrada {} {} {}", id, nombre, descripcion);
        Tarea tarea = new Tarea(id, nombre, descripcion);
        tareas.add(tarea);
        log.info("Tarea registrada con exito");
    }

    private void validarIdUnico(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                throw new DatosInvalidosException("Ya existe una tarea con ese ID.");
            }
        }
    }

    public void completarTarea(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setEstado(true);
                log.info("Tarea {} marcada como completada", id);
                return;
            }
        }
        throw new OperacionInvalidaException("No existe una tarea con el ID: " + id);
    }

    public Tarea buscarPorId(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                return tarea;
            }
        }
        throw new TareaNoEncontradaException("No existe una tarea con el ID: " + id);
    }

    public void eliminarTarea(int id) {
        Tarea tarea = buscarPorId(id);
        tareas.remove(tarea);
//        log.info("Tarea {} eliminada correctamente", id);
    }
}
