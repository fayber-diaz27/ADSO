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
        System.out.println("\nIngrese los datos:");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();

            }

        }

        // Mostrar matriz
        System.out.println("\n===== MATRIZ ORIGINAL =====");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        // Contar elementos diferentes de cero
        int cantidad = 0;

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (matriz[i][j] != 0) {
                    cantidad++;
                }

            }

        }

        // Crear matriz comprimida
        int[][] comprimida = new int[cantidad][3];

        int indice = 0;

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (matriz[i][j] != 0) {

                    comprimida[indice][0] = i;
                    comprimida[indice][1] = j;
                    comprimida[indice][2] = matriz[i][j];

                    indice++;

                }

            }

        }

        // Mostrar matriz comprimida
        System.out.println("\n===== MATRIZ COMPRIMIDA =====");
        System.out.println("Fila\tColumna\tValor");

        for (int i = 0; i < cantidad; i++) {

            System.out.println(
                    comprimida[i][0] + "\t"
                    + comprimida[i][1] + "\t"
                    + comprimida[i][2]);

        }

        teclado.close();

    }

}