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
                {'.', '.', '.', '.', '.'},
                {'.', '*', '.', '.', '.'},
                {'.', '.', '.', '*', '.'},
                {'.', '.', '.', '.', '.'},
                {'*', '.', '.', '.', '.'}
        };

        boolean[][] descubiertas = new boolean[5][5];

        boolean juego = true;

        while (juego) {

            mostrarTablero(tablero, descubiertas);

            System.out.print("\nFila (0-4): ");
            int fila = teclado.nextInt();

            System.out.print("Columna (0-4): ");
            int columna = teclado.nextInt();

            if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {

                System.out.println("Posición inválida.");
                continue;

            }

            if (descubiertas[fila][columna]) {

                System.out.println("Esa casilla ya fue descubierta.");
                continue;

            }

            descubiertas[fila][columna] = true;

            if (tablero[fila][columna] == '*') {

                System.out.println("\n¡¡BOOM!!");
                System.out.println("Has encontrado una mina.");

                mostrarMinas(tablero);

                juego = false;

            } else {

                int minas = contarMinas(tablero, fila, columna);

                System.out.println("Minas cercanas: " + minas);

            }

        }

        teclado.close();

    }

    // Mostrar tablero ocultando minas
    public static void mostrarTablero(char[][] tablero, boolean[][] descubiertas) {

        System.out.println("\n===== TABLERO =====");

        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[i].length; j++) {

                if (descubiertas[i][j]) {

                    if (tablero[i][j] == '*') {

                        System.out.print("* ");

                    } else {

                        System.out.print("X ");

                    }

                } else {

                    System.out.print(". ");

                }

            }

            System.out.println();

        }

    }

    // Contar minas vecinas
    public static int contarMinas(char[][] tablero, int fila, int columna) {

        int contador = 0;

        for (int i = fila - 1; i <= fila + 1; i++) {

            for (int j = columna - 1; j <= columna + 1; j++) {

                if (i >= 0 && i < tablero.length &&
                    j >= 0 && j < tablero[0].length &&
                    tablero[i][j] == '*') {

                    contador++;

                }

            }

        }

        return contador;

    }

    // Mostrar todas las minas
    public static void mostrarMinas(char[][] tablero) {

        System.out.println("\n===== TABLERO FINAL =====");

        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[i].length; j++) {

                System.out.print(tablero[i][j] + " ");

            }

            System.out.println();

        }

    }

}