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

        int n;

        System.out.print("Ingrese el tamaño de la matriz cuadrada: ");
        n = teclado.nextInt();

        int[][] matriz = new int[n][n];

        
        System.out.println("\nIngrese los valores de la matriz:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = teclado.nextInt();
            }
        }

        
        System.out.println("\nMATRIZ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }

        boolean simetrica = true;

        
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (matriz[i][j] != matriz[j][i]) {
                    simetrica = false;
                }

            }

        }

        
        if (simetrica) {
            System.out.println("\nLa matriz ES simétrica.");
        } else {
            System.out.println("\nLa matriz NO es simétrica.");
        }

        teclado.close();
    }
}
