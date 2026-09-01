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
        
        Scanner teclado=new Scanner (System.in);
        
        double L1,L2,L3;
        String TT;
        
        System.out.println("Ingrese el primer lado: ");
        L1= teclado.nextInt();
        
        System.out.println("Ingrese el segundo lado: ");
        L2= teclado.nextInt();
        
        System.out.println("Ingrese el tercer lado: ");
        L3= teclado.nextInt();
        
        if ((L1!=L2)&&(L2!=L3)&&(L3!=L1)) {
        TT= "Escaleno";
    } else {
            if ((L1==L2)&&(L2==L3)) {
                TT= "Equilatero";
            } else{
                TT= "Isosceles";
                }
        }
        System.out.println("El tipo de triangulo es: "+TT);
        
    }
}
