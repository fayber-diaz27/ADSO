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
        System.out.println("\n\tPLANILLA DEL EMPLEADO");
        System.out.println("-------------------------------------------------");
        
        // Datos a leer
        double HL,TH,P;
        
        // Clase de Scanner para que lea lo que se escriba en el teclado
        Scanner teclado=new Scanner (System.in);
        
        // Lo que se va a imprimir y a leer al ejecutar
        System.out.println("Digite le numero de horas laboradas en el mes: ");
        HL= teclado.nextDouble();
        System.out.println("Digite la tarifa por hora: ");
        TH= teclado.nextDouble();
        
        // Resultado final
        P= HL*TH;
        System.out.println("El pago total es de: "+P);
    }
}
