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

    static int filas;
    static int columnas;
    static int[][] imagen;
    static boolean[][] visitado;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el número de filas: ");
        filas = teclado.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        columnas = teclado.nextInt();

        imagen = new int[filas][columnas];
        visitado = new boolean[filas][columnas];

        System.out.println("\nIngrese la imagen (solo 0 y 1)");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Posición [" + i + "][" + j + "]: ");
                    imagen[i][j] = teclado.nextInt();

                    if (imagen[i][j] != 0 && imagen[i][j] != 1) {

                        System.out.println("Solo puede ingresar 0 o 1.");

                    }

                } while (imagen[i][j] != 0 && imagen[i][j] != 1);

            }

        }

        System.out.println("\n===== IMAGEN =====");
        mostrarImagen();

        int pixelesActivos = contarPixeles();

        System.out.println("\nPíxeles activos: " + pixelesActivos);

        int regiones = 0;
        int mayorRegion = 0;

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (imagen[i][j] == 1 && !visitado[i][j]) {

                    regiones++;

                    int tamaño = recorrerRegion(i, j);

                    System.out.println("Región " + regiones +
                            " -> Tamaño: " + tamaño);

                    if (tamaño > mayorRegion) {

                        mayorRegion = tamaño;

                    }

                }

            }

        }

        System.out.println("\nTotal de regiones: " + regiones);
        System.out.println("Región más grande: " + mayorRegion + " píxeles");

        teclado.close();

    }

    public static void mostrarImagen() {

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.print(imagen[i][j] + " ");

            }

            System.out.println();

        }

    }

    public static int contarPixeles() {

        int contador = 0;

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (imagen[i][j] == 1) {

                    contador++;

                }

            }

        }

        return contador;

    }

    public static int recorrerRegion(int fila, int columna) {

        if (fila < 0 || fila >= filas ||
            columna < 0 || columna >= columnas) {

            return 0;

        }

        if (imagen[fila][columna] == 0 ||
            visitado[fila][columna]) {

            return 0;

        }

        visitado[fila][columna] = true;

        int tamaño = 1;

        tamaño += recorrerRegion(fila - 1, columna);
        tamaño += recorrerRegion(fila + 1, columna);
        tamaño += recorrerRegion(fila, columna - 1);
        tamaño += recorrerRegion(fila, columna + 1);

        return tamaño;

    }

}