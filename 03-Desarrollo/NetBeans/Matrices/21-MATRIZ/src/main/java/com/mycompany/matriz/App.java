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

        System.out.print("Ingrese el número de filas: ");
        filas = teclado.nextInt();

        System.out.print("Ingrese el número de columnas: ");
        columnas = teclado.nextInt();

        int[][] matriz = new int[filas][columnas];
        int[] vector = new int[filas * columnas];

        int indice = 0;
        int suma = 0;

        // Llenar la matriz
        System.out.println("\nIngrese los datos:");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();

                vector[indice] = matriz[i][j];
                indice++;

                suma += matriz[i][j];

            }

        }

        // Mostrar matriz
        System.out.println("\n===== MATRIZ =====");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        // Promedio
        double promedio = (double) suma / vector.length;

        // Máximo y mínimo
        int mayor = vector[0];
        int menor = vector[0];

        for (int i = 1; i < vector.length; i++) {

            if (vector[i] > mayor) {
                mayor = vector[i];
            }

            if (vector[i] < menor) {
                menor = vector[i];
            }

        }

        // Ordenar el vector (Bubble Sort)
        for (int i = 0; i < vector.length - 1; i++) {

            for (int j = 0; j < vector.length - 1 - i; j++) {

                if (vector[j] > vector[j + 1]) {

                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;

                }

            }

        }

        // Mediana
        double mediana;

        if (vector.length % 2 == 0) {

            mediana = (vector[vector.length / 2] +
                       vector[(vector.length / 2) - 1]) / 2.0;

        } else {

            mediana = vector[vector.length / 2];

        }

        // Moda
        int moda = vector[0];
        int mayorFrecuencia = 1;

        for (int i = 0; i < vector.length; i++) {

            int frecuencia = 1;

            for (int j = i + 1; j < vector.length; j++) {

                if (vector[i] == vector[j]) {

                    frecuencia++;

                }

            }

            if (frecuencia > mayorFrecuencia) {

                mayorFrecuencia = frecuencia;
                moda = vector[i];

            }

        }

        // Desviación media
        double desviacion = 0;

        for (int i = 0; i < vector.length; i++) {

            desviacion += Math.abs(vector[i] - promedio);

        }

        desviacion = desviacion / vector.length;

        // Resultados
        System.out.println("\n===== RESULTADOS =====");

        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.println("Moda: " + moda);
        System.out.printf("Mediana: %.2f\n", mediana);
        System.out.println("Valor máximo: " + mayor);
        System.out.println("Valor mínimo: " + menor);
        System.out.printf("Desviación media: %.2f\n", desviacion);

        teclado.close();

    }

}