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
        
        int NE;
        
        System.out.println("Ingrese un numero del 1 al 10: ");
        NE= teclado.nextInt();
        String ER;
        
        if (NE==1) {
            ER= "I";
        }
        
        else if (NE==2) {
            ER= "II";
        }
        
        else if (NE==3) {
            ER= "III";
        }
        
        else if (NE==4) {
            ER= "IV";
        }
        
        else if (NE==5) {
            ER= "V";
        }
        
        else if (NE==6) {
            ER= "VI";
        }
        
        else if (NE==7) {
            ER= "VII";
        }
        
        else if (NE==8) {
            ER= "VIII";
        }
        
        else if (NE==9) {
            ER= "IX";
        }
        
        else if (NE==10) {
            ER= "X";
        }
        
        else {
            ER= "Numero no valido";
        }
        
        System.out.println("EL equivalente romano es: "+ER);
        
        
        
        
        
        
        
        
        
        
    }
}
