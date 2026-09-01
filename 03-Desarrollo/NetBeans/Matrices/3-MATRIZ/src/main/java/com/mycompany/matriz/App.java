/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz;

import java.util.Random;

/**
 *
 * @author diazf
 */
public class App {

    public static void main(String[] args) {
        Random aleatorio = new Random();

        int[][] matriz = new int[6][6];

        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matriz[i][j] = aleatorio.nextInt(20) + 1;
            }
        }

        
        System.out.println("MATRIZ\n");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

        int numeroMasRepetido = 0;
        int mayorCantidad = 0;

        
        for (int numero = 1; numero <= 20; numero++) {

            int contador = 0;

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {

                    if (matriz[i][j] == numero) {
                        contador++;
                    }

                }
            }

            if (contador > mayorCantidad) {
                mayorCantidad = contador;
                numeroMasRepetido = numero;
            }

        }

        
        System.out.println("\nNúmero más repetido: " + numeroMasRepetido);
        System.out.println("Cantidad de repeticiones: " + mayorCantidad);

        System.out.println("\nPosiciones donde aparece:");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {

                if (matriz[i][j] == numeroMasRepetido) {
                    System.out.println("Fila: " + i + "  Columna: " + j);
                }

            }
        }

    }

}
