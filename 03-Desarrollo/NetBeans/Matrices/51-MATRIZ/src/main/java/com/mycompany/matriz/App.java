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

        System.out.print("Cantidad de máquinas: ");
        int maquinas = teclado.nextInt();

        System.out.print("Cantidad de sensores por máquina: ");
        int sensores = teclado.nextInt();

        double[][] datos = new double[maquinas][sensores];

        System.out.println("\nIngrese los valores de los sensores.");

        for (int i = 0; i < maquinas; i++) {

            System.out.println("\nMáquina " + (i + 1));

            for (int j = 0; j < sensores; j++) {

                System.out.print("Sensor " + (j + 1) + ": ");
                datos[i][j] = teclado.nextDouble();

            }

        }

        System.out.println("\n===== LECTURAS =====");

        for (int i = 0; i < maquinas; i++) {

            for (int j = 0; j < sensores; j++) {

                System.out.printf("%8.2f", datos[i][j]);

            }

            System.out.println();

        }

        int normales = 0;
        int fueraRango = 0;
        int fallos = 0;

        System.out.println("\n===== ALERTAS =====");

        for (int i = 0; i < maquinas; i++) {

            for (int j = 0; j < sensores; j++) {

                // -1 representa un sensor dañado
                if (datos[i][j] == -1) {

                    System.out.println("Fallo en Máquina "
                            + (i + 1)
                            + ", Sensor "
                            + (j + 1));

                    fallos++;

                }
                // Valores fuera del rango permitido
                else if (datos[i][j] < 0 || datos[i][j] > 100) {

                    System.out.println("Valor fuera de rango en Máquina "
                            + (i + 1)
                            + ", Sensor "
                            + (j + 1));

                    fueraRango++;

                }
                else {

                    normales++;

                }

            }

        }

        System.out.println("\n===== ESTADÍSTICAS =====");

        System.out.println("Sensores normales: " + normales);
        System.out.println("Sensores fuera de rango: " + fueraRango);
        System.out.println("Sensores con fallo: " + fallos);

        teclado.close();

    }

}