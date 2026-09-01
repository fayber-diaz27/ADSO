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

        int filas = 6;
        int columnas = 6;

        int[][] ecosistema = {
                {0, 1, 0, 2, 0, 1},
                {1, 0, 1, 0, 2, 0},
                {0, 2, 0, 1, 0, 1},
                {1, 0, 2, 0, 1, 0},
                {0, 1, 0, 1, 0, 2},
                {2, 0, 1, 0, 1, 0}
        };

        System.out.print("Ingrese la cantidad de ciclos: ");
        int ciclos = teclado.nextInt();

        for (int ciclo = 1; ciclo <= ciclos; ciclo++) {

            System.out.println("\n===== CICLO " + ciclo + " =====");

            int[][] nuevo = new int[filas][columnas];

            // Copiar la matriz
            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    nuevo[i][j] = ecosistema[i][j];

                }

            }

            // Simulación
            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    // PRESA
                    if (ecosistema[i][j] == 1) {

                        // Se reproduce hacia la derecha si está libre
                        if (j + 1 < columnas && ecosistema[i][j + 1] == 0) {

                            nuevo[i][j + 1] = 1;

                        }

                    }

                    // DEPREDADOR
                    if (ecosistema[i][j] == 2) {

                        boolean comio = false;

                        // Arriba
                        if (i > 0 && ecosistema[i - 1][j] == 1) {

                            nuevo[i - 1][j] = 2;
                            comio = true;

                        }

                        // Abajo
                        else if (i < filas - 1 && ecosistema[i + 1][j] == 1) {

                            nuevo[i + 1][j] = 2;
                            comio = true;

                        }

                        // Izquierda
                        else if (j > 0 && ecosistema[i][j - 1] == 1) {

                            nuevo[i][j - 1] = 2;
                            comio = true;

                        }

                        // Derecha
                        else if (j < columnas - 1 && ecosistema[i][j + 1] == 1) {

                            nuevo[i][j + 1] = 2;
                            comio = true;

                        }

                        // Si no encontró comida, muere
                        if (!comio) {

                            nuevo[i][j] = 0;

                        }

                    }

                }

            }

            ecosistema = nuevo;

            mostrarEcosistema(ecosistema);

            mostrarEstadisticas(ecosistema);

        }

        teclado.close();

    }

    // Mostrar matriz
    public static void mostrarEcosistema(int[][] matriz) {

        System.out.println("\nECOSISTEMA");

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Contar especies
    public static void mostrarEstadisticas(int[][] matriz) {

        int vacios = 0;
        int presas = 0;
        int depredadores = 0;

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                switch (matriz[i][j]) {

                    case 0:
                        vacios++;
                        break;

                    case 1:
                        presas++;
                        break;

                    case 2:
                        depredadores++;
                        break;

                }

            }

        }

        System.out.println("\nEspacios vacíos: " + vacios);
        System.out.println("Presas: " + presas);
        System.out.println("Depredadores: " + depredadores);

    }

}