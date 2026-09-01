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

        int n;

        // Validar que el tamaño sea mínimo 3
        do {
            System.out.print("Ingrese el tamaño de la matriz cuadrada (mínimo 3): ");
            n = teclado.nextInt();
        } while (n < 3);

        int[][] matriz = new int[n][n];

        // Llenar la matriz
        System.out.println("\nIngrese los valores de la matriz:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();

            }

        }

        // Mostrar la matriz
        System.out.println("\nMATRIZ");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        int sumaBordes = 0;
        int sumaCentro = 0;

        // Calcular sumas
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {

                    sumaBordes += matriz[i][j];

                } else {

                    sumaCentro += matriz[i][j];

                }

            }

        }

        int diferencia = Math.abs(sumaBordes - sumaCentro);

        // Mostrar resultados
        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Suma de los bordes: " + sumaBordes);
        System.out.println("Suma del centro: " + sumaCentro);
        System.out.println("Diferencia: " + diferencia);

        teclado.close();
    }

}