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
        
        double GB,MB;
        int CD;
        
        Scanner teclado=new Scanner (System.in);
        
        System.out.println("Por favor digite el tamano del disco en GB: ");
        GB= teclado.nextDouble();
        
        MB= GB*1024;
        CD= (int) (MB/700)+1;
        System.out.println("La cantidad de CD necesarios es: "+CD);
        
        
        
        
        
        
        
    }
}
