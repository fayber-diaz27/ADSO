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

        System.out.print("Ingrese el número de zonas (filas): ");
        int filas = teclado.nextInt();

        System.out.print("Ingrese el número de puntos por zona (columnas): ");
        int columnas = teclado.nextInt();

        int[][] contaminacion = new int[filas][columnas];

        // Registrar datos
        System.out.println("\nIngrese los niveles de contaminación (0 - 100).");

        for (int i = 0; i < filas; i++) {

            System.out.println("\nZona " + (i + 1));

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Punto [" + i + "][" + j + "]: ");
                    contaminacion[i][j] = teclado.nextInt();

                    if (contaminacion[i][j] < 0 || contaminacion[i][j] > 100) {

                        System.out.println("El valor debe estar entre 0 y 100.");

                    }

                } while (contaminacion[i][j] < 0 || contaminacion[i][j] > 100);

            }

        }

        System.out.println("\n===== MATRIZ DE CONTAMINACIÓN =====");
        mostrarMatriz(contaminacion);

        analizarContaminacion(contaminacion);

        teclado.close();

    }

    // Mostrar matriz
    public static void mostrarMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + "\t");

            }

            System.out.println();

        }

    }

    // Analizar contaminación
    public static void analizarContaminacion(int[][] matriz) {

        int suma = 0;
        int total = 0;

        int baja = 0;
        int media = 0;
        int alta = 0;

        System.out.println("\n===== CLASIFICACIÓN =====");

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                int valor = matriz[i][j];

                suma += valor;
                total++;

                if (valor <= 30) {

                    System.out.println("Zona " + (i + 1)
                            + ", Punto " + (j + 1)
                            + ": Contaminación BAJA");

                    baja++;

                } else if (valor <= 70) {

                    System.out.println("Zona " + (i + 1)
                            + ", Punto " + (j + 1)
                            + ": Contaminación MEDIA");

                    media++;

                } else {

                    System.out.println("Zona " + (i + 1)
                            + ", Punto " + (j + 1)
                            + ": Contaminación ALTA");

                    alta++;

                }

            }

        }

        double promedio = (double) suma / total;

        System.out.println("\n===== REPORTE =====");
        System.out.printf("Promedio de contaminación: %.2f%n", promedio);

        System.out.println("Puntos con contaminación baja: " + baja);
        System.out.println("Puntos con contaminación media: " + media);
        System.out.println("Puntos con contaminación alta: " + alta);

        if (alta > 0) {

            System.out.println("\n⚠ ALERTA: Existen zonas con alta contaminación.");

        } else {

            System.out.println("\nNo se detectaron zonas críticas.");

        }

    }

}