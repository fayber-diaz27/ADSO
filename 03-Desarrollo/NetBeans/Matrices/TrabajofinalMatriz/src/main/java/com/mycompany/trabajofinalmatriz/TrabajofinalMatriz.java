/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabajofinalmatriz;

import java.util.Scanner;

/**
 *
 * @author diazf
 */
public class TrabajofinalMatriz {

    public static void main(String[] args) {

        // Libreria
        Scanner teclado = new Scanner(System.in);
        int[][] inventario = new int[5][6]; // Crear matriz

        // 1. Registro de inventario
        System.out.println("\n\t-------------REGISTRO DE INVENTARIO---------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("\nCategoria" + (i + 1) + "\t");
            for (int j = 0; j < 6; j++) {
                do {
                    System.out.print("Ingrese la cantidad del Producto " + (j + 1) + ": ");
                    inventario[i][j] = teclado.nextInt();
                    if (inventario[i][j] < 0) {
                        System.out.println("Error. La cantidad no puede ser negativa.");
                    }
                } while (inventario[i][j] < 0);
            }
        }

        // 2. Mostrar matriz
        System.out.println("\n\t-------------CANTIDAD DE PRODUCTOS EN EL INVENTARIO------------");
        System.out.println("\t\t");
        for (int j = 0; j < 6; j++) {
            System.out.print("\tP" + (j + 1) + "\t");
        }
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            System.out.print("Categoria" + (i + 1) + "\t");
            for (int j = 0; j < 6; j++) {
                System.out.print(inventario[i][j] + "\t");
            }
            System.out.println("");
        }

        // 3. Calculos
        System.out.println("\n\t-------------CALCULOS---------------");
        int totalGeneral = 0;
        for (int i = 0; i < 5; i++) {
            int suma = 0;
            for (int j = 0; j < 6; j++) {
                suma += inventario[i][j];
            }
            double promedio = (double) suma / 6;
            System.out.println("\nCategoria " + (i + 1));
            System.out.println("Total: " + suma);
            System.out.println("Promedio: " + promedio);
            totalGeneral += suma;
        }
        System.out.println("\nInventario General: " + totalGeneral);

        // 4. Encontrar
        System.out.println("\n\t-------------ENCONTRAR---------------");
        // Encontrar categoría con mayor y menor inventario
        int mayorCategoria = 0;
        int menorCategoria = 0;
        int categoriaMayor = 0;
        int categoriaMenor = 0;
        int mayorProducto = 0;
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < 5; i++) {
            int suma = 0;
            for (int j = 0; j < 6; j++) {
                suma += inventario[i][j];
                // Buscar el producto con mayor cantidad
                if (inventario[i][j] > mayorProducto) {
                    mayorProducto = inventario[i][j];
                    fila = i;
                    columna = j;
                }
            }
            // La primera categoría sirve como referencia
            if (i == 0) {
                mayorCategoria = suma;
                menorCategoria = suma;
                categoriaMayor = i;
                categoriaMenor = i;
            }
            // Categoría con mayor inventario
            if (suma > mayorCategoria) {
                mayorCategoria = suma;
                categoriaMayor = i;
            }
            // Categoría con menor inventario
            if (suma < menorCategoria) {
                menorCategoria = suma;
                categoriaMenor = i;
            }
        }
        System.out.println("Categoria con mayor inventario: Categoria " + (categoriaMayor + 1));
        System.out.println("Cantidad: " + mayorCategoria);
        System.out.println();
        System.out.println("Categoria con menor inventario: Categoria " + (categoriaMenor + 1));
        System.out.println("Cantidad: " + menorCategoria);
        System.out.println();
        System.out.println("Producto con mayor cantidad almacenada: " + mayorProducto);
        System.out.println("Se encuentra en la Categoria " + (fila + 1) + " Producto " + (columna + 1));

        // 5. Alertas de inventario
        System.out.println("\n\t----------- ALERTA STOCK BAJO -----------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (inventario[i][j] < 10) {
                    System.out.println("Categoria " + (i + 1) + " - Producto " + (j + 1) + " = " + inventario[i][j]);
                }
            }
        }

        // 6. Buscar un producto
        System.out.println("\n\t------------- BUSCAR PRODUCTO -------------");
        // Variables
        int categoria;
        int producto;
        // Pedir datos
        System.out.print("Ingrese la categoria (1 - 5): ");
        categoria = teclado.nextInt();
        System.out.print("Ingrese el producto (1 - 6): ");
        producto = teclado.nextInt();
        // Validar que existan
        if (categoria >= 1 && categoria <= 5 && producto >= 1 && producto <= 6) {
            System.out.println("Cantidad disponible: " + inventario[categoria - 1][producto - 1]);
        } else {
            System.out.println("Categoria o producto incorrecto.");
        }

        // 7. Actualizar inventario
        System.out.println("\n\t------------- ACTUALIZAR INVENTARIO -------------");
        int opcion;
        int cantidad;
        System.out.print("Ingrese la categoria (1 - 5): ");
        categoria = teclado.nextInt();
        System.out.print("Ingrese el producto (1 - 6): ");
        producto = teclado.nextInt();
        if (categoria >= 1 && categoria <= 5 && producto >= 1 && producto <= 6) {
            System.out.println("\n1. Ingresar mercancia");
            System.out.println("2. Registrar venta");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                System.out.print("Cantidad a ingresar: ");
                cantidad = teclado.nextInt();
                if (cantidad > 0) {
                    inventario[categoria - 1][producto - 1] += cantidad;
                    System.out.println("Inventario actualizado.");
                    System.out.println("Nueva cantidad: " + inventario[categoria - 1][producto - 1]);
                } else {
                    System.out.println("La cantidad debe ser mayor que 0.");
                }
            } else if (opcion == 2) {
                System.out.print("Cantidad vendida: ");
                cantidad = teclado.nextInt();
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor que 0.");
                } else if (cantidad <= inventario[categoria - 1][producto - 1]) {
                    inventario[categoria - 1][producto - 1] -= cantidad;
                    System.out.println("Venta registrada.");
                    System.out.println("Nueva cantidad: " + inventario[categoria - 1][producto - 1]);
                } else {
                    System.out.println("Error. No hay suficiente inventario.");
                }

                // 8. Reporte final
                System.out.println("\n\t------------- REPORTE FINAL -------------");
                // Mostrar nuevamente la matriz
                System.out.println("\nInventario actualizado:");
                System.out.print("\t");
                for (int j = 0; j < 6; j++) {
                    System.out.print("P" + (j + 1) + "\t");
                }
                System.out.println();
                for (int i = 0; i < 5; i++) {
                    System.out.print("Categoria " + (i + 1) + "\t");
                    for (int j = 0; j < 6; j++) {
                        System.out.print(inventario[i][j] + "\t");
                    }
                    System.out.println();
                }
                // Inventario total
                int inventarioTotal = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 6; j++) {
                        inventarioTotal += inventario[i][j];
                    }
                }
                System.out.println("\nInventario total: " + inventarioTotal);
                // Promedio general
                double promedioGeneral = (double) inventarioTotal / 30;
                System.out.println("Promedio general: " + promedioGeneral);
                // Categorías con stock crítico
                System.out.println("\nCategorias con stock bajo:");
                boolean hayCritico = false;
                for (int i = 0; i < 5; i++) {
                    int suma = 0;
                    for (int j = 0; j < 6; j++) {
                        suma += inventario[i][j];
                    }
                    if (suma < 60) {
                        System.out.println("Categoria " + (i + 1) + " tiene stock bajo.");
                        hayCritico = true;
                    }
                }
                if (!hayCritico) {
                    System.out.println("No hay categorias con stock bajo.");
                }
            }
        }
    }
}
