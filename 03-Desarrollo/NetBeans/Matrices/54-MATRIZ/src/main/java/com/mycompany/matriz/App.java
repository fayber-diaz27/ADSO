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

        System.out.print("Número de filas de la imagen: ");
        int filas = teclado.nextInt();

        System.out.print("Número de columnas de la imagen: ");
        int columnas = teclado.nextInt();

        int[][] imagen = new int[filas][columnas];

        System.out.println("\nIngrese los valores de los píxeles:");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Pixel [" + i + "][" + j + "]: ");
                    imagen[i][j] = teclado.nextInt();

                    if (imagen[i][j] < 0) {
                        System.out.println("El valor no puede ser negativo.");
                    }

                } while (imagen[i][j] < 0);

            }

        }

        System.out.println("\n===== IMAGEN ORIGINAL =====");

        mostrarImagen(imagen);

        int bloques = contarBloques(imagen);

        int totalBloques = (filas - 1) * (columnas - 1);

        double porcentaje = (double) bloques * 100 / totalBloques;

        System.out.println("\nBloques repetidos: " + bloques);

        System.out.printf("Compresión aproximada: %.2f%%\n", porcentaje);

        teclado.close();

    }

    // Mostrar imagen
    public static void mostrarImagen(int[][] imagen) {

        for (int i = 0; i < imagen.length; i++) {

            for (int j = 0; j < imagen[i].length; j++) {

                System.out.print(imagen[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Contar bloques repetidos de 2x2
    public static int contarBloques(int[][] imagen) {

        int contador = 0;

        for (int i = 0; i < imagen.length - 1; i++) {

            for (int j = 0; j < imagen[i].length - 1; j++) {

                int valor = imagen[i][j];

                if (imagen[i][j + 1] == valor &&
                    imagen[i + 1][j] == valor &&
                    imagen[i + 1][j + 1] == valor) {

                    contador++;

                }

            }

        }

        return contador;

    }

}