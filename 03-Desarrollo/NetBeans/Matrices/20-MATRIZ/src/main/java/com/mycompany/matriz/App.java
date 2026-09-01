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

        System.out.print("Ingrese el tamaño de la matriz cuadrada: ");
        n = teclado.nextInt();

        int[][] matriz = new int[n][n];

        // Llenar la matriz
        System.out.println("\nIngrese los valores de la matriz:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();

            }

        }

        // Mostrar matriz original
        System.out.println("\n===== MATRIZ ORIGINAL =====");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        int cerosSuperior = 0;

        // Matriz triangular superior
        System.out.println("\n===== MATRIZ TRIANGULAR SUPERIOR =====");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (j >= i) {

                    System.out.printf("%5d", matriz[i][j]);

                } else {

                    System.out.printf("%5d", 0);
                    cerosSuperior++;

                }

            }

            System.out.println();

        }

        int cerosInferior = 0;

        // Matriz triangular inferior
        System.out.println("\n===== MATRIZ TRIANGULAR INFERIOR =====");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (j <= i) {

                    System.out.printf("%5d", matriz[i][j]);

                } else {

                    System.out.printf("%5d", 0);
                    cerosInferior++;

                }

            }

            System.out.println();

        }

        // Mostrar cantidad de ceros
        System.out.println("\nCantidad de ceros en la triangular superior: " + cerosSuperior);
        System.out.println("Cantidad de ceros en la triangular inferior: " + cerosInferior);

        teclado.close();

    }

}