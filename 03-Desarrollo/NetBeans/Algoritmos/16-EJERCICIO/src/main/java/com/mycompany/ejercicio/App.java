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
        int numero;

        System.out.print("Ingrese un número: ");
        numero = teclado.nextInt();

        if (numero == 1) {
            System.out.println("A");
        } else if (numero == 2) {
            System.out.println("E");
        } else if (numero == 3) {
            System.out.println("I");
        } else if (numero == 4) {
            System.out.println("O");
        } else if (numero == 5) {
            System.out.println("U");
        } else {
            System.out.println("Valor incorrecto");
        }

        teclado.close();
    }
}
