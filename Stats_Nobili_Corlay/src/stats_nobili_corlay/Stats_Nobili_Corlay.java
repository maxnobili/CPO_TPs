/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stats_nobili_corlay;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Stats_Nobili_Corlay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random nbaleat = new Random();
        int [] tab = new int [6];
        Scanner sc = new Scanner(System.in);
        int m;
        System.out.println("Saississez un entier :");
        m = sc.nextInt();
        for (int i = 0 ; i<m ; i++){
            int n = nbaleat.nextInt(6);
            if (n == 0){
                tab[0] = tab[0]+1;
            }
            if (n == 1){
                tab[1] = tab[1]+1;
            }
            if (n == 2){
                tab[2] = tab[2]+1;
            }
            if (n == 3){
                tab[3] = tab[3]+1;
            }
            if (n == 4){
                tab[4] = tab[4]+1;
            }
            if (n == 5){
                tab[5] = tab[5]+1;
            }
        }
        for (int k = 0 ; k<6 ; k++){
            System.out.println("Il y a " + tab[k]*100/m + " % de " + k );
        }
        

    }
    
}