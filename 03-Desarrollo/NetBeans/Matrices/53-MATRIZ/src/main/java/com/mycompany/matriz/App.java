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

        System.out.print("Número de corredores aéreos (filas): ");
        int filas = teclado.nextInt();

        System.out.print("Número de sectores (columnas): ");
        int columnas = teclado.nextInt();

        int[][] espacio = new int[filas][columnas];

        System.out.println("\nIngrese el estado de cada sector:");
        System.out.println("0 = Libre");
        System.out.println("1 = Avión");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                do {

                    System.out.print("Sector [" + i + "][" + j + "]: ");
                    espacio[i][j] = teclado.nextInt();

                    if (espacio[i][j] < 0 || espacio[i][j] > 1) {

                        System.out.println("Solo puede ingresar 0 o 1.");

                    }

                } while (espacio[i][j] < 0 || espacio[i][j] > 1);

            }

        }

        detectarConflictos(espacio);

        System.out.println("\n===== ESPACIO AÉREO =====");
        mostrarMatriz(espacio);

        mostrarEstadisticas(espacio);

        teclado.close();

    }

    // Detectar conflictos
    public static void detectarConflictos(int[][] espacio) {

        int filas = espacio.length;
        int columnas = espacio[0].length;

        int[][] copia = new int[filas][columnas];

        // Copiar matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                copia[i][j] = espacio[i][j];

            }

        }

        // Buscar aviones vecinos
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                if (espacio[i][j] == 1) {

                    if (i > 0 && espacio[i - 1][j] == 1)
                        copia[i][j] = 2;

                    if (i < filas - 1 && espacio[i + 1][j] == 1)
                        copia[i][j] = 2;

                    if (j > 0 && espacio[i][j - 1] == 1)
                        copia[i][j] = 2;

                    if (j < columnas - 1 && espacio[i][j + 1] == 1)
                        copia[i][j] = 2;

                }

            }

        }

        // Actualizar matriz
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                espacio[i][j] = copia[i][j];

            }

        }

    }

    // Mostrar matriz
    public static void mostrarMatriz(int[][] espacio) {

        for (int i = 0; i < espacio.length; i++) {

            for (int j = 0; j < espacio[i].length; j++) {

                System.out.print(espacio[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Mostrar estadísticas
    public static void mostrarEstadisticas(int[][] espacio) {

        int libres = 0;
        int aviones = 0;
        int conflictos = 0;

        for (int i = 0; i < espacio.length; i++) {

            for (int j = 0; j < espacio[i].length; j++) {

                switch (espacio[i][j]) {

                    case 0:
                        libres++;
                        break;

                    case 1:
                        aviones++;
                        break;

                    case 2:
                        conflictos++;
                        break;

                }

            }

        }

        System.out.println("\n===== REPORTE =====");
        System.out.println("Sectores libres: " + libres);
        System.out.println("Aviones seguros: " + aviones);
        System.out.println("Conflictos detectados: " + conflictos);

        if (conflictos > 0) {

            System.out.println("ALERTA: Existe riesgo de colisión.");

        } else {

            System.out.println("No hay conflictos de ruta.");

        }

    }

}