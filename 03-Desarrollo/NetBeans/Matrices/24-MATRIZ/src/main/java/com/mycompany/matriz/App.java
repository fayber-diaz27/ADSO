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

        int filas = 6;
        int columnas = 6;

        int[][] matriz = new int[filas][columnas];

        // Persona infectada inicial
        matriz[2][2] = 1;

        int rondas;

        System.out.print("Ingrese la cantidad de rondas: ");
        rondas = teclado.nextInt();

        for (int ronda = 1; ronda <= rondas; ronda++) {

            int[][] nuevaMatriz = new int[filas][columnas];

            // Copiar la matriz actual
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    nuevaMatriz[i][j] = matriz[i][j];
                }
            }

            // Propagar el virus
            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    if (matriz[i][j] == 1) {

                        // Arriba
                        if (i > 0)
                            nuevaMatriz[i - 1][j] = 1;

                        // Abajo
                        if (i < filas - 1)
                            nuevaMatriz[i + 1][j] = 1;

                        // Izquierda
                        if (j > 0)
                            nuevaMatriz[i][j - 1] = 1;

                        // Derecha
                        if (j < columnas - 1)
                            nuevaMatriz[i][j + 1] = 1;

                    }

                }

            }

            // Actualizar la matriz
            matriz = nuevaMatriz;

            // Mostrar la ronda
            System.out.println("\nRONDA " + ronda);

            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    System.out.print(matriz[i][j] + " ");

                }

                System.out.println();

            }

        }

        // Contar infectados
        int infectados = 0;

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (matriz[i][j] == 1) {
                    infectados++;
                }

            }

        }

        System.out.println("\nTotal de personas infectadas: " + infectados);

        teclado.close();

    }

}