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
        System.out.println("\nMATRIZ");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        System.out.println("\nRECORRIDO EN ESPIRAL:");

        int arriba = 0;
        int abajo = filas - 1;
        int izquierda = 0;
        int derecha = columnas - 1;

        while (arriba <= abajo && izquierda <= derecha) {

            // Recorrer de izquierda a derecha
            for (int j = izquierda; j <= derecha; j++) {
                System.out.print(matriz[arriba][j] + " ");
            }
            arriba++;

            // Recorrer de arriba hacia abajo
            for (int i = arriba; i <= abajo; i++) {
                System.out.print(matriz[i][derecha] + " ");
            }
            derecha--;

            // Recorrer de derecha a izquierda
            if (arriba <= abajo) {

                for (int j = derecha; j >= izquierda; j--) {
                    System.out.print(matriz[abajo][j] + " ");
                }

                abajo--;

            }

            // Recorrer de abajo hacia arriba
            if (izquierda <= derecha) {

                for (int i = abajo; i >= arriba; i--) {
                    System.out.print(matriz[i][izquierda] + " ");
                }

                izquierda++;

            }

        }

        teclado.close();

    }

}
