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
                {'t', '.', '.', '.', '.', '.', '.', 't'},
                {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                {'T', '.', '.', '.', '.', '.', '.', 'T'}
        };

        mostrarTablero(tablero);

        System.out.print("\nFila origen (0-7): ");
        int filaOrigen = teclado.nextInt();

        System.out.print("Columna origen (0-7): ");
        int columnaOrigen = teclado.nextInt();

        System.out.print("Fila destino (0-7): ");
        int filaDestino = teclado.nextInt();

        System.out.print("Columna destino (0-7): ");
        int columnaDestino = teclado.nextInt();

        if (filaOrigen < 0 || filaOrigen > 7 ||
            columnaOrigen < 0 || columnaOrigen > 7 ||
            filaDestino < 0 || filaDestino > 7 ||
            columnaDestino < 0 || columnaDestino > 7) {

            System.out.println("Posición inválida.");
            teclado.close();
            return;
        }

        if (tablero[filaOrigen][columnaOrigen] == '.') {

            System.out.println("No hay ninguna pieza en esa posición.");
            teclado.close();
            return;
        }

        if (tablero[filaDestino][columnaDestino] != '.') {

            System.out.println("¡Captura realizada!");

        }

        tablero[filaDestino][columnaDestino] = tablero[filaOrigen][columnaOrigen];
        tablero[filaOrigen][columnaOrigen] = '.';

        System.out.println("\n===== TABLERO ACTUALIZADO =====");

        mostrarTablero(tablero);

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