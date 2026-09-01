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

        char[][] tablero = {
                {'~', '~', '~', '~', '~'},
                {'~', 'B', '~', 'B', '~'},
                {'~', '~', '~', '~', '~'},
                {'B', '~', '~', '~', '~'},
                {'~', '~', 'B', '~', '~'}
        };

        int barcosRestantes = 4;

        while (barcosRestantes > 0) {

            mostrarTablero(tablero);

            System.out.println("\nBarcos restantes: " + barcosRestantes);

            System.out.print("Fila del disparo (0-4): ");
            int fila = teclado.nextInt();

            System.out.print("Columna del disparo (0-4): ");
            int columna = teclado.nextInt();

            if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {

                System.out.println("Posición inválida.");
                continue;

            }

            if (tablero[fila][columna] == 'B') {

                System.out.println("¡¡Impacto!!");

                tablero[fila][columna] = 'X';

                barcosRestantes--;

            } else if (tablero[fila][columna] == '~') {

                System.out.println("Agua.");

                tablero[fila][columna] = 'O';

            } else {

                System.out.println("Ya disparaste en esa posición.");

            }

        }

        mostrarTablero(tablero);

        System.out.println("\n¡¡Felicidades!!");
        System.out.println("Has hundido todos los barcos.");

        teclado.close();

    }

    public static void mostrarTablero(char[][] tablero) {

        System.out.println("\n===== TABLERO =====");

        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[i].length; j++) {

                System.out.print(tablero[i][j] + " ");

            }

            System.out.println();

        }

    }

}