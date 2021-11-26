/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_nobili_corlay;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class SP4_console_NOBILI_CORLAY {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scannermain = new Scanner(System.in);
        System.out.println("Bonjour vous avez decidez de commencer une partie de SUPER Puissance 4");
        System.out.println("Entrez le nom d'un des joueurs s'il vous plait:");
        String nomfct1 = scannermain.nextLine();
        Joueur Nomj1 = new Joueur(nomfct1);
        System.out.println("Entrez le nom d'un des joueurs s'il vous plait:");
        String nomfct2 = scannermain.nextLine();
        Joueur Nomj2 = new Joueur(nomfct2);
        Partie partie =  new Partie(Nomj1 , Nomj2);
        partie.initialiserPartie();
        partie.debuterPartie();
        
        
        
        Jeton j = new Jeton("rouge");
        String c = j.lireCouleur();
        System.out.println("la couleur est " + c);
        Cellule cell = new Cellule();
        c = cell.lireCouleurDuJeton();
        System.out.println(c);

        
        
        
        
        // TODO code application logic here
    }
    
}

