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
        System.out.println("\n\tCALCULAR DISTANCIA");
        System.out.println("-------------------------------------------------");
        
        // Datos enteros
        int V,T,D;
        
        // Clase para los datos
        Scanner teclado=new Scanner (System.in);
        
        // Leer los datos
        System.out.println("Por favor digite el valor de la Velocidad en m/s: ");
        V= teclado.nextInt();
        
        System.out.println("Por favor digite el valor del tiempo en segundos: ");
        T= teclado.nextInt();
        
        D= V*T;
        System.out.println("La distancia recorrida por un automovil es de: "+D+"m");
    }
}
