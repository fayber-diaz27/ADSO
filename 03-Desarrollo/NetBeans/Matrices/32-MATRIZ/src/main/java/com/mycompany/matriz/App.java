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

        int sucursales;
        int transacciones;

        System.out.print("Ingrese la cantidad de sucursales: ");
        sucursales = teclado.nextInt();

        System.out.print("Ingrese la cantidad de transacciones por sucursal: ");
        transacciones = teclado.nextInt();

        double[][] banco = new double[sucursales][transacciones];

        // Ingreso de datos
        for (int i = 0; i < sucursales; i++) {

            System.out.println("\nSucursal " + (i + 1));

            for (int j = 0; j < transacciones; j++) {

                double monto;

                do {

                    System.out.print("Transacción " + (j + 1) + ": ");
                    monto = teclado.nextDouble();

                    if (monto < 0 || monto > 1000000) {
                        System.out.println("Monto inválido. Debe estar entre 0 y 1.000.000.");
                    }

                } while (monto < 0 || monto > 1000000);

                banco[i][j] = monto;

            }

        }

        // Mostrar matriz
        System.out.println("\n===== TRANSACCIONES =====");

        for (int i = 0; i < sucursales; i++) {

            System.out.print("Sucursal " + (i + 1) + ": ");

            for (int j = 0; j < transacciones; j++) {

                System.out.printf("%10.2f", banco[i][j]);

            }

            System.out.println();

        }

        double mayorIngreso = 0;
        int mejorSucursal = 0;

        // Calcular estadísticas
        for (int i = 0; i < sucursales; i++) {

            double suma = 0;

            for (int j = 0; j < transacciones; j++) {

                suma += banco[i][j];

            }

            double promedio = suma / transacciones;

            System.out.println("\nSucursal " + (i + 1));
            System.out.println("Total: $" + suma);
            System.out.println("Promedio: $" + promedio);

            if (suma > mayorIngreso) {

                mayorIngreso = suma;
                mejorSucursal = i;

            }

        }

        // Buscar transacciones sospechosas
        System.out.println("\n===== TRANSACCIONES SOSPECHOSAS =====");

        boolean encontrada = false;

        for (int i = 0; i < sucursales; i++) {

            for (int j = 0; j < transacciones; j++) {

                if (banco[i][j] > 10000) {

                    System.out.println(
                            "Sucursal " + (i + 1) +
                            ", Transacción " + (j + 1) +
                            ": $" + banco[i][j]);

                    encontrada = true;

                }

            }

        }

        if (!encontrada) {

            System.out.println("No se encontraron transacciones sospechosas.");

        }

        System.out.println("\nSucursal con mayores ingresos: " + (mejorSucursal + 1));
        System.out.println("Total de ingresos: $" + mayorIngreso);

        teclado.close();

    }

}