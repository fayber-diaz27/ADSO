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

        System.out.print("Ingrese el tamaño de la matriz: ");
        int n = teclado.nextInt();

        int[][] matriz = new int[n][n];

        System.out.println("\n1. Espiral Horario");
        System.out.println("2. Espiral Antihorario");
        System.out.print("Seleccione una opción: ");
        int opcion = teclado.nextInt();

        if (opcion == 1) {

            llenarHorario(matriz);

        } else if (opcion == 2) {

            llenarAntihorario(matriz);

        } else {

            System.out.println("Opción inválida.");
            teclado.close();
            return;

        }

        System.out.println("\n===== MATRIZ =====");

        mostrarMatriz(matriz);

        teclado.close();

    }

    public static void llenarHorario(int[][] matriz) {

        int arriba = 0;
        int abajo = matriz.length - 1;
        int izquierda = 0;
        int derecha = matriz.length - 1;

        int numero = 1;

        while (arriba <= abajo && izquierda <= derecha) {

            // Izquierda -> Derecha
            for (int i = izquierda; i <= derecha; i++) {

                matriz[arriba][i] = numero++;

            }

            arriba++;

            // Arriba -> Abajo
            for (int i = arriba; i <= abajo; i++) {

                matriz[i][derecha] = numero++;

            }

            derecha--;

            // Derecha -> Izquierda
            if (arriba <= abajo) {

                for (int i = derecha; i >= izquierda; i--) {

                    matriz[abajo][i] = numero++;

                }

                abajo--;

            }

            // Abajo -> Arriba
            if (izquierda <= derecha) {

                for (int i = abajo; i >= arriba; i--) {

                    matriz[i][izquierda] = numero++;

                }

                izquierda++;

            }

        }

    }

    public static void llenarAntihorario(int[][] matriz) {

        int arriba = 0;
        int abajo = matriz.length - 1;
        int izquierda = 0;
        int derecha = matriz.length - 1;

        int numero = 1;

        while (arriba <= abajo && izquierda <= derecha) {

            // Arriba -> Abajo
            for (int i = arriba; i <= abajo; i++) {

                matriz[i][izquierda] = numero++;

            }

            izquierda++;

            // Izquierda -> Derecha
            for (int i = izquierda; i <= derecha; i++) {

                matriz[abajo][i] = numero++;

            }

            abajo--;

            // Abajo -> Arriba
            if (izquierda <= derecha) {

                for (int i = abajo; i >= arriba; i--) {

                    matriz[i][derecha] = numero++;

                }

                derecha--;

            }

            // Derecha -> Izquierda
            if (arriba <= abajo) {

                for (int i = derecha; i >= izquierda; i--) {

                    matriz[arriba][i] = numero++;

                }

                arriba++;

            }

        }

    }

    public static void mostrarMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%4d", matriz[i][j]);

            }

            System.out.println();

        }

    }

}