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
        
        int E1,E2,DE;
        Scanner teclado=new Scanner (System.in);
        
        System.out.println("Digite la edad del hermano 1: ");
        E1= teclado.nextInt();
        System.out.println("Digite la edad del hermano 2: ");
        E2= teclado.nextInt();
        
        if (E1>E2) {
            
            DE= E1-E2;
            System.out.println("El primer hermano es el mayor");
            System.out.println("La diferencia es de: "+DE+" anos");
        } else  {
            DE= E2-E1;
            System.out.println("El segundo hermano es el mayor");
            System.out.println("La diferencia es de: "+DE+" anos");
        }
   
    }
}
