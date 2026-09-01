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

        int filas, columnas, opcion;

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

        // Mostrar matriz
        System.out.println("\nMATRIZ");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        System.out.println("\nTIPOS DE RECORRIDO");
        System.out.println("1. Por filas");
        System.out.println("2. Por columnas");
        System.out.println("3. Por diagonal principal");
        System.out.print("Seleccione una opción: ");
        opcion = teclado.nextInt();

        switch (opcion) {

            case 1:

                int[] vectorFilas = new int[filas * columnas];
                int indice = 0;

                for (int i = 0; i < filas; i++) {

                    for (int j = 0; j < columnas; j++) {

                        vectorFilas[indice] = matriz[i][j];
                        indice++;

                    }

                }

                System.out.println("\nVECTOR POR FILAS");

                for (int i = 0; i < vectorFilas.length; i++) {

                    System.out.print(vectorFilas[i] + " ");

                }

                break;

            case 2:

                int[] vectorColumnas = new int[filas * columnas];
                indice = 0;

                for (int j = 0; j < columnas; j++) {

                    for (int i = 0; i < filas; i++) {

                        vectorColumnas[indice] = matriz[i][j];
                        indice++;

                    }

                }

                System.out.println("\nVECTOR POR COLUMNAS");

                for (int i = 0; i < vectorColumnas.length; i++) {

                    System.out.print(vectorColumnas[i] + " ");

                }

                break;

            case 3:

                if (filas != columnas) {

                    System.out.println("\nLa matriz no es cuadrada.");
                    System.out.println("No se puede recorrer la diagonal principal.");

                } else {

                    int[] vectorDiagonal = new int[filas];

                    for (int i = 0; i < filas; i++) {

                        vectorDiagonal[i] = matriz[i][i];

                    }

                    System.out.println("\nVECTOR DIAGONAL");

                    for (int i = 0; i < vectorDiagonal.length; i++) {

                        System.out.print(vectorDiagonal[i] + " ");

                    }

                }

                break;

            default:

                System.out.println("Opción inválida.");

        }

        teclado.close();

    }

}
