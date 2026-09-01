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
        System.out.println("\n\tCALCULAR PUNTAJE DE PARTIDOS");
        System.out.println("-------------------------------------------------");
        
        // Datos a leer
        int PG,PE,PP,PPG,PPE,PT;
        
        // Clase de Scanner para que lea lo que se escribe con el teclado
        Scanner teclado=new Scanner (System.in);
        
        // Lo que se va a impirmir y a leer al ejecutar
        System.out.println("Digite el numero de partidos ganados: ");
        PG= teclado.nextInt();
        System.out.println("Digite el numero de partidos empatados: ");
        PE= teclado.nextInt();
        System.out.println("Digite el numero de partidos perdidos: ");
        PP= teclado.nextInt();
        
        // Puntajes
        PPG= PG*3;
        PPE= PE*1;
        
        // Resultado final
        PT= PPG+PPE;
        System.out.println("El puntaje total de partidos es: "+PT);
    }
}
