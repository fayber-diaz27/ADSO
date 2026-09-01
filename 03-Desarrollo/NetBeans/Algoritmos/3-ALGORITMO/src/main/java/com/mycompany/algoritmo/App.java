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
        System.out.println("\n\tCALULAR PUNTAJES");
        System.out.println("-------------------------------------------------");
        
        // Datos a leer
        int RC,RI,RB,PRC,PRI,PF;
        
        // Clase de Scanner para que lea lo que se escriba con el teclado
        Scanner teclado=new Scanner (System.in);
        
        // Lo que se va a imprimir y a leer al ejecutar
        System.out.println("Digite el numero de respuestas correctas: ");
        RC= teclado.nextInt();
        System.out.println("Digite el numero de respuestas incorrectas: ");
        RI= teclado.nextInt();
        System.out.println("Digite el numero de respuestas en blanco: ");
        RB= teclado.nextInt();
        
        // Puntajes
        PRC= RC*4;
        PRI= RI-1;
        
        // Resultado final
        PF= PRC+PRI;
        System.out.println("El puntaje final de respuestas es: "+PF);
    }
}
