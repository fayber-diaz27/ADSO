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

        int filas = 6;
        int columnas = 6;

        int[][] bosque = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 2, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        System.out.print("Ingrese la cantidad de ciclos: ");
        int ciclos = teclado.nextInt();

        for (int ciclo = 1; ciclo <= ciclos; ciclo++) {

            System.out.println("\n===== CICLO " + ciclo + " =====");

            int[][] nuevoBosque = new int[filas][columnas];

            // Copiar la matriz
            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    nuevoBosque[i][j] = bosque[i][j];

                }

            }

            // Propagar el fuego
            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    if (bosque[i][j] == 2) {

                        // El árbol en llamas pasa a quemado
                        nuevoBosque[i][j] = 3;

                        // Arriba
                        if (i > 0 && bosque[i - 1][j] == 1)
                            nuevoBosque[i - 1][j] = 2;

                        // Abajo
                        if (i < filas - 1 && bosque[i + 1][j] == 1)
                            nuevoBosque[i + 1][j] = 2;

                        // Izquierda
                        if (j > 0 && bosque[i][j - 1] == 1)
                            nuevoBosque[i][j - 1] = 2;

                        // Derecha
                        if (j < columnas - 1 && bosque[i][j + 1] == 1)
                            nuevoBosque[i][j + 1] = 2;

                    }

                }

            }

            bosque = nuevoBosque;

            mostrarBosque(bosque);

            contarArboles(bosque);

        }

        teclado.close();

    }

    // Mostrar bosque
    public static void mostrarBosque(int[][] bosque) {

        System.out.println("\nESTADO DEL BOSQUE");

        for (int i = 0; i < bosque.length; i++) {

            for (int j = 0; j < bosque[i].length; j++) {

                System.out.print(bosque[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Contar árboles
    public static void contarArboles(int[][] bosque) {

        int sanos = 0;
        int llamas = 0;
        int quemados = 0;

        for (int i = 0; i < bosque.length; i++) {

            for (int j = 0; j < bosque[i].length; j++) {

                switch (bosque[i][j]) {

                    case 1:
                        sanos++;
                        break;

                    case 2:
                        llamas++;
                        break;

                    case 3:
                        quemados++;
                        break;

                }

            }

        }

        System.out.println("\nÁrboles sanos: " + sanos);
        System.out.println("Árboles en llamas: " + llamas);
        System.out.println("Árboles quemados: " + quemados);

    }

}