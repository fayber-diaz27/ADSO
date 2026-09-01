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

        int NE, Q, R, D, U;

        System.out.print("Ingrese un número de 2 cifras: ");
        NE = teclado.nextInt();

        Q = NE / 10;
        R = NE - (Q * 10);

        D = Q;
        U = R;

        System.out.println("Decenas: " + D);
        System.out.println("Unidades: " + U);

        teclado.close();
    }
}
