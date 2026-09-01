/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio;

import java.util.Scanner;

/**
 *
 * @author diazf
 */
public class App {

    public static void main(String[] args) {
          Scanner teclado = new Scanner(System.in);

        int NE, K;
        double SE, SS, SP;

        System.out.print("Ingrese el número de empleados: ");
        NE = teclado.nextInt();

        SS = 0;

        for (K = 1; K <= NE; K++) {
            System.out.print("Ingrese el sueldo del empleado " + K + ": ");
            SE = teclado.nextDouble();

            SS = SS + SE;
        }

        SP = SS / NE;

        System.out.println("El sueldo promedio es: " + SP);

        teclado.close();
    }
}
