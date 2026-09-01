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

        int[][] laberinto = {
                {2, 0, 0, 1, 0, 3},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 4, 0, 0, 0},
                {0, 1, 0, 1, 4, 0},
                {0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 0}
        };

        int filaJugador = 0;
        int columnaJugador = 0;

        boolean gano = false;

        while (!gano) {

            mostrarLaberinto(laberinto);

            System.out.println("\nMover jugador");
            System.out.println("W = Arriba");
            System.out.println("S = Abajo");
            System.out.println("A = Izquierda");
            System.out.println("D = Derecha");

            System.out.print("Opción: ");
            char opcion = teclado.next().toUpperCase().charAt(0);

            int nuevaFila = filaJugador;
            int nuevaColumna = columnaJugador;

            switch (opcion) {

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

            if (nuevaFila >= 0 &&
                nuevaFila < laberinto.length &&
                nuevaColumna >= 0 &&
                nuevaColumna < laberinto[0].length) {

                if (laberinto[nuevaFila][nuevaColumna] == 0 ||
                    laberinto[nuevaFila][nuevaColumna] == 3) {

                    laberinto[filaJugador][columnaJugador] = 0;

                    filaJugador = nuevaFila;
                    columnaJugador = nuevaColumna;

                    if (laberinto[filaJugador][columnaJugador] == 3) {

                        gano = true;

                    }

                    laberinto[filaJugador][columnaJugador] = 2;

                } else {

                    System.out.println("No puedes pasar.");

                }

            }

            moverObstaculos(laberinto);

        }

        mostrarLaberinto(laberinto);

        System.out.println("\n¡Llegaste a la salida!");

        teclado.close();

    }

    public static void mostrarLaberinto(int[][] laberinto) {

        System.out.println("\n===== LABERINTO =====");

        for (int i = 0; i < laberinto.length; i++) {

            for (int j = 0; j < laberinto[i].length; j++) {

                System.out.print(laberinto[i][j] + " ");

            }

            System.out.println();

        }

    }

    public static void moverObstaculos(int[][] laberinto) {

        for (int i = 0; i < laberinto.length; i++) {

            for (int j = laberinto[i].length - 2; j >= 0; j--) {

                if (laberinto[i][j] == 4 &&
                    laberinto[i][j + 1] == 0) {

                    laberinto[i][j] = 0;
                    laberinto[i][j + 1] = 4;

                }

            }

        }

    }

}