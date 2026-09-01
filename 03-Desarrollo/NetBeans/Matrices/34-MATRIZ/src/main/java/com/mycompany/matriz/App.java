/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz;

import java.util.Scanner;

/**
 *
 * @author diazf
 */
public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int pisos = 3;
        int espacios = 6;

        int[][] parqueadero = new int[pisos][espacios];

        int opcion;

        do {

            System.out.println("\n===== PARQUEADERO INTELIGENTE =====");
            System.out.println("1. Mostrar parqueadero");
            System.out.println("2. Registrar vehículo");
            System.out.println("3. Retirar vehículo");
            System.out.println("4. Mostrar ocupación");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    mostrarParqueadero(parqueadero);
                    break;

                case 2:
                    registrarVehiculo(parqueadero);
                    break;

                case 3:

                    System.out.print("Ingrese el piso: ");
                    int piso = teclado.nextInt();

                    System.out.print("Ingrese el espacio: ");
                    int espacio = teclado.nextInt();

                    if (piso >= 0 && piso < pisos &&
                        espacio >= 0 && espacio < espacios) {

                        if (parqueadero[piso][espacio] == 1) {

                            parqueadero[piso][espacio] = 0;
                            System.out.println("Vehículo retirado.");

                        } else {

                            System.out.println("Ese espacio ya está libre.");

                        }

                    } else {

                        System.out.println("Posición inválida.");

                    }

                    break;

                case 4:
                    mostrarOcupacion(parqueadero);
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");

            }

        } while (opcion != 5);

        teclado.close();

    }

    // Mostrar parqueadero
    public static void mostrarParqueadero(int[][] parqueadero) {

        System.out.println("\nESTADO DEL PARQUEADERO");

        for (int i = 0; i < parqueadero.length; i++) {

            System.out.print("Piso " + i + ": ");

            for (int j = 0; j < parqueadero[i].length; j++) {

                System.out.print(parqueadero[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Registrar vehículo automáticamente
    public static void registrarVehiculo(int[][] parqueadero) {

        for (int i = 0; i < parqueadero.length; i++) {

            for (int j = 0; j < parqueadero[i].length; j++) {

                if (parqueadero[i][j] == 0) {

                    parqueadero[i][j] = 1;

                    System.out.println("Vehículo registrado.");
                    System.out.println("Piso: " + i);
                    System.out.println("Espacio: " + j);

                    return;

                }

            }

        }

        System.out.println("No hay espacios disponibles.");

    }

    // Mostrar ocupación
    public static void mostrarOcupacion(int[][] parqueadero) {

        int totalLibres = 0;
        int totalOcupados = 0;

        for (int i = 0; i < parqueadero.length; i++) {

            int ocupadosPiso = 0;

            for (int j = 0; j < parqueadero[i].length; j++) {

                if (parqueadero[i][j] == 1) {

                    ocupadosPiso++;
                    totalOcupados++;

                } else {

                    totalLibres++;

                }

            }

            double porcentaje = (ocupadosPiso * 100.0) / parqueadero[i].length;

            System.out.printf("Piso %d: %.2f%% ocupado%n", i, porcentaje);

        }

        System.out.println("\nEspacios ocupados: " + totalOcupados);
        System.out.println("Espacios libres: " + totalLibres);

    }

}