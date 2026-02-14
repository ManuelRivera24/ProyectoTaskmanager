package org.example.service;

import org.example.exception.DatosInvalidosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidacionService {
    public static final Logger log = LoggerFactory.getLogger(ValidacionService.class);

    public void validarId(Integer id) {
        if (id == null || id == 0) {
            log.warn("Validación fallida: id vacío o null");
            throw new DatosInvalidosException("El ID de la cita no puede estar vacío.");
        }
    }

    public void validarNombreTarea(String nombre) {
        log.info("Validando nombre de paciente");
        if (nombre == null || nombre.isEmpty()) {
            throw new DatosInvalidosException("El nombre no puede ser nulo o estar vacio");
        }
    }

//    public void validarEncontrarTarea(Tarea tarea) {
//        if() {
//            log.warn("Validación fallida: id vacío o null");
//            throw new DatosInvalidosException("El ID de la cita no puede estar vacío.");
//        }
//    }
}
