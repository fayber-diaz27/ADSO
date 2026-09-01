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
        
        int PL,PMa,PMi,PJ,PV,PS;
        int PT;
        double PP;
        
        Scanner teclado=new Scanner (System.in);
        
        System.out.println("Produccion del dia lunes: ");
        PL= teclado.nextInt();
        
        System.out.println("Produccion del dia martes: ");
        PMa= teclado.nextInt();
        
        System.out.println("Produccion del dia miercoles: ");
        PMi= teclado.nextInt();
        
        System.out.println("Prodccion del dia jueves: ");
        PJ= teclado.nextInt();
        
        System.out.println("Produccion del dia viernes: ");
        PV= teclado.nextInt();
        
        System.out.println("Produccion del dia sabado: ");
        PS= teclado.nextInt();
        
        PT= PL+PMa+PMi+PJ+PV+PS;
        PP= PT/6;
        
        if (PP>100) {
            System.out.println("Recibira incentivos");
        } else {
            System.out.println("No recibira incentivos");
        }

    }
}
