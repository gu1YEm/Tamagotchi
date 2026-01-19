package org.example;
import java.util.Scanner;

public class Main {
    static int saciedad = 6;
    static int energia = 6;
    static int diversion = 6;

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menuPrincipal();

            if (opcion == 1) mostrarEstado();

            if (opcion == 2) {
                if (saciedad < 10) {
                    saciedad += 3;
                    if (saciedad > 10) saciedad = 10;
                    diversion -= 1;
                    mostrarEstado();
                } else {
                    System.out.println("No tengo hambre");
                }
            }

            if (opcion == 3) {
                if (diversion < 10) {
                    diversion += 3; // Jugar puja diversió
                    if (diversion > 10) diversion = 10;
                    saciedad -= 1;
                    energia -= 2;
                    mostrarEstado();
                } else {
                    System.out.println("Ahora no me apetece jugar");
                }
            }

            if (opcion == 4) {
                if (energia < 10) {
                    energia += 5;
                    if (energia > 10) energia = 10;
                    saciedad -= 3;
                    diversion -= 2;
                    mostrarEstado();
                } else {
                    System.out.println("No tengo sueño");
                }
            }

            if (opcion == 5) {
                System.out.println("Visitant al metge... T'has curat!");
                energia = 10;
                saciedad = 10;
                diversion -= 3;
                mostrarEstado();
            }

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
            System.out.println("5. Curar (Metge)");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción:");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion < 0 || opcion > 5) {
                    System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Ha d'introduir un número.");
                scanner.next();
            }
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    private static void mostrarEstado() {
        System.out.println("Saciedad: " + saciedad + " | Energia: " + energia + " | Diversion: " + diversion);

        if (saciedad <= 0 || energia <= 0 || diversion <= 0) {
            System.out.println("(-_-) Game Over");
            System.out.println("Fin del juego!");
            System.exit(0);
        } else if (diversion <= 4) {
            System.out.println("(-,-) Estoy aburrido / ¡Juega conmigo!");
        } else if (energia <= 4) {
            System.out.println("(-_-) Zzz   (Cansado)");
        } else if (saciedad <= 4) {
            System.out.println(" ( . . )");
            System.out.println(" / |x| \\   ¡Tengo hambre!");
        } else {
            System.out.println("  (^_^) ¡Estoy feliz!");
        }
    }
}