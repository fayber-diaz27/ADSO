/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.suma;

import java.util.Scanner;

/**
 *
 * @author diazf
 */
public class App {

    public static void main(String[] args) {
        
        // Mostrar titulo
        System.out.println("\n\tSUMA");
        System.out.println("-------------------------------------------------");
        
        // Datos a leer de la suma
        int a,b,c;
        
        // Clase de scanner para que lea lo que se escriba con el teclado
        Scanner teclado=new Scanner (System.in);
        
        // Lo que se va a imprimir y a leer al ejecutar
        System.out.println("Por favor digite el valor de a: ");
        a= teclado.nextInt();
        
        System.out.println("Por favor digite el valor de b: ");
        b= teclado.nextInt();
        
        // Resultado final
        c= a+b;
        System.out.println("El resultado de la suma es igual a: "+c);

    }
}
