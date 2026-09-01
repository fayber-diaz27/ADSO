/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz;

/**
 *
 * @author diazf
 */
public class App {

    static int[][] mapa = {
            {1, 1, 0, 0, 1, 0},
            {1, 0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 1},
            {0, 0, 1, 1, 0, 0}
    };

    static boolean[][] visitado = new boolean[6][6];

    public static void main(String[] args) {

        System.out.println("===== MAPA =====");

        mostrarMapa();

        int cantidadIslas = 0;
        int islaMayor = 0;

        for (int i = 0; i < mapa.length; i++) {

            for (int j = 0; j < mapa[i].length; j++) {

                if (mapa[i][j] == 1 && !visitado[i][j]) {

                    cantidadIslas++;

                    int tamaño = recorrerIsla(i, j);

                    System.out.println("Isla " + cantidadIslas +
                            " -> Tamaño: " + tamaño);

                    if (tamaño > islaMayor) {

                        islaMayor = tamaño;

                    }

                }

            }

        }

        System.out.println("\nCantidad de islas: " + cantidadIslas);
        System.out.println("La isla más grande tiene: " + islaMayor + " celdas");

    }

    public static void mostrarMapa() {

        for (int i = 0; i < mapa.length; i++) {

            for (int j = 0; j < mapa[i].length; j++) {

                System.out.print(mapa[i][j] + " ");

            }

            System.out.println();

        }

    }

    public static int recorrerIsla(int fila, int columna) {

        if (fila < 0 || fila >= mapa.length ||
            columna < 0 || columna >= mapa[0].length) {

            return 0;

        }

        if (mapa[fila][columna] == 0 ||
            visitado[fila][columna]) {

            return 0;

        }

        visitado[fila][columna] = true;

        int tamaño = 1;

        tamaño += recorrerIsla(fila - 1, columna);
        tamaño += recorrerIsla(fila + 1, columna);
        tamaño += recorrerIsla(fila, columna - 1);
        tamaño += recorrerIsla(fila, columna + 1);

        return tamaño;

    }

}