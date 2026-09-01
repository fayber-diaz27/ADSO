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
        int[][] transpuesta = new int[columnas][filas];

        
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

        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        
        System.out.println("\nMATRIZ TRANSPUESTA");

        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                System.out.printf("%5d", transpuesta[i][j]);
            }
            System.out.println();
        }

        teclado.close();
    }

}
