package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menuPrincipal();
        } while (opcion != 0);
    }

    private static int menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("===MENU TAMAGOTCHI===");
            System.out.println("1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción:");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion < 0 || opcion > 4) {
                    System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Ha d'introduir un número.");
                scanner.next();
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }
}