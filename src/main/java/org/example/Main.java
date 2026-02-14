package org.example;

import org.example.service.TareaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TareaService tareaService = new TareaService();
        int respuesta;

        do {
            System.out.println("Seleccione una opción del menú");
            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Salida");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (respuesta != 4);
    }
}