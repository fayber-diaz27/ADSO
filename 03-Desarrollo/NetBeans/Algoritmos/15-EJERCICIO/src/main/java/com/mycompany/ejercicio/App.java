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
        double MV, TB;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingrese el monto de venta: ");
        MV= teclado.nextDouble();
        
        if(MV>=0 && MV<1000){
        TB=0;
        }
        
        else if(MV<5000){
        TB=(3*MV)/100;
        }
        
        else if(MV<20000){
        TB=(5*MV)/100;
        }
        
        else{
        TB=(8*MV)/100;
        }
        
        System.out.println("La bonificacion es: " +TB);
        teclado.close();
        
    }
}
