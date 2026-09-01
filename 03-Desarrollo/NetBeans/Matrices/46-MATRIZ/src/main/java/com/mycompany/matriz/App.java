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

        System.out.print("Ingrese el número de filas: ");
        int filas = teclado.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        int columnas = teclado.nextInt();

        int[][] red = new int[filas][columnas];

        System.out.println("\nEstados:");
        System.out.println("0 = Corte");
        System.out.println("1 = Energía normal");
        System.out.println("2 = Sobrecarga");

        // Ingreso de datos
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Sector [" + i + "][" + j + "]: ");
                    red[i][j] = teclado.nextInt();

                    if (red[i][j] < 0 || red[i][j] > 2) {

                        System.out.println("Solo puede ingresar 0, 1 o 2.");

                    }

                } while (red[i][j] < 0 || red[i][j] > 2);

            }

        }

        System.out.println("\n===== RED ELÉCTRICA =====");
        mostrarRed(red);

        propagarFallos(red);

        System.out.println("\n===== RED DESPUÉS DE LA PROPAGACIÓN =====");
        mostrarRed(red);

        mostrarEstadisticas(red);

        teclado.close();

    }

    // Mostrar matriz
    public static void mostrarRed(int[][] red) {

        for (int i = 0; i < red.length; i++) {

            for (int j = 0; j < red[i].length; j++) {

                System.out.print(red[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Propagar fallos
    public static void propagarFallos(int[][] red) {

        int filas = red.length;
        int columnas = red[0].length;

        int[][] copia = new int[filas][columnas];

        // Copiar la matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                copia[i][j] = red[i][j];

            }

        }

        // Si existe una sobrecarga, provoca cortes en sus vecinos
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (red[i][j] == 2) {

                    if (i > 0 && red[i - 1][j] == 1)
                        copia[i - 1][j] = 0;

                    if (i < filas - 1 && red[i + 1][j] == 1)
                        copia[i + 1][j] = 0;

                    if (j > 0 && red[i][j - 1] == 1)
                        copia[i][j - 1] = 0;

                    if (j < columnas - 1 && red[i][j + 1] == 1)
                        copia[i][j + 1] = 0;

                }

            }

        }

        // Actualizar la matriz original
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                red[i][j] = copia[i][j];

            }

        }

    }

    // Mostrar estadísticas
    public static void mostrarEstadisticas(int[][] red) {

        int normal = 0;
        int cortes = 0;
        int sobrecargas = 0;

        for (int i = 0; i < red.length; i++) {

            for (int j = 0; j < red[i].length; j++) {

                switch (red[i][j]) {

                    case 0:
                        cortes++;
                        break;

                    case 1:
                        normal++;
                        break;

                    case 2:
                        sobrecargas++;
                        break;

                }

            }

        }

        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Sectores con energía: " + normal);
        System.out.println("Sectores sin energía: " + cortes);
        System.out.println("Sectores con sobrecarga: " + sobrecargas);

    }

}