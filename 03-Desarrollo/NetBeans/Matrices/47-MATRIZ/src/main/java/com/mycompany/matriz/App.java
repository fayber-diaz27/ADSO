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

        System.out.print("Número de filas: ");
        int filas = teclado.nextInt();

        System.out.print("Número de columnas: ");
        int columnas = teclado.nextInt();

        int[][] costo = new int[filas][columnas];
        int[][] minimo = new int[filas][columnas];

        System.out.println("\nIngrese el costo de cada posición:");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Costo [" + i + "][" + j + "]: ");
                    costo[i][j] = teclado.nextInt();

                    if (costo[i][j] < 0) {
                        System.out.println("El costo no puede ser negativo.");
                    }

                } while (costo[i][j] < 0);

            }

        }

        // Inicializar la primera posición
        minimo[0][0] = costo[0][0];

        // Primera fila
        for (int j = 1; j < columnas; j++) {

            minimo[0][j] = minimo[0][j - 1] + costo[0][j];

        }

        // Primera columna
        for (int i = 1; i < filas; i++) {

            minimo[i][0] = minimo[i - 1][0] + costo[i][0];

        }

        // Resto de la matriz
        for (int i = 1; i < filas; i++) {

            for (int j = 1; j < columnas; j++) {

                minimo[i][j] = Math.min(minimo[i - 1][j],
                                        minimo[i][j - 1])
                                        + costo[i][j];

            }

        }

        System.out.println("\n===== MATRIZ DE COSTOS =====");

        mostrar(costo);

        System.out.println("\n===== COSTOS ACUMULADOS =====");

        mostrar(minimo);

        System.out.println("\nCosto mínimo de la ruta: "
                + minimo[filas - 1][columnas - 1]);

        teclado.close();

    }

    public static void mostrar(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

    }

}