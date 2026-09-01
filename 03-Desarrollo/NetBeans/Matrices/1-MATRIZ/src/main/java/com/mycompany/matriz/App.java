/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author diazf
 */
public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        int n;

        
        do {
            System.out.print("Ingrese el tamaño de la matriz (mínimo 5): ");
            n = teclado.nextInt();
        } while (n < 5);

        int[][] matriz = new int[n][n];

        // Llenar la matriz con números aleatorios entre 1 y 200
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = aleatorio.nextInt(200) + 1;
            }
        }

        
        System.out.println("\nMATRIZ GENERADA:\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }

        int sumaDiagonalPrincipal = 0;
        int sumaDiagonalSecundaria = 0;

        
        for (int i = 0; i < n; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
            sumaDiagonalSecundaria += matriz[i][n - 1 - i];
        }

        int diferencia = Math.abs(sumaDiagonalPrincipal - sumaDiagonalSecundaria);

        // Mostrar resultados
        System.out.println("\nRESULTADOS");
        System.out.println("---------------------------");
        System.out.println("Suma diagonal principal : " + sumaDiagonalPrincipal);
        System.out.println("Suma diagonal secundaria: " + sumaDiagonalSecundaria);
        System.out.println("Diferencia absoluta     : " + diferencia);

        teclado.close();
    }
}
