/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmo;

import java.util.Scanner;

/**
 *
 * @author diazf
 */
public class App {

    public static void main(String[] args) {
        
        // Mostrar titulo
        System.out.println("\n\tCALCULAR PROMEDIO");
        System.out.println("-------------------------------------------------");
        
        // Datos a leer
        int N1,N2,N3,P;
        
        // Clase de Scanner para que lea lo que se escribe con el teclado
        Scanner teclado=new Scanner (System.in);
        
        // Lo que se va a imprimir y a leer al ejecutar
        System.out.println("Digite la Nota#1: ");
        N1= teclado.nextInt();
        System.out.println("Digite la Nota#2: ");
        N2= teclado.nextInt();
        System.out.println("Digite la Nota#3: ");
        N3= teclado.nextInt();
        
        // Resultado final
        P= (N1+N2+N3)/3;
        System.out.println("El promedio de las notas es: "+P);    
    }
}
