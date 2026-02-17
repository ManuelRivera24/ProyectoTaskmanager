package org.example.view;
import org.example.model.Tarea;
import org.example.service.TareaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {
    public static final Logger log = LoggerFactory.getLogger(Menu.class);
    Scanner scanner = new Scanner(System.in);
    TareaService tareaService = new TareaService();

    public void iniciar() {
        int respuesta;

        do {
//            System.out.println("Seleccione una opción del menú");
//            respuesta = scanner.nextInt();
//            scanner.nextLine();
            respuesta = leerEntero("Seleccione una opción del menú");
            switch (respuesta) {
                case 1:
                    System.out.println("Crear");
                    int id = leerEntero("Digite el id de la tarea");
                    System.out.println("Digite el nombre de la tarea");
                    String nombre = scanner.nextLine();
                    System.out.println("Digite la descripción de la tarea");
                    String descrip = scanner.nextLine();
                    tareaService.agregarTarea(id, nombre, descrip);
                    break;
                case 2:
                    System.out.println("Listar");
                    for (Tarea tarea : tareaService.listarTareas()) {
                        System.out.println(tarea);
                    }
                    break;
                case 3:
                    System.out.println("Completar tarea");
                    int resp = leerEntero("Digite el id de la tarea completada");
                    tareaService.completarTarea(resp);
                    log.info("Se completó la tarea correctamente");
                    break;
                case 4:
                    System.out.println("Eliminar");
                    int resp2 = leerEntero("Digite el id de la tarea que desee eliminar");
                    tareaService.eliminarTarea(resp2);
                    log.info("Se eliminó la tarea correctamente");
                    break;
                case 5:
                    log.info("Salida de la aplicación");
                    break;
                default:
                    log.info("Opción inválida");
                    break;
            }
        } while (respuesta != 5);
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.println(mensaje);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }
}
