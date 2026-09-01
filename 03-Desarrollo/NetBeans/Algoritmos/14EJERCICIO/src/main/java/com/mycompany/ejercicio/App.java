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
        Scanner teclado=new Scanner(System.in);
        int NE;
        
        System.out.println("Ingrese un numero del 1 al 10: ");
        NE= teclado.nextInt();
        
        if(NE==1){
            System.out.println("I");
        }
        
        else if(NE==2){
            System.out.println("II");
        }
        
        else if(NE==3){
            System.out.println("III");
        }
        
        else if(NE==4){
            System.out.println("IV");
        }
        
        else if(NE==5){
            System.out.println("V");
        }
        
        else if(NE==6){
            System.out.println("VI");
        }
        
        else if(NE==7){
            System.out.println("VII");
        }
        
        else if(NE==8){
            System.out.println("VIII");
        }
        
        else if(NE==9){
            System.out.println("IX");
        }
        
        else if(NE==10){
            System.out.println("X");
        }
        
        else{
            System.out.println("Numero fuera de rango");
        }
        
        teclado.close();
        
    }
}
