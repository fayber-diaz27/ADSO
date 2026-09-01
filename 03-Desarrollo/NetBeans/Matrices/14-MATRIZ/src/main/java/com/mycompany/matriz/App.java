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

        int productos, sucursales;

        System.out.print("Ingrese la cantidad de productos: ");
        productos = teclado.nextInt();

        System.out.print("Ingrese la cantidad de sucursales: ");
        sucursales = teclado.nextInt();

        int[][] inventario = new int[productos][sucursales];

        // Registrar inventario
        System.out.println("\n===== REGISTRO DE INVENTARIO =====");

        for (int i = 0; i < productos; i++) {

            System.out.println("\nProducto " + (i + 1));

            for (int j = 0; j < sucursales; j++) {

                do {
                    System.out.print("Stock en sucursal " + (j + 1) + ": ");
                    inventario[i][j] = teclado.nextInt();

                    if (inventario[i][j] < 0) {
                        System.out.println("El stock no puede ser negativo.");
                    }

                } while (inventario[i][j] < 0);

            }

        }

        // Mostrar inventario
        System.out.println("\n===== MATRIZ DE INVENTARIO =====");

        for (int i = 0; i < productos; i++) {

            System.out.print("Producto " + (i + 1) + ": ");

            for (int j = 0; j < sucursales; j++) {

                System.out.printf("%5d", inventario[i][j]);

            }

            System.out.println();

        }

        // Producto con mayor stock
        int productoMayor = 0;
        int mayorStock = 0;

        for (int i = 0; i < productos; i++) {

            int suma = 0;

            for (int j = 0; j < sucursales; j++) {

                suma += inventario[i][j];

            }

            if (suma > mayorStock) {

                mayorStock = suma;
                productoMayor = i;

            }

        }

        // Sucursal con menor inventario
        int sucursalMenor = 0;
        int menorInventario = Integer.MAX_VALUE;

        for (int j = 0; j < sucursales; j++) {

            int suma = 0;

            for (int i = 0; i < productos; i++) {

                suma += inventario[i][j];

            }

            if (suma < menorInventario) {

                menorInventario = suma;
                sucursalMenor = j;

            }

        }

        // Inventario total
        int inventarioTotal = 0;

        for (int i = 0; i < productos; i++) {

            for (int j = 0; j < sucursales; j++) {

                inventarioTotal += inventario[i][j];

            }

        }

        // Productos agotados
        System.out.println("\n===== PRODUCTOS AGOTADOS =====");

        boolean hayAgotados = false;

        for (int i = 0; i < productos; i++) {

            boolean agotado = true;

            for (int j = 0; j < sucursales; j++) {

                if (inventario[i][j] > 0) {
                    agotado = false;
                }

            }

            if (agotado) {

                System.out.println("Producto " + (i + 1));
                hayAgotados = true;

            }

        }

        if (!hayAgotados) {
            System.out.println("No hay productos agotados.");
        }

        // Resultados
        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Producto con mayor stock: Producto " + (productoMayor + 1));
        System.out.println("Stock total del producto: " + mayorStock);

        System.out.println("\nSucursal con menor inventario: Sucursal " + (sucursalMenor + 1));
        System.out.println("Inventario de la sucursal: " + menorInventario);

        System.out.println("\nInventario total: " + inventarioTotal);

        teclado.close();
    }

}