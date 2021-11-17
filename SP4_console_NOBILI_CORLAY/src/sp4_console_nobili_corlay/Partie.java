/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_nobili_corlay;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Partie { 
    Scanner scanner = new Scanner(System.in);
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille grilleJeu;
   
   
    public Partie(Joueur joueur1,Joueur joueur2){
       ListeJoueurs[0] = joueur1;
       ListeJoueurs[1] = joueur2;
    }
   
    public void initialiserPartie(){
       grilleJeu = new Grille();
       for(int i=0; i<21 ; i++){
           ListeJoueurs[0].ListeJetons[i] = new Jeton("rouge");
           ListeJoueurs[1].ListeJetons[i] = new Jeton("jaune");
       }
       
    }
   
    public void debuterPartie(){
        Random rn = new Random();
       int jdep = rn.nextInt(1) ;
       if (jdep == 0){
           joueurCourant = ListeJoueurs[0];
       }
       if (jdep == 1){
           joueurCourant = ListeJoueurs[1];
       }
       while (grilleJeu.etreGagnantePourJoueur() != false && grilleJeu.etreRemplie() == true){
           System.out.println("Donnez la colonne dans laquelle vous souhaitez jouer:");
           int colonne = scanner.nextInt();
           if (colonne != 1 && colonne != 2 && colonne != 3 && colonne != 4 && colonne != 5 && colonne != 6 && colonne != 7 ){
               System.out.println("Vous avez commit l'irréparable...Réessayez");
               continue;
           }
           if (grilleJeu.colonneRemplie == true){
               System.out.println("La colonne est remplie");
               continue;
           }
           for (int i = 21 ; i < 21 ; i--)
               if (joueurCourant.ListeJetons[i] != null){
                   int jetrest = i;
                   break;
               }
           joueurCourant.ListeJetons[jetrest] = null;
           
       }
    }
   
    public void attribuerCouleursAuxJoueurs(){
       Random rn = new Random();
       int temp = rn.nextInt(1) ;
       if (temp == 1){
           ListeJoueurs[0].couleur = "rouge";
           ListeJoueurs[1].couleur = "jaune";
       }
       else{
           ListeJoueurs[0].couleur = "jaune";
           ListeJoueurs[1].couleur = "rouge";
       }

    }
   
}
