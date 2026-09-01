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

        int filasA, columnasA;
        int filasB, columnasB;

        // Tamaño de la primera matriz
        System.out.print("Filas de la matriz A: ");
        filasA = teclado.nextInt();

        System.out.print("Columnas de la matriz A: ");
        columnasA = teclado.nextInt();

        // Tamaño de la segunda matriz
        System.out.print("Filas de la matriz B: ");
        filasB = teclado.nextInt();

        System.out.print("Columnas de la matriz B: ");
        columnasB = teclado.nextInt();

        // Verificar si se pueden multiplicar
        if (columnasA != filasB) {

            System.out.println("\nNo es posible multiplicar las matrices.");

            teclado.close();
            return;

        }

        int[][] A = new int[filasA][columnasA];
        int[][] B = new int[filasB][columnasB];
        int[][] C = new int[filasA][columnasB];

        // Llenar matriz A
        System.out.println("\nIngrese los datos de la matriz A:");

        for (int i = 0; i < filasA; i++) {

            for (int j = 0; j < columnasA; j++) {

                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = teclado.nextInt();

            }

        }

        // Llenar matriz B
        System.out.println("\nIngrese los datos de la matriz B:");

        for (int i = 0; i < filasB; i++) {

            for (int j = 0; j < columnasB; j++) {

                System.out.print("B[" + i + "][" + j + "]: ");
                B[i][j] = teclado.nextInt();

            }

        }

        // Multiplicación de matrices
        for (int i = 0; i < filasA; i++) {

            for (int j = 0; j < columnasB; j++) {

                C[i][j] = 0;

                for (int k = 0; k < columnasA; k++) {

                    C[i][j] += A[i][k] * B[k][j];

                }

            }

        }

        // Mostrar matriz A
        System.out.println("\n===== MATRIZ A =====");

        for (int i = 0; i < filasA; i++) {

            for (int j = 0; j < columnasA; j++) {

                System.out.printf("%5d", A[i][j]);

            }

            System.out.println();

        }

        // Mostrar matriz B
        System.out.println("\n===== MATRIZ B =====");

        for (int i = 0; i < filasB; i++) {

            for (int j = 0; j < columnasB; j++) {

                System.out.printf("%5d", B[i][j]);

            }

            System.out.println();

        }

        // Mostrar resultado
        System.out.println("\n===== MATRIZ RESULTADO =====");

        for (int i = 0; i < filasA; i++) {

            for (int j = 0; j < columnasB; j++) {

                System.out.printf("%5d", C[i][j]);

            }

            System.out.println();

        }

        teclado.close();

    }

}