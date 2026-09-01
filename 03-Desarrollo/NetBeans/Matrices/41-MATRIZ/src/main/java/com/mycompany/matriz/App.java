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

        System.out.print("Cantidad de productos: ");
        int productos = teclado.nextInt();

        System.out.print("Cantidad de bodegas: ");
        int bodegas = teclado.nextInt();

        int[][] inventario = new int[productos][bodegas];

        // Ingreso de datos
        for (int i = 0; i < productos; i++) {

            System.out.println("\nProducto " + (i + 1));

            for (int j = 0; j < bodegas; j++) {

                do {

                    System.out.print("Cantidad en bodega " + (j + 1) + ": ");
                    inventario[i][j] = teclado.nextInt();

                    if (inventario[i][j] < 0) {
                        System.out.println("No se permiten cantidades negativas.");
                    }

                } while (inventario[i][j] < 0);

            }

        }

        // Mostrar matriz
        System.out.println("\n===== INVENTARIO =====");

        for (int i = 0; i < productos; i++) {

            for (int j = 0; j < bodegas; j++) {

                System.out.printf("%6d", inventario[i][j]);

            }

            System.out.println();

        }

        // Inventario total por producto
        System.out.println("\n===== INVENTARIO POR PRODUCTO =====");

        for (int i = 0; i < productos; i++) {

            int total = 0;

            for (int j = 0; j < bodegas; j++) {

                total += inventario[i][j];

            }

            System.out.println("Producto " + (i + 1) + ": " + total);

            if (total < 20) {

                System.out.println("   -> FALTANTE");

            }

            if (total > 100) {

                System.out.println("   -> SOBRESTOCK");

            }

        }

        // Inventario por bodega
        System.out.println("\n===== INVENTARIO POR BODEGA =====");

        for (int j = 0; j < bodegas; j++) {

            int total = 0;

            for (int i = 0; i < productos; i++) {

                total += inventario[i][j];

            }

            System.out.println("Bodega " + (j + 1) + ": " + total);

            if (total < 50) {

                System.out.println("   -> BODEGA CRÍTICA");

            }

        }

        teclado.close();

    }

}