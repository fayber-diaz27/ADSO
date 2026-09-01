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

        int filas, columnas;

        System.out.print("Ingrese el número de filas: ");
        filas = teclado.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        columnas = teclado.nextInt();

        int[][] matriz = new int[filas][columnas];

        // Llenar la matriz
        System.out.println("\nIngrese los valores de la matriz:");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();

            }

        }

        // Mostrar la matriz
        System.out.println("\n===== MATRIZ =====");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        boolean hayDuplicadas = false;

        // Comparar las filas
        for (int i = 0; i < filas - 1; i++) {

            for (int k = i + 1; k < filas; k++) {

                boolean iguales = true;

                for (int j = 0; j < columnas; j++) {

                    if (matriz[i][j] != matriz[k][j]) {

                        iguales = false;
                        break;

                    }

                }

                if (iguales) {

                    System.out.println("\nLa fila " + (i + 1)
                            + " es igual a la fila " + (k + 1));

                    hayDuplicadas = true;

                }

            }

        }

        if (!hayDuplicadas) {

            System.out.println("\nNo existen filas duplicadas.");

        }

        teclado.close();

    }

}