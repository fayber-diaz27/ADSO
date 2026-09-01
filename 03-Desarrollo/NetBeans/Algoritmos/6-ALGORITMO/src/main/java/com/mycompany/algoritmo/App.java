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
        System.out.println("\n\tLECTOR DE LOS LADOS DE UN TRIANGULO");
        System.out.println("-------------------------------------------------");
        
        // Datos a leer
        double LA,LB,LC,LS,AT;
        
        // Clase de Scanner para que lea lo que se escriba con el teclado
        Scanner teclado=new Scanner (System.in);
        
        // Lo que se va a imprimir y a leer al ejecutar
        System.out.println("Digite la longitud del lado A: ");
        LA= teclado.nextDouble();
        System.out.println("Digite la longitud del lado B: ");
        LB= teclado.nextDouble();
        System.out.println("Digite la longitud del lado C: ");
        LC= teclado.nextDouble();
        
        LS= (LA+LB+LC)/2;
        
        // Resultado final
        AT= Math.pow((LS*(LS-LA)*(LS-LB)*(LS-LC)),0.5);
        System.out.println("El area del tringulo es: "+AT); 
    }
}
