package org.example.service;

import org.example.model.Tarea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class TareaService {
    private static final Logger log = LoggerFactory.getLogger(ValidacionService.class);
    private Tarea tarea;
    private final ValidacionService validacionService = new ValidacionService();

    public void validaciones(int id, String nombre, String descripcion) {
        validacionService.validarId(id);
        validacionService.validarNombreTarea(nombre);
    }

    public void agregarTarea(int id, String nombre, String descripcion) {
        validaciones(id, nombre, descripcion);
        log.info("Tarea registrada {} {} {}", tarea.getId(), tarea.getNombre(), tarea.getDescripcion());
        this.tarea = new Tarea(id, nombre, descripcion);
        log.info("Tarea registrada con exito");
    }
}
