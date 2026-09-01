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

        System.out.print("Cantidad de estudiantes: ");
        int estudiantes = teclado.nextInt();

        System.out.print("Cantidad de materias: ");
        int materias = teclado.nextInt();

        double[][] notas = new double[estudiantes][materias];
        double[] promedios = new double[estudiantes];
        int[] posicion = new int[estudiantes];

        // Inicializar posiciones
        for (int i = 0; i < estudiantes; i++) {
            posicion[i] = i;
        }

        // Ingresar notas
        for (int i = 0; i < estudiantes; i++) {

            System.out.println("\nEstudiante " + (i + 1));

            for (int j = 0; j < materias; j++) {

                do {

                    System.out.print("Nota materia " + (j + 1) + ": ");
                    notas[i][j] = teclado.nextDouble();

                    if (notas[i][j] < 0 || notas[i][j] > 5) {
                        System.out.println("La nota debe estar entre 0 y 5.");
                    }

                } while (notas[i][j] < 0 || notas[i][j] > 5);

            }

        }

        System.out.println("\n===== PROMEDIOS POR ESTUDIANTE =====");

        for (int i = 0; i < estudiantes; i++) {

            double suma = 0;

            for (int j = 0; j < materias; j++) {

                suma += notas[i][j];

            }

            promedios[i] = suma / materias;

            System.out.printf("Estudiante %d: %.2f", (i + 1), promedios[i]);

            if (promedios[i] < 3.0) {
                System.out.print(" --> EN RIESGO");
            }

            System.out.println();

        }

        System.out.println("\n===== PROMEDIO POR MATERIA =====");

        for (int j = 0; j < materias; j++) {

            double suma = 0;

            for (int i = 0; i < estudiantes; i++) {

                suma += notas[i][j];

            }

            System.out.printf("Materia %d: %.2f%n", (j + 1), suma / estudiantes);

        }

        // Ordenamiento (Ranking)
        for (int i = 0; i < estudiantes - 1; i++) {

            for (int j = i + 1; j < estudiantes; j++) {

                if (promedios[j] > promedios[i]) {

                    double auxProm = promedios[i];
                    promedios[i] = promedios[j];
                    promedios[j] = auxProm;

                    int auxPos = posicion[i];
                    posicion[i] = posicion[j];
                    posicion[j] = auxPos;

                }

            }

        }

        System.out.println("\n===== RANKING =====");

        for (int i = 0; i < estudiantes; i++) {

            System.out.printf("%d. Estudiante %d -> %.2f%n",
                    (i + 1),
                    (posicion[i] + 1),
                    promedios[i]);

        }

        teclado.close();

    }

}