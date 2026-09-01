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

        System.out.print("Número de filas: ");
        int filas = teclado.nextInt();

        System.out.print("Número de columnas: ");
        int columnas = teclado.nextInt();

        int[][] laberinto = new int[filas][columnas];

        System.out.println("\nIngrese el laberinto:");
        System.out.println("0 = Pared");
        System.out.println("1 = Camino");

        // Llenar la matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Posición [" + i + "][" + j + "]: ");
                    laberinto[i][j] = teclado.nextInt();

                    if (laberinto[i][j] < 0 || laberinto[i][j] > 1) {

                        System.out.println("Solo puede ingresar 0 o 1.");

                    }

                } while (laberinto[i][j] < 0 || laberinto[i][j] > 1);

            }

        }

        int caminosCerrados = detectarCaminos(laberinto);

        System.out.println("\n===== LABERINTO ANALIZADO =====");
        mostrarMatriz(laberinto);

        System.out.println("\nCaminos cerrados encontrados: " + caminosCerrados);

        teclado.close();

    }

    // Detectar caminos cerrados
    public static int detectarCaminos(int[][] laberinto) {

        int contador = 0;

        for (int i = 0; i < laberinto.length; i++) {

            for (int j = 0; j < laberinto[i].length; j++) {

                if (laberinto[i][j] == 1) {

                    int vecinos = 0;

                    if (i > 0 && laberinto[i - 1][j] == 1)
                        vecinos++;

                    if (i < laberinto.length - 1 && laberinto[i + 1][j] == 1)
                        vecinos++;

                    if (j > 0 && laberinto[i][j - 1] == 1)
                        vecinos++;

                    if (j < laberinto[i].length - 1 && laberinto[i][j + 1] == 1)
                        vecinos++;

                    if (vecinos >= 3) {

                        laberinto[i][j] = 2;
                        contador++;

                    }

                }

            }

        }

        return contador;

    }

    // Mostrar matriz
    public static void mostrarMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + " ");

            }

            System.out.println();

        }

    }

}