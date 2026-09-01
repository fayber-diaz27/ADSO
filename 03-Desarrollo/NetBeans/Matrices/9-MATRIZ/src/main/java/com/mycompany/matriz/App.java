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

        // Llenar la matriz con números aleatorios
        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                matriz[i][j] = aleatorio.nextInt(500) + 1;

            }

        }

        // Mostrar la matriz
        System.out.println("MATRIZ\n");

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                System.out.printf("%5d", matriz[i][j]);

            }

            System.out.println();

        }

        int cantidadPrimos = 0;
        int filaMasPrimos = 0;
        int mayorCantidad = 0;

        System.out.println("\nNÚMEROS PRIMOS ENCONTRADOS:");

        for (int i = 0; i < 6; i++) {

            int contadorFila = 0;

            for (int j = 0; j < 6; j++) {

                if (esPrimo(matriz[i][j])) {

                    cantidadPrimos++;
                    contadorFila++;

                    System.out.println(
                            "Número: " + matriz[i][j]
                            + "  Posición: [" + i + "][" + j + "]");

                }

            }

            if (contadorFila > mayorCantidad) {

                mayorCantidad = contadorFila;
                filaMasPrimos = i;

            }

        }

        System.out.println("\nCantidad total de números primos: " + cantidadPrimos);
        System.out.println("Fila con más números primos: " + filaMasPrimos);
        System.out.println("Cantidad de primos en esa fila: " + mayorCantidad);

    }

    // Método para saber si un número es primo
    public static boolean esPrimo(int numero) {

        if (numero < 2) {
            return false;
        }

        for (int i = 2; i < numero; i++) {

            if (numero % i == 0) {
                return false;
            }

        }

        return true;

    }

}
