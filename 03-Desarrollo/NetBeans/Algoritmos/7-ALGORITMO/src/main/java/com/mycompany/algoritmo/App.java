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
        System.out.println("\n\tCALCULAR CD'S NECESARIOS");
        System.out.println("-------------------------------------------------");
        
        // Datos a leer
        double GB,MG;
        int CD;
        
        // Clase de Scanner para que lea lo que se escriba con el telado
        Scanner teclado=new Scanner (System.in);
        
        // Lo que se va a imprimir y a leer al ejecutar
        System.out.println("Digite los gigabytes del disco duro: ");
        GB= teclado.nextDouble();
        
        MG= GB*1024;
        
        CD= (int) ((MG/700)+1);
        
        // Resultado final
        System.out.println("La cantidad de CD'S necesarios es: "+CD);    
    }
}
