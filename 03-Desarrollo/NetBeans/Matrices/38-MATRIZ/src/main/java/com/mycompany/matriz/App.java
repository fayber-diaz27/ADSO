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

        System.out.print("Filas de la matriz A: ");
        filasA = teclado.nextInt();

        System.out.print("Columnas de la matriz A: ");
        columnasA = teclado.nextInt();

        System.out.print("Filas de la matriz B: ");
        filasB = teclado.nextInt();

        System.out.print("Columnas de la matriz B: ");
        columnasB = teclado.nextInt();

        if (columnasA != filasB) {

            System.out.println("\nNo es posible multiplicar las matrices.");
            teclado.close();
            return;

        }

        int[][] A = new int[filasA][columnasA];
        int[][] B = new int[filasB][columnasB];
        int[][] C = new int[filasA][columnasB];

        // Ingresar matriz A
        System.out.println("\nIngrese los datos de la matriz A");

        for (int i = 0; i < filasA; i++) {

            for (int j = 0; j < columnasA; j++) {

                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = teclado.nextInt();

            }

        }

        // Ingresar matriz B
        System.out.println("\nIngrese los datos de la matriz B");

        for (int i = 0; i < filasB; i++) {

            for (int j = 0; j < columnasB; j++) {

                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = teclado.nextInt();

            }

        }

        // Mostrar matrices
        System.out.println("\n===== MATRIZ A =====");
        mostrarMatriz(A);

        System.out.println("\n===== MATRIZ B =====");
        mostrarMatriz(B);

        System.out.println("\n===== PROCEDIMIENTO =====");

        // Multiplicación
        for (int i = 0; i < filasA; i++) {

            for (int j = 0; j < columnasB; j++) {

                C[i][j] = 0;

                System.out.print("C[" + i + "][" + j + "] = ");

                for (int k = 0; k < columnasA; k++) {

                    System.out.print(A[i][k] + "*" + B[k][j]);

                    C[i][j] += A[i][k] * B[k][j];

                    if (k < columnasA - 1) {
                        System.out.print(" + ");
                    }

                }

                System.out.println(" = " + C[i][j]);

            }

        }

        System.out.println("\n===== MATRIZ RESULTADO =====");
        mostrarMatriz(C);

        teclado.close();

    }

    public static void mostrarMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

    }

}