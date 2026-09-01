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

        System.out.print("Ingrese la cantidad de usuarios: ");
        int usuarios = teclado.nextInt();

        System.out.print("Ingrese la cantidad de productos: ");
        int productos = teclado.nextInt();

        int[][] calificaciones = new int[usuarios][productos];

        System.out.println("\nIngrese las calificaciones (1 a 5).");

        // Registrar calificaciones
        for (int i = 0; i < usuarios; i++) {

            System.out.println("\nUsuario " + (i + 1));

            for (int j = 0; j < productos; j++) {

                do {

                    System.out.print("Producto " + (j + 1) + ": ");
                    calificaciones[i][j] = teclado.nextInt();

                    if (calificaciones[i][j] < 1 || calificaciones[i][j] > 5) {

                        System.out.println("La calificación debe estar entre 1 y 5.");

                    }

                } while (calificaciones[i][j] < 1 || calificaciones[i][j] > 5);

            }

        }

        System.out.println("\n===== MATRIZ DE CALIFICACIONES =====");
        mostrarMatriz(calificaciones);

        double mejorPromedio = 0;
        int mejorProducto = 0;

        System.out.println("\n===== PROMEDIO POR PRODUCTO =====");

        for (int j = 0; j < productos; j++) {

            int suma = 0;

            for (int i = 0; i < usuarios; i++) {

                suma += calificaciones[i][j];

            }

            double promedio = (double) suma / usuarios;

            System.out.printf("Producto %d: %.2f\n", (j + 1), promedio);

            if (promedio > mejorPromedio) {

                mejorPromedio = promedio;
                mejorProducto = j;

            }

        }

        System.out.println("\n===== RECOMENDACIÓN =====");
        System.out.println("Se recomienda el Producto " + (mejorProducto + 1));
        System.out.printf("Promedio obtenido: %.2f\n", mejorPromedio);

        teclado.close();

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

}