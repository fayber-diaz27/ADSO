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

        
        System.out.println("\nIngrese los valores de la matriz:");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();
            }
        }

        
        System.out.println("\nMATRIZ ORIGINAL");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }

        
        System.out.println("\nESPEJO HORIZONTAL");

        for (int i = filas - 1; i >= 0; i--) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }

        
        System.out.println("\nESPEJO VERTICAL");

        for (int i = 0; i < filas; i++) {
            for (int j = columnas - 1; j >= 0; j--) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }

        
        System.out.println("\nESPEJO HORIZONTAL Y VERTICAL");

        for (int i = filas - 1; i >= 0; i--) {
            for (int j = columnas - 1; j >= 0; j--) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }

        teclado.close();
    }
}
