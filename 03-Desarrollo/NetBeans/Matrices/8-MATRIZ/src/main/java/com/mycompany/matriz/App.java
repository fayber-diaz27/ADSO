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

        // Mostrar matriz original
        System.out.println("\nMATRIZ ORIGINAL");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }

        // Ordenar cada fila con Bubble Sort
        for (int i = 0; i < filas; i++) {

            for (int pasada = 0; pasada < columnas - 1; pasada++) {

                for (int j = 0; j < columnas - 1 - pasada; j++) {

                    if (matriz[i][j] > matriz[i][j + 1]) {

                        int auxiliar = matriz[i][j];
                        matriz[i][j] = matriz[i][j + 1];
                        matriz[i][j + 1] = auxiliar;

                    }

                }

            }

        }

        // Mostrar matriz ordenada
        System.out.println("\nMATRIZ ORDENADA");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }

        teclado.close();
    }

}
