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

        int NE, Q, R;
        String MSG;

        System.out.print("Ingrese un número: ");
        NE = teclado.nextInt();

        // Según el pseudocódigo
        Q = NE / 2;
        R = NE - (Q * 2);

        if (R == 0) {
            MSG = "Es Par";
        } else {
            MSG = "Es Impar";
        }

        System.out.println(MSG);

        teclado.close();
    }
}
