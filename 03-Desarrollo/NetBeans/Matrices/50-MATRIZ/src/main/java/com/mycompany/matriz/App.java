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

        System.out.print("Número de filas: ");
        int filas = teclado.nextInt();

        System.out.print("Número de columnas: ");
        int columnas = teclado.nextInt();

        int[][] red = new int[filas][columnas];

        System.out.println("\nEstados:");
        System.out.println("0 = No conoce la noticia");
        System.out.println("1 = Conoce la noticia");
        System.out.println("2 = Persona aislada");

        // Ingreso de datos
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Posición [" + i + "][" + j + "]: ");
                    red[i][j] = teclado.nextInt();

                    if (red[i][j] < 0 || red[i][j] > 2) {
                        System.out.println("Solo puede ingresar 0, 1 o 2.");
                    }

                } while (red[i][j] < 0 || red[i][j] > 2);

            }

        }

        System.out.print("\n¿Cuántos ciclos desea simular?: ");
        int ciclos = teclado.nextInt();

        for (int c = 1; c <= ciclos; c++) {

            System.out.println("\n===== CICLO " + c + " =====");

            propagar(red);

            mostrarRed(red);

            mostrarEstadisticas(red);

        }

        teclado.close();

    }

    // Propagar la noticia
    public static void propagar(int[][] red) {

        int filas = red.length;
        int columnas = red[0].length;

        int[][] copia = new int[filas][columnas];

        // Copiar matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                copia[i][j] = red[i][j];

            }

        }

        // Propagación
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (red[i][j] == 1) {

                    if (i > 0 && red[i - 1][j] == 0)
                        copia[i - 1][j] = 1;

                    if (i < filas - 1 && red[i + 1][j] == 0)
                        copia[i + 1][j] = 1;

                    if (j > 0 && red[i][j - 1] == 0)
                        copia[i][j - 1] = 1;

                    if (j < columnas - 1 && red[i][j + 1] == 0)
                        copia[i][j + 1] = 1;

                }

            }

        }

        // Actualizar matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                red[i][j] = copia[i][j];

            }

        }

    }

    // Mostrar red
    public static void mostrarRed(int[][] red) {

        System.out.println("\nEstado de la red:");

        for (int i = 0; i < red.length; i++) {

            for (int j = 0; j < red[i].length; j++) {

                System.out.print(red[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Mostrar estadísticas
    public static void mostrarEstadisticas(int[][] red) {

        int informadas = 0;
        int sinInformar = 0;
        int aisladas = 0;

        for (int i = 0; i < red.length; i++) {

            for (int j = 0; j < red[i].length; j++) {

                switch (red[i][j]) {

                    case 0:
                        sinInformar++;
                        break;

                    case 1:
                        informadas++;
                        break;

                    case 2:
                        aisladas++;
                        break;

                }

            }

        }

        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Personas informadas: " + informadas);
        System.out.println("Personas sin informar: " + sinInformar);
        System.out.println("Personas aisladas: " + aisladas);

    }

}