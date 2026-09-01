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

        int filas = 5;
        int columnas = 6;

        int[][] asientos = new int[filas][columnas];

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE RESERVAS =====");
            System.out.println("1. Mostrar asientos");
            System.out.println("2. Reservar asiento");
            System.out.println("3. Liberar asiento");
            System.out.println("4. Contar asientos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("\nESTADO DE LOS ASIENTOS");

                    System.out.print("    ");

                    for (int j = 0; j < columnas; j++) {
                        System.out.printf("%3d", j);
                    }

                    System.out.println();

                    for (int i = 0; i < filas; i++) {

                        System.out.printf("%2d ", i);

                        for (int j = 0; j < columnas; j++) {

                            System.out.printf("%3d", asientos[i][j]);

                        }

                        System.out.println();

                    }

                    break;

                case 2:

                    System.out.print("Fila: ");
                    int fila = teclado.nextInt();

                    System.out.print("Columna: ");
                    int columna = teclado.nextInt();

                    if (fila >= 0 && fila < filas &&
                        columna >= 0 && columna < columnas) {

                        if (asientos[fila][columna] == 0) {

                            asientos[fila][columna] = 1;
                            System.out.println("Asiento reservado correctamente.");

                        } else {

                            System.out.println("Ese asiento ya está ocupado.");

                        }

                    } else {

                        System.out.println("Posición inválida.");

                    }

                    break;

                case 3:

                    System.out.print("Fila: ");
                    fila = teclado.nextInt();

                    System.out.print("Columna: ");
                    columna = teclado.nextInt();

                    if (fila >= 0 && fila < filas &&
                        columna >= 0 && columna < columnas) {

                        if (asientos[fila][columna] == 1) {

                            asientos[fila][columna] = 0;
                            System.out.println("Reserva cancelada.");

                        } else {

                            System.out.println("Ese asiento ya estaba libre.");

                        }

                    } else {

                        System.out.println("Posición inválida.");

                    }

                    break;

                case 4:

                    int disponibles = 0;
                    int ocupados = 0;

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            if (asientos[i][j] == 0) {

                                disponibles++;

                            } else {

                                ocupados++;

                            }

                        }

                    }

                    System.out.println("\nAsientos disponibles: " + disponibles);
                    System.out.println("Asientos ocupados: " + ocupados);

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