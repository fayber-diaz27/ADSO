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

        int[][] tablero = new int[8][8];
        boolean[][] descubierto = new boolean[8][8];

        int minas = 10;

        // Colocar minas
        while (minas > 0) {

            int fila = aleatorio.nextInt(8);
            int columna = aleatorio.nextInt(8);

            if (tablero[fila][columna] != -1) {

                tablero[fila][columna] = -1;
                minas--;

            }

        }

        boolean perder = false;

        while (!perder) {

            // Mostrar tablero
            System.out.println("\nTABLERO");

            System.out.print("   ");
            for (int j = 0; j < 8; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

            for (int i = 0; i < 8; i++) {

                System.out.print(i + "  ");

                for (int j = 0; j < 8; j++) {

                    if (descubierto[i][j]) {

                        if (tablero[i][j] == -1) {
                            System.out.print("* ");
                        } else {
                            System.out.print(tablero[i][j] + " ");
                        }

                    } else {

                        System.out.print("# ");

                    }

                }

                System.out.println();

            }

            int fila, columna;

            System.out.print("\nFila: ");
            fila = teclado.nextInt();

            System.out.print("Columna: ");
            columna = teclado.nextInt();

            if (fila < 0 || fila > 7 || columna < 0 || columna > 7) {

                System.out.println("Posición inválida.");
                continue;

            }

            if (descubierto[fila][columna]) {

                System.out.println("Esa casilla ya fue descubierta.");
                continue;

            }

            descubierto[fila][columna] = true;

            if (tablero[fila][columna] == -1) {

                perder = true;

            } else {

                int contador = 0;

                for (int i = fila - 1; i <= fila + 1; i++) {

                    for (int j = columna - 1; j <= columna + 1; j++) {

                        if (i >= 0 && i < 8 && j >= 0 && j < 8) {

                            if (tablero[i][j] == -1) {
                                contador++;
                            }

                        }

                    }

                }

                tablero[fila][columna] = contador;

            }

        }

        // Mostrar todas las minas
        System.out.println("\n¡¡PERDISTE!!");

        System.out.println("\nTABLERO FINAL");

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if (tablero[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }

            }

            System.out.println();

        }

        teclado.close();

    }

}
