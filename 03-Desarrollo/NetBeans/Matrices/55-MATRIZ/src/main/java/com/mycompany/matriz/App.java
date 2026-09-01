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

        int[][] ciudad = new int[filas][columnas];

        System.out.println("\nEstados:");
        System.out.println("0 = Espacio libre");
        System.out.println("1 = Persona");
        System.out.println("2 = Obstáculo");

        // Ingreso de datos
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Posición [" + i + "][" + j + "]: ");
                    ciudad[i][j] = teclado.nextInt();

                    if (ciudad[i][j] < 0 || ciudad[i][j] > 2) {

                        System.out.println("Solo puede ingresar 0, 1 o 2.");

                    }

                } while (ciudad[i][j] < 0 || ciudad[i][j] > 2);

            }

        }

        System.out.println("\n===== CIUDAD INICIAL =====");
        mostrarCiudad(ciudad);

        moverPersonas(ciudad);

        detectarAglomeraciones(ciudad);

        System.out.println("\n===== CIUDAD DESPUÉS DEL MOVIMIENTO =====");
        mostrarCiudad(ciudad);

        mostrarEstadisticas(ciudad);

        teclado.close();

    }

    // Mostrar matriz
    public static void mostrarCiudad(int[][] ciudad) {

        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                System.out.print(ciudad[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Mover personas una posición hacia la derecha si está libre
    public static void moverPersonas(int[][] ciudad) {

        int filas = ciudad.length;
        int columnas = ciudad[0].length;

        int[][] copia = new int[filas][columnas];

        // Copiar matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                copia[i][j] = ciudad[i][j];

            }

        }

        for (int i = 0; i < filas; i++) {

            for (int j = columnas - 2; j >= 0; j--) {

                if (ciudad[i][j] == 1 && ciudad[i][j + 1] == 0) {

                    copia[i][j] = 0;
                    copia[i][j + 1] = 1;

                }

            }

        }

        // Actualizar matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                ciudad[i][j] = copia[i][j];

            }

        }

    }

    // Detectar aglomeraciones
    public static void detectarAglomeraciones(int[][] ciudad) {

        int filas = ciudad.length;
        int columnas = ciudad[0].length;

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (ciudad[i][j] == 1) {

                    int vecinos = 0;

                    if (i > 0 && ciudad[i - 1][j] == 1)
                        vecinos++;

                    if (i < filas - 1 && ciudad[i + 1][j] == 1)
                        vecinos++;

                    if (j > 0 && ciudad[i][j - 1] == 1)
                        vecinos++;

                    if (j < columnas - 1 && ciudad[i][j + 1] == 1)
                        vecinos++;

                    if (vecinos >= 2) {

                        ciudad[i][j] = 3;

                    }

                }

            }

        }

    }

    // Mostrar estadísticas
    public static void mostrarEstadisticas(int[][] ciudad) {

        int libres = 0;
        int personas = 0;
        int obstaculos = 0;
        int aglomeraciones = 0;

        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                switch (ciudad[i][j]) {

                    case 0:
                        libres++;
                        break;

                    case 1:
                        personas++;
                        break;

                    case 2:
                        obstaculos++;
                        break;

                    case 3:
                        aglomeraciones++;
                        break;

                }

            }

        }

        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Espacios libres: " + libres);
        System.out.println("Personas: " + personas);
        System.out.println("Obstáculos: " + obstaculos);
        System.out.println("Aglomeraciones: " + aglomeraciones);

    }

}