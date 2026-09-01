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
                {'I', '0', '1', '0', '0', '0'},
                {'1', '0', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '1', '0'},
                {'0', '1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '0'},
                {'1', '1', '0', '0', '0', 'F'}
        };

        int fila = 0;
        int columna = 0;

        boolean terminado = false;

        while (!terminado) {

            // Mostrar tablero
            System.out.println("\nLABERINTO");

            for (int i = 0; i < 6; i++) {

                for (int j = 0; j < 6; j++) {

                    if (i == fila && j == columna) {

                        System.out.print("P ");

                    } else {

                        System.out.print(tablero[i][j] + " ");

                    }

                }

                System.out.println();

            }

            System.out.println("\nMovimientos");
            System.out.println("W = Arriba");
            System.out.println("S = Abajo");
            System.out.println("A = Izquierda");
            System.out.println("D = Derecha");

            System.out.print("Movimiento: ");
            char movimiento = teclado.next().toUpperCase().charAt(0);

            int nuevaFila = fila;
            int nuevaColumna = columna;

            switch (movimiento) {

                case 'W':
                    nuevaFila--;
                    break;

                case 'S':
                    nuevaFila++;
                    break;

                case 'A':
                    nuevaColumna--;
                    break;

                case 'D':
                    nuevaColumna++;
                    break;

                default:
                    System.out.println("Movimiento inválido.");
                    continue;

            }

            // Validar límites
            if (nuevaFila < 0 || nuevaFila >= 6 ||
                nuevaColumna < 0 || nuevaColumna >= 6) {

                System.out.println("No puedes salir del tablero.");
                continue;

            }

            // Validar obstáculos
            if (tablero[nuevaFila][nuevaColumna] == '1') {

                System.out.println("Hay una pared.");
                continue;

            }

            fila = nuevaFila;
            columna = nuevaColumna;

            // Llegó al final
            if (tablero[fila][columna] == 'F') {

                terminado = true;

            }

        }

        System.out.println("\n¡¡FELICIDADES!!");
        System.out.println("Has llegado al destino.");

        teclado.close();

    }

}