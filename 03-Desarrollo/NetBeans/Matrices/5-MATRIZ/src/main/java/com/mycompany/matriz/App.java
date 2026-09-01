/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author diazf
 */
public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        int[][] tablero = new int[10][10];

        int barcos = 10;
        int destruidos = 0;

        // Colocar barcos aleatoriamente
        while (barcos > 0) {

            int fila = aleatorio.nextInt(10);
            int columna = aleatorio.nextInt(10);

            if (tablero[fila][columna] == 0) {
                tablero[fila][columna] = 1;
                barcos--;
            }

        }

        System.out.println("===== BATALLA NAVAL =====");

        while (destruidos < 10) {

            // Mostrar tablero al jugador
            System.out.println("\nTABLERO");

            System.out.print("   ");
            for (int j = 0; j < 10; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

            for (int i = 0; i < 10; i++) {

                System.out.print(i + "  ");

                for (int j = 0; j < 10; j++) {

                    if (tablero[i][j] == 2) {
                        System.out.print("X ");
                    } else if (tablero[i][j] == 3) {
                        System.out.print("O ");
                    } else {
                        System.out.print("- ");
                    }

                }

                System.out.println();
            }

            int fila, columna;

            System.out.print("\nIngrese la fila (0-9): ");
            fila = teclado.nextInt();

            System.out.print("Ingrese la columna (0-9): ");
            columna = teclado.nextInt();

            if (fila < 0 || fila > 9 || columna < 0 || columna > 9) {
                System.out.println("Posición inválida.");
                continue;
            }

            if (tablero[fila][columna] == 2 || tablero[fila][columna] == 3) {
                System.out.println("Ya disparó en esa posición.");
            } else if (tablero[fila][columna] == 1) {
                System.out.println("¡¡IMPACTO!!");
                tablero[fila][columna] = 2;
                destruidos++;
            } else {
                System.out.println("Agua...");
                tablero[fila][columna] = 3;
            }

            System.out.println("Barcos destruidos: " + destruidos + "/10");

        }

        System.out.println("\n¡¡FELICIDADES!!");
        System.out.println("Has destruido todos los barcos.");

        teclado.close();

    }

}
