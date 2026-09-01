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

        int[][] ciudad = {
                {1, 0, 2, 0, 1},
                {0, 3, 0, 1, 0},
                {2, 0, 1, 0, 2},
                {0, 1, 0, 3, 0},
                {1, 0, 2, 0, 1}
        };

        System.out.print("Ingrese la cantidad de ciclos: ");
        int ciclos = teclado.nextInt();

        for (int ciclo = 1; ciclo <= ciclos; ciclo++) {

            System.out.println("\n===== CICLO " + ciclo + " =====");

            moverVehiculos(ciudad);

            cambiarSemaforos(ciudad);

            mostrarCiudad(ciudad);

            contarCongestion(ciudad);

        }

        teclado.close();

    }

    // Mostrar ciudad
    public static void mostrarCiudad(int[][] ciudad) {

        System.out.println("\nCIUDAD");

        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                System.out.print(ciudad[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Movimiento de vehículos
    public static void moverVehiculos(int[][] ciudad) {

        int[][] copia = new int[ciudad.length][ciudad[0].length];

        // Copiar matriz
        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                copia[i][j] = ciudad[i][j];

            }

        }

        // Mover vehículos hacia la derecha
        for (int i = 0; i < ciudad.length; i++) {

            for (int j = ciudad[i].length - 2; j >= 0; j--) {

                if (ciudad[i][j] == 1 && ciudad[i][j + 1] == 0) {

                    copia[i][j] = 0;
                    copia[i][j + 1] = 1;

                }

            }

        }

        // Actualizar ciudad
        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                ciudad[i][j] = copia[i][j];

            }

        }

    }

    // Cambiar estado de semáforos
    public static void cambiarSemaforos(int[][] ciudad) {

        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                if (ciudad[i][j] == 2) {

                    ciudad[i][j] = 0;

                } else if (ciudad[i][j] == 0) {

                    // Solo para demostrar el cambio
                    if ((i + j) % 5 == 0) {

                        ciudad[i][j] = 2;

                    }

                }

            }

        }

    }

    // Contar vehículos
    public static void contarCongestion(int[][] ciudad) {

        int vehiculos = 0;

        for (int i = 0; i < ciudad.length; i++) {

            for (int j = 0; j < ciudad[i].length; j++) {

                if (ciudad[i][j] == 1) {

                    vehiculos++;

                }

            }

        }

        System.out.println("\nVehículos en circulación: " + vehiculos);

    }

}