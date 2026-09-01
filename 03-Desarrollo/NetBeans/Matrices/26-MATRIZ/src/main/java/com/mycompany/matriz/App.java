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

        int[][] sudoku = new int[9][9];

        int opcion;

        do {

            // Mostrar tablero
            System.out.println("\n===== TABLERO DE SUDOKU =====");

            for (int i = 0; i < 9; i++) {

                if (i % 3 == 0 && i != 0) {
                    System.out.println("-------------------------------");
                }

                for (int j = 0; j < 9; j++) {

                    if (j % 3 == 0 && j != 0) {
                        System.out.print("| ");
                    }

                    if (sudoku[i][j] == 0) {
                        System.out.print(". ");
                    } else {
                        System.out.print(sudoku[i][j] + " ");
                    }

                }

                System.out.println();

            }

            System.out.println("\n1. Colocar número");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            if (opcion == 1) {

                System.out.print("Fila (0-8): ");
                int fila = teclado.nextInt();

                System.out.print("Columna (0-8): ");
                int columna = teclado.nextInt();

                System.out.print("Número (1-9): ");
                int numero = teclado.nextInt();

                if (fila < 0 || fila > 8 ||
                    columna < 0 || columna > 8 ||
                    numero < 1 || numero > 9) {

                    System.out.println("Datos inválidos.");
                    continue;
                }

                if (sudoku[fila][columna] != 0) {

                    System.out.println("Esa casilla ya está ocupada.");
                    continue;

                }

                if (esValido(sudoku, fila, columna, numero)) {

                    sudoku[fila][columna] = numero;
                    System.out.println("Número agregado correctamente.");

                } else {

                    System.out.println("Movimiento no permitido.");

                }

            }

        } while (opcion != 2);

        System.out.println("Programa finalizado.");

        teclado.close();

    }

    public static boolean esValido(int[][] sudoku,
                                   int fila,
                                   int columna,
                                   int numero) {

        // Revisar fila
        for (int j = 0; j < 9; j++) {

            if (sudoku[fila][j] == numero) {
                return false;
            }

        }

        // Revisar columna
        for (int i = 0; i < 9; i++) {

            if (sudoku[i][columna] == numero) {
                return false;
            }

        }

        // Revisar bloque 3x3
        int inicioFila = (fila / 3) * 3;
        int inicioColumna = (columna / 3) * 3;

        for (int i = inicioFila; i < inicioFila + 3; i++) {

            for (int j = inicioColumna; j < inicioColumna + 3; j++) {

                if (sudoku[i][j] == numero) {
                    return false;
                }

            }

        }

        return true;

    }

}