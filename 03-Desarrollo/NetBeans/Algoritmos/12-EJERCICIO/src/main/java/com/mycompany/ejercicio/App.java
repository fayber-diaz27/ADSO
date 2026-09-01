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
        
        int N1,N2,N3,NM;
        
        Scanner teclado=new Scanner (System.in);
        
        System.out.println("Digite el primer numero entero: ");
        N1= teclado.nextInt();
        
        System.out.println("Digite el segundo numero entero: ");
        N2= teclado.nextInt();
        
        System.out.println("Digite el tercer numero entero: ");
        N3= teclado.nextInt();
        
        if (N1>N2 && N1>N3) {
            NM=N1;
        }else{
            if (N2>N3) {
                NM=N2;
        }else {
            NM=N3;
            }
        }
        System.out.println("El numero mayor es: " +NM);
    }
}
