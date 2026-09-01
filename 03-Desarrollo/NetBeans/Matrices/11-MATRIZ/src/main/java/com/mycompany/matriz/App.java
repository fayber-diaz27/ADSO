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

        int[][] parqueadero = new int[5][10];

        int opcion;

        do {

            System.out.println("\n========= PARQUEADERO =========");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar salida");
            System.out.println("3. Mostrar parqueadero");
            System.out.println("4. Mostrar ocupación");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    int piso, espacio;

                    System.out.print("Ingrese el piso (1-5): ");
                    piso = teclado.nextInt() - 1;

                    System.out.print("Ingrese el espacio (1-10): ");
                    espacio = teclado.nextInt() - 1;

                    if (piso >= 0 && piso < 5 && espacio >= 0 && espacio < 10) {

                        if (parqueadero[piso][espacio] == 0) {

                            parqueadero[piso][espacio] = 1;
                            System.out.println("Vehículo registrado correctamente.");

                        } else {

                            System.out.println("Ese espacio ya está ocupado.");

                        }

                    } else {

                        System.out.println("Posición inválida.");

                    }

                    break;

                case 2:

                    System.out.print("Ingrese el piso (1-5): ");
                    piso = teclado.nextInt() - 1;

                    System.out.print("Ingrese el espacio (1-10): ");
                    espacio = teclado.nextInt() - 1;

                    if (piso >= 0 && piso < 5 && espacio >= 0 && espacio < 10) {

                        if (parqueadero[piso][espacio] == 1) {

                            parqueadero[piso][espacio] = 0;
                            System.out.println("Vehículo retirado correctamente.");

                        } else {

                            System.out.println("No hay vehículo en ese espacio.");

                        }

                    } else {

                        System.out.println("Posición inválida.");

                    }

                    break;

                case 3:

                    System.out.println("\nESTADO DEL PARQUEADERO");

                    for (int i = 0; i < 5; i++) {

                        System.out.print("Piso " + (i + 1) + ": ");

                        for (int j = 0; j < 10; j++) {

                            if (parqueadero[i][j] == 1) {
                                System.out.print("[X] ");
                            } else {
                                System.out.print("[ ] ");
                            }

                        }

                        System.out.println();

                    }

                    break;

                case 4:

                    int ocupados = 0;
                    int disponibles = 0;

                    for (int i = 0; i < 5; i++) {

                        for (int j = 0; j < 10; j++) {

                            if (parqueadero[i][j] == 1) {
                                ocupados++;
                            } else {
                                disponibles++;
                            }

                        }

                    }

                    double porcentaje = (ocupados * 100.0) / 50;

                    System.out.println("\nEspacios ocupados: " + ocupados);
                    System.out.println("Espacios disponibles: " + disponibles);
                    System.out.printf("Porcentaje de ocupación: %.2f%%\n", porcentaje);

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

}
