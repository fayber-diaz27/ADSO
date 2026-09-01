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

        int filas, columnas;

        System.out.print("Ingrese el número de filas de la imagen: ");
        filas = teclado.nextInt();

        System.out.print("Ingrese el número de columnas de la imagen: ");
        columnas = teclado.nextInt();

        int[][] imagen = new int[filas][columnas];

        // Llenar la matriz
        System.out.println("\nIngrese los valores de la imagen (0 - 255):");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Pixel [" + i + "][" + j + "]: ");
                    imagen[i][j] = teclado.nextInt();

                    if (imagen[i][j] < 0 || imagen[i][j] > 255) {
                        System.out.println("Valor inválido. Debe estar entre 0 y 255.");
                    }

                } while (imagen[i][j] < 0 || imagen[i][j] > 255);

            }

        }

        int opcion;

        do {

            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Mostrar imagen");
            System.out.println("2. Aumentar brillo");
            System.out.println("3. Disminuir brillo");
            System.out.println("4. Invertir colores");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    mostrarImagen(imagen);

                    break;

                case 2:

                    System.out.print("¿Cuánto desea aumentar el brillo?: ");
                    int aumento = teclado.nextInt();

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            imagen[i][j] += aumento;

                            if (imagen[i][j] > 255) {
                                imagen[i][j] = 255;
                            }

                        }

                    }

                    System.out.println("Brillo aumentado.");

                    break;

                case 3:

                    System.out.print("¿Cuánto desea disminuir el brillo?: ");
                    int disminucion = teclado.nextInt();

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            imagen[i][j] -= disminucion;

                            if (imagen[i][j] < 0) {
                                imagen[i][j] = 0;
                            }

                        }

                    }

                    System.out.println("Brillo disminuido.");

                    break;

                case 4:

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            imagen[i][j] = 255 - imagen[i][j];

                        }

                    }

                    System.out.println("Colores invertidos.");

                    break;

                case 5:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 5);

        teclado.close();

    }

    public static void mostrarImagen(int[][] imagen) {

        System.out.println("\n===== IMAGEN =====");

        for (int i = 0; i < imagen.length; i++) {

            for (int j = 0; j < imagen[i].length; j++) {

                System.out.printf("%5d", imagen[i][j]);

            }

            System.out.println();

        }

    }

}