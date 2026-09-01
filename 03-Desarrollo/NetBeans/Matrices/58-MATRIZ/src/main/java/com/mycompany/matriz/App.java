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

        int[][] semaforos = new int[filas][columnas];

        System.out.println("\nEstados:");
        System.out.println("0 = Rojo");
        System.out.println("1 = Verde");
        System.out.println("2 = Congestión");
        System.out.println("3 = Emergencia");

        // Llenar la matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Semáforo [" + i + "][" + j + "]: ");
                    semaforos[i][j] = teclado.nextInt();

                    if (semaforos[i][j] < 0 || semaforos[i][j] > 3) {
                        System.out.println("Solo puede ingresar valores entre 0 y 3.");
                    }

                } while (semaforos[i][j] < 0 || semaforos[i][j] > 3);

            }

        }

        System.out.println("\n===== RED INICIAL =====");
        mostrarMatriz(semaforos);

        actualizarSemaforos(semaforos);

        System.out.println("\n===== RED ACTUALIZADA =====");
        mostrarMatriz(semaforos);

        mostrarEstadisticas(semaforos);

        teclado.close();
    }

    // Actualizar estados
    public static void actualizarSemaforos(int[][] semaforos) {

        for (int i = 0; i < semaforos.length; i++) {

            for (int j = 0; j < semaforos[i].length; j++) {

                if (semaforos[i][j] == 0) {

                    // Rojo pasa a verde
                    semaforos[i][j] = 1;

                } else if (semaforos[i][j] == 1) {

                    // Verde pasa a rojo
                    semaforos[i][j] = 0;

                } else if (semaforos[i][j] == 2) {

                    // Congestión: cambiar a verde
                    semaforos[i][j] = 1;

                } else if (semaforos[i][j] == 3) {

                    // Emergencia: mantener prioridad
                    semaforos[i][j] = 3;

                }

            }

        }

    }

    // Mostrar matriz
    public static void mostrarMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Mostrar estadísticas
    public static void mostrarEstadisticas(int[][] semaforos) {

        int rojos = 0;
        int verdes = 0;
        int congestion = 0;
        int emergencia = 0;

        for (int i = 0; i < semaforos.length; i++) {

            for (int j = 0; j < semaforos[i].length; j++) {

                switch (semaforos[i][j]) {

                    case 0:
                        rojos++;
                        break;

                    case 1:
                        verdes++;
                        break;

                    case 2:
                        congestion++;
                        break;

                    case 3:
                        emergencia++;
                        break;

                }

            }

        }

        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Semáforos en rojo: " + rojos);
        System.out.println("Semáforos en verde: " + verdes);
        System.out.println("Congestiones: " + congestion);
        System.out.println("Prioridades de emergencia: " + emergencia);

    }

}