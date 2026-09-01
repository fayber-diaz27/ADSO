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

        int[][] tablero = new int[4][4];
        boolean[][] descubiertas = new boolean[4][4];

        // Crear parejas (1 al 8)
        int[] numeros = {
            1,1,2,2,3,3,4,4,
            5,5,6,6,7,7,8,8
        };

        // Mezclar números
        for (int i = 0; i < numeros.length; i++) {

            int posicion = aleatorio.nextInt(numeros.length);

            int auxiliar = numeros[i];
            numeros[i] = numeros[posicion];
            numeros[posicion] = auxiliar;

        }

        // Llenar la matriz
        int indice = 0;

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                tablero[i][j] = numeros[indice];
                indice++;

            }

        }

        int parejasEncontradas = 0;

        while (parejasEncontradas < 8) {

            // Mostrar tablero
            System.out.println("\nTABLERO");

            System.out.print("   ");
            for (int j = 0; j < 4; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

            for (int i = 0; i < 4; i++) {

                System.out.print(i + "  ");

                for (int j = 0; j < 4; j++) {

                    if (descubiertas[i][j]) {
                        System.out.print(tablero[i][j] + " ");
                    } else {
                        System.out.print("* ");
                    }

                }

                System.out.println();

            }

            // Primera selección
            System.out.println("\nPrimera carta");

            System.out.print("Fila: ");
            int f1 = teclado.nextInt();

            System.out.print("Columna: ");
            int c1 = teclado.nextInt();

            // Segunda selección
            System.out.println("\nSegunda carta");

            System.out.print("Fila: ");
            int f2 = teclado.nextInt();

            System.out.print("Columna: ");
            int c2 = teclado.nextInt();

            // Validar posiciones
            if (f1 < 0 || f1 > 3 || c1 < 0 || c1 > 3 ||
                f2 < 0 || f2 > 3 || c2 < 0 || c2 > 3) {

                System.out.println("Posiciones inválidas.");
                continue;
            }

            if (f1 == f2 && c1 == c2) {

                System.out.println("Debe seleccionar dos casillas diferentes.");
                continue;

            }

            // Mostrar cartas
            System.out.println("\nCartas seleccionadas:");
            System.out.println(tablero[f1][c1] + " y " + tablero[f2][c2]);

            // Verificar pareja
            if (tablero[f1][c1] == tablero[f2][c2]) {

                descubiertas[f1][c1] = true;
                descubiertas[f2][c2] = true;

                parejasEncontradas++;

                System.out.println("¡Encontraste una pareja!");

            } else {

                System.out.println("No son iguales.");

            }

        }

        System.out.println("\n¡¡FELICIDADES!!");
        System.out.println("Has encontrado todas las parejas.");

        teclado.close();

    }

}