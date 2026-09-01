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

        final int APRENDICES = 10;
        final int COMPETENCIAS = 5;

        double[][] notas = new double[APRENDICES][COMPETENCIAS];

        
        System.out.println("===== REGISTRO DE NOTAS =====");

        for (int i = 0; i < APRENDICES; i++) {

            System.out.println("\nAprendiz " + (i + 1));

            for (int j = 0; j < COMPETENCIAS; j++) {

                do {
                    System.out.print("Competencia " + (j + 1) + ": ");
                    notas[i][j] = teclado.nextDouble();

                } while (notas[i][j] < 0 || notas[i][j] > 5);

            }
        }

        
        System.out.println("\n===== MATRIZ DE NOTAS =====");

        for (int i = 0; i < APRENDICES; i++) {

            System.out.print("Aprendiz " + (i + 1) + ": ");

            for (int j = 0; j < COMPETENCIAS; j++) {

                System.out.printf("%.1f ", notas[i][j]);

            }

            System.out.println();

        }

        
        System.out.println("\n===== PROMEDIO POR APRENDIZ =====");

        for (int i = 0; i < APRENDICES; i++) {

            double suma = 0;

            for (int j = 0; j < COMPETENCIAS; j++) {

                suma += notas[i][j];

            }

            double promedio = suma / COMPETENCIAS;

            System.out.printf("Aprendiz %d: %.2f\n", (i + 1), promedio);

        }

        
        System.out.println("\n===== PROMEDIO POR COMPETENCIA =====");

        for (int j = 0; j < COMPETENCIAS; j++) {

            double suma = 0;

            for (int i = 0; i < APRENDICES; i++) {

                suma += notas[i][j];

            }

            double promedio = suma / APRENDICES;

            System.out.printf("Competencia %d: %.2f\n", (j + 1), promedio);

        }

        
        double mayor = notas[0][0];
        double menor = notas[0][0];

        for (int i = 0; i < APRENDICES; i++) {

            for (int j = 0; j < COMPETENCIAS; j++) {

                if (notas[i][j] > mayor) {
                    mayor = notas[i][j];
                }

                if (notas[i][j] < menor) {
                    menor = notas[i][j];
                }

            }

        }

        System.out.println("\nNota más alta: " + mayor);
        System.out.println("Nota más baja: " + menor);

        
        System.out.println("\n===== APRENDICES EN RIESGO =====");

        boolean existe = false;

        for (int i = 0; i < APRENDICES; i++) {

            double suma = 0;

            for (int j = 0; j < COMPETENCIAS; j++) {

                suma += notas[i][j];

            }

            double promedio = suma / COMPETENCIAS;

            if (promedio < 3.0) {

                System.out.printf("Aprendiz %d -> Promedio: %.2f\n",
                        (i + 1), promedio);

                existe = true;

            }

        }

        if (!existe) {

            System.out.println("No hay aprendices en riesgo.");

        }

        teclado.close();

    }

}
