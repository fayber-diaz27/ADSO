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

        int[][] ciudad = {
                {0, 0, 0, 3, 0, 0},
                {0, 1, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 0},
                {3, 0, 1, 0, 0, 0},
                {0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        System.out.print("Ingrese la cantidad de ciclos: ");
        int ciclos = teclado.nextInt();

        for (int ciclo = 1; ciclo <= ciclos; ciclo++) {

            System.out.println("\n===== CICLO " + ciclo + " =====");

            int[][] nuevaCiudad = new int[filas][columnas];

            // Copiar la matriz
            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    nuevaCiudad[i][j] = ciudad[i][j];

                }

            }

            // Simulación
            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    if (ciudad[i][j] == 1) {

                        // Contagiar arriba
                        if (i > 0 && ciudad[i - 1][j] == 0)
                            nuevaCiudad[i - 1][j] = 1;

                        // Contagiar abajo
                        if (i < filas - 1 && ciudad[i + 1][j] == 0)
                            nuevaCiudad[i + 1][j] = 1;

                        // Contagiar izquierda
                        if (j > 0 && ciudad[i][j - 1] == 0)
                            nuevaCiudad[i][j - 1] = 1;

                        // Contagiar derecha
                        if (j < columnas - 1 && ciudad[i][j + 1] == 0)
                            nuevaCiudad[i][j + 1] = 1;

                        // Recuperación o fallecimiento
                        int numero = (int) (Math.random() * 100);

                        if (numero < 60) {

                            nuevaCiudad[i][j] = 2; // Recuperado

                        } else {

                            nuevaCiudad[i][j] = 4; // Fallecido

                        }

                    }

                }

            }

            ciudad = nuevaCiudad;

            mostrarCiudad(ciudad);

            mostrarEstadisticas(ciudad);

        }

        teclado.close();

    }

    public static void mostrarCiudad(int[][] ciudad) {

        System.out.println("\nESTADO DE LA CIUDAD");

        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                System.out.print(ciudad[i][j] + " ");

            }

            System.out.println();

        }

    }

    public static void mostrarEstadisticas(int[][] ciudad) {

        int sanos = 0;
        int infectados = 0;
        int recuperados = 0;
        int vacunados = 0;
        int fallecidos = 0;

        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                switch (ciudad[i][j]) {

                    case 0:
                        sanos++;
                        break;

                    case 1:
                        infectados++;
                        break;

                    case 2:
                        recuperados++;
                        break;

                    case 3:
                        vacunados++;
                        break;

                    case 4:
                        fallecidos++;
                        break;

                }

            }

        }

        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Sanos: " + sanos);
        System.out.println("Infectados: " + infectados);
        System.out.println("Recuperados: " + recuperados);
        System.out.println("Vacunados: " + vacunados);
        System.out.println("Fallecidos: " + fallecidos);

    }

}