/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author diazf
 */
public class App {

    public static void main(String[] args) {
        
        double AA,AB,OA,OB,D;
        
        Scanner teclado=new Scanner (System.in);
        
        System.out.println("Digite la abcisa A: ");
        AA= teclado.nextDouble();
        System.out.println("Digite la abcisa B: ");
        AB= teclado.nextDouble();
        System.out.println("Digite la ordenada A: ");
        OA= teclado.nextDouble();
        System.out.println("Digite la ordenada B: ");
        OB= teclado.nextDouble();
        
        D= Math.sqrt(Math.pow(AB-AA,2)+Math.pow(OB-OA,2));
        System.out.println("La distancia entre A y B es: "+D);
        
    }
}
