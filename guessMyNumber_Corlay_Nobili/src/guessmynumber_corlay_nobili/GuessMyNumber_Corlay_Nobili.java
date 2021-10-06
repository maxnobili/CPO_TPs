/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessmynumber_corlay_nobili;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class GuessMyNumber_Corlay_Nobili {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Random generateurAleat = new Random();
        System.out.println("saisissez le niveau de difficulté :\n1 : facile\n2 : normal\n3 : difficile");
        int diff; 
        int var = 0 ;
        diff = sc.nextInt();
        if(diff==1){
            var = 50 ; 
        }
        if(diff==2){
            var = 100 ; 
        }
        if(diff==3){
            var = 200 ; 
        }
        int n1 = generateurAleat.nextInt(var);
        int n2 = 0 ;
        int i = 0 ;
        while (n1!=n2){
            System.out.println("saisissez un nombre entre 0 et "+var);
            n2 = sc.nextInt() ;
            i= i + 1 ;
            if (n2<n1){
                System.out.println("trop petit");
            }
            if (n2>n1){
                System.out.println("trop grand");
            }
        }
        System.out.println("gagné \nnombre de tentatives : "+i);
        
    }
    
}
