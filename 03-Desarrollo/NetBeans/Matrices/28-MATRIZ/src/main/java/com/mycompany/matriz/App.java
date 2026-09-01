/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz;

/**
 *
 * @author diazf
 */
public class App {

    static int[][] matriz = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1},
            {0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1}
    };

    static boolean[][] visitado = new boolean[5][5];

    public static void main(String[] args) {

        System.out.println("MATRIZ");

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + " ");

            }

            System.out.println();

        }

        int cantidadIslas = 0;

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == 1 && !visitado[i][j]) {

                    buscarIsla(i, j);
                    cantidadIslas++;

                }

            }

        }

        System.out.println("\nCantidad de islas: " + cantidadIslas);

    }

    public static void buscarIsla(int fila, int columna) {

        // Verificar límites
        if (fila < 0 || fila >= matriz.length ||
            columna < 0 || columna >= matriz[0].length) {

            return;

        }

        // Si es agua o ya fue visitada
        if (matriz[fila][columna] == 0 || visitado[fila][columna]) {

            return;

        }

        // Marcar como visitada
        visitado[fila][columna] = true;

        // Buscar en las cuatro direcciones
        buscarIsla(fila - 1, columna); // Arriba
        buscarIsla(fila + 1, columna); // Abajo
        buscarIsla(fila, columna - 1); // Izquierda
        buscarIsla(fila, columna + 1); // Derecha

    }

}