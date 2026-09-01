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
        
        int AN,AA,E;
        
        Scanner teclado=new Scanner (System.in);
        
        System.out.println("Digite el ano de nacimiento: ");
        AN= teclado.nextInt();
        System.out.println("Digite el ano actual: ");
        AA= teclado.nextInt();
        
        E= AA-AN;
        
        if (E>17) {
            System.out.println("Debe solicitar el CUIL");
        }else {
            System.out.println("No debe solicitar el CUIL");
        }
   
    }
}
