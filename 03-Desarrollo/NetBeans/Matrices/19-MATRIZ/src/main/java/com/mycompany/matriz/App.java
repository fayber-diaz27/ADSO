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

        String[][] tablero = new String[8][8];

        // Inicializar el tablero vacío
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                tablero[i][j] = ".";

            }

        }

        // Piezas negras
        tablero[0][0] = "TN";
        tablero[0][1] = "CN";
        tablero[0][2] = "AN";
        tablero[0][3] = "DN";
        tablero[0][4] = "RN";
        tablero[0][5] = "AN";
        tablero[0][6] = "CN";
        tablero[0][7] = "TN";

        for (int j = 0; j < 8; j++) {
            tablero[1][j] = "PN";
        }

        // Piezas blancas
        tablero[7][0] = "TB";
        tablero[7][1] = "CB";
        tablero[7][2] = "AB";
        tablero[7][3] = "DB";
        tablero[7][4] = "RB";
        tablero[7][5] = "AB";
        tablero[7][6] = "CB";
        tablero[7][7] = "TB";

        for (int j = 0; j < 8; j++) {
            tablero[6][j] = "PB";
        }

        // Mostrar tablero
        System.out.println("\nTABLERO DE AJEDREZ");

        System.out.print("    ");
        for (int j = 0; j < 8; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {

            System.out.printf("%2d ", i);

            for (int j = 0; j < 8; j++) {

                System.out.printf("%4s", tablero[i][j]);

            }

            System.out.println();

        }

        // Movimiento
        int filaOrigen, columnaOrigen;
        int filaDestino, columnaDestino;

        System.out.println("\nMover una pieza");

        System.out.print("Fila origen: ");
        filaOrigen = teclado.nextInt();

        System.out.print("Columna origen: ");
        columnaOrigen = teclado.nextInt();

        System.out.print("Fila destino: ");
        filaDestino = teclado.nextInt();

        System.out.print("Columna destino: ");
        columnaDestino = teclado.nextInt();

        // Validar posiciones
        if (filaOrigen >= 0 && filaOrigen < 8 &&
            columnaOrigen >= 0 && columnaOrigen < 8 &&
            filaDestino >= 0 && filaDestino < 8 &&
            columnaDestino >= 0 && columnaDestino < 8) {

            if (!tablero[filaOrigen][columnaOrigen].equals(".")) {

                tablero[filaDestino][columnaDestino] =
                        tablero[filaOrigen][columnaOrigen];

                tablero[filaOrigen][columnaOrigen] = ".";

                System.out.println("\nMovimiento realizado.");

            } else {

                System.out.println("\nNo hay ninguna pieza en esa posición.");

            }

        } else {

            System.out.println("\nPosición inválida.");

        }

        // Mostrar tablero actualizado
        System.out.println("\nTABLERO ACTUALIZADO");

        System.out.print("    ");
        for (int j = 0; j < 8; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {

            System.out.printf("%2d ", i);

            for (int j = 0; j < 8; j++) {

                System.out.printf("%4s", tablero[i][j]);

            }

            System.out.println();

        }

        teclado.close();

    }

}