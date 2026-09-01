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

        // Datos de la primera matriz
        System.out.print("Ingrese el número de filas de la matriz A: ");
        filasA = teclado.nextInt();

        System.out.print("Ingrese el número de columnas de la matriz A: ");
        columnasA = teclado.nextInt();

        // Datos de la segunda matriz
        System.out.print("Ingrese el número de filas de la matriz B: ");
        filasB = teclado.nextInt();

        System.out.print("Ingrese el número de columnas de la matriz B: ");
        columnasB = teclado.nextInt();

        // Validar compatibilidad
        if (columnasA != filasB) {
            System.out.println("\nNo es posible multiplicar las matrices.");
            System.out.println("Las columnas de A deben ser iguales a las filas de B.");
            teclado.close();
            return;
        }

        int[][] matrizA = new int[filasA][columnasA];
        int[][] matrizB = new int[filasB][columnasB];
        int[][] resultado = new int[filasA][columnasB];

        // Llenar matriz A
        System.out.println("\nIngrese los valores de la matriz A:");

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                matrizA[i][j] = teclado.nextInt();
            }
        }

        // Llenar matriz B
        System.out.println("\nIngrese los valores de la matriz B:");

        for (int i = 0; i < filasB; i++) {
            for (int j = 0; j < columnasB; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                matrizB[i][j] = teclado.nextInt();
            }
        }

        // Multiplicación de matrices
        for (int i = 0; i < filasA; i++) {

            for (int j = 0; j < columnasB; j++) {

                resultado[i][j] = 0;

                for (int k = 0; k < columnasA; k++) {

                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];

                }

            }

        }

        // Mostrar matriz A
        System.out.println("\nMATRIZ A");

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.printf("%5d", matrizA[i][j]);
            }
            System.out.println();
        }

        // Mostrar matriz B
        System.out.println("\nMATRIZ B");

        for (int i = 0; i < filasB; i++) {
            for (int j = 0; j < columnasB; j++) {
                System.out.printf("%5d", matrizB[i][j]);
            }
            System.out.println();
        }

        // Mostrar resultado
        System.out.println("\nMATRIZ RESULTADO");

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                System.out.printf("%6d", resultado[i][j]);
            }
            System.out.println();
        }

        teclado.close();
    }
}
