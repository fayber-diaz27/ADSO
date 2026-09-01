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

        final int DIAS = 7;
        final int DATOS = 3;

        double[][] clima = new double[DIAS][DATOS];

        System.out.println("Ingrese los datos climáticos:");

        for (int i = 0; i < DIAS; i++) {

            System.out.println("\nDía " + (i + 1));

            // Temperatura
            do {
                System.out.print("Temperatura (°C): ");
                clima[i][0] = teclado.nextDouble();

                if (clima[i][0] < -50 || clima[i][0] > 60) {
                    System.out.println("Temperatura inválida.");
                }

            } while (clima[i][0] < -50 || clima[i][0] > 60);

            // Humedad
            do {
                System.out.print("Humedad (%): ");
                clima[i][1] = teclado.nextDouble();

                if (clima[i][1] < 0 || clima[i][1] > 100) {
                    System.out.println("Humedad inválida.");
                }

            } while (clima[i][1] < 0 || clima[i][1] > 100);

            // Presión
            do {
                System.out.print("Presión (hPa): ");
                clima[i][2] = teclado.nextDouble();

                if (clima[i][2] < 850 || clima[i][2] > 1100) {
                    System.out.println("Presión inválida.");
                }

            } while (clima[i][2] < 850 || clima[i][2] > 1100);

        }

        System.out.println("\n===== DATOS CLIMÁTICOS =====");
        System.out.println("Día\tTemp\tHum\tPresión");

        for (int i = 0; i < DIAS; i++) {

            System.out.printf("%d\t%.1f\t%.1f\t%.1f%n",
                    (i + 1),
                    clima[i][0],
                    clima[i][1],
                    clima[i][2]);

        }

        double sumaTemp = 0;
        double sumaHum = 0;
        double sumaPresion = 0;

        for (int i = 0; i < DIAS; i++) {

            sumaTemp += clima[i][0];
            sumaHum += clima[i][1];
            sumaPresion += clima[i][2];

        }

        System.out.println("\n===== PROMEDIOS =====");

        System.out.printf("Temperatura: %.2f °C%n", sumaTemp / DIAS);
        System.out.printf("Humedad: %.2f %% %n", sumaHum / DIAS);
        System.out.printf("Presión: %.2f hPa%n", sumaPresion / DIAS);

        System.out.println("\n===== ALERTAS =====");

        for (int i = 0; i < DIAS; i++) {

            if (clima[i][1] >= 80 && clima[i][2] <= 1000) {

                System.out.println("Posible tormenta el día " + (i + 1));

            }

        }

        System.out.println("\n===== CAMBIOS BRUSCOS =====");

        for (int i = 1; i < DIAS; i++) {

            if (Math.abs(clima[i][0] - clima[i - 1][0]) >= 10) {

                System.out.println("Cambio brusco entre el día "
                        + i + " y " + (i + 1));

            }

        }

        teclado.close();

    }

}