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

        System.out.print("Ingrese la cantidad de salas: ");
        int salas = teclado.nextInt();

        System.out.print("Ingrese la cantidad de camas por sala: ");
        int camas = teclado.nextInt();

        int[][] hospital = new int[salas][camas];

        int opcion;

        do {

            System.out.println("\n===== HOSPITAL =====");
            System.out.println("1. Registrar paciente normal");
            System.out.println("2. Registrar emergencia");
            System.out.println("3. Mostrar hospital");
            System.out.println("4. Mostrar ocupación por sala");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    if (asignarPaciente(hospital, 1)) {

                        System.out.println("Paciente registrado.");

                    } else {

                        System.out.println("No hay camas disponibles.");

                    }

                    break;

                case 2:

                    if (asignarPaciente(hospital, 2)) {

                        System.out.println("Paciente de emergencia registrado.");

                    } else {

                        System.out.println("No hay camas disponibles.");

                    }

                    break;

                case 3:

                    mostrarHospital(hospital);
                    break;

                case 4:

                    ocupacionPorSala(hospital);
                    break;

                case 5:

                    System.out.println("Programa finalizado.");
                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 5);

        teclado.close();

    }

    // Asignar cama automáticamente
    public static boolean asignarPaciente(int[][] hospital, int tipo) {

        for (int i = 0; i < hospital.length; i++) {

            for (int j = 0; j < hospital[i].length; j++) {

                if (hospital[i][j] == 0) {

                    hospital[i][j] = tipo;
                    return true;

                }

            }

        }

        return false;

    }

    // Mostrar hospital
    public static void mostrarHospital(int[][] hospital) {

        System.out.println("\n===== ESTADO DEL HOSPITAL =====");

        for (int i = 0; i < hospital.length; i++) {

            for (int j = 0; j < hospital[i].length; j++) {

                System.out.print(hospital[i][j] + " ");

            }

            System.out.println();

        }

    }

    // Mostrar ocupación por sala
    public static void ocupacionPorSala(int[][] hospital) {

        System.out.println("\n===== OCUPACIÓN =====");

        for (int i = 0; i < hospital.length; i++) {

            int ocupadas = 0;

            for (int j = 0; j < hospital[i].length; j++) {

                if (hospital[i][j] != 0) {

                    ocupadas++;

                }

            }

            System.out.println("Sala " + (i + 1) + ": "
                    + ocupadas + " de "
                    + hospital[i].length + " camas ocupadas.");

        }

    }

}