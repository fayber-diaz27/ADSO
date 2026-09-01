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
        int[][] rotada = new int[n][n];

        // Llenar la matriz
        System.out.println("\nIngrese los valores de la matriz:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();

            }

        }

        // Mostrar matriz original
        System.out.println("\nMATRIZ ORIGINAL");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        // Rotar la matriz 90 grados hacia la derecha
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                rotada[j][n - 1 - i] = matriz[i][j];

            }

        }

        // Mostrar matriz rotada
        System.out.println("\nMATRIZ ROTADA 90° A LA DERECHA");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.printf("%5d", rotada[i][j]);

            }

            System.out.println();

        }

        teclado.close();

    }

}
