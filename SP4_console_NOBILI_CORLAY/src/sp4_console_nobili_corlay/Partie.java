/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_nobili_corlay;

/**
 *
 * @author maxim
 */
public class Partie { 
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille grilleJeu;
   
    public Partie(Joueur joueur1,Joueur joueur2){
       
    }
   
    public void initialiserPartie(){
       grilleJeu = new Grille();
       for(int i=0; i<21 ; i++){
           ListeJetons[i] = ListeJoueurs[0].couleur;
       }
    }
   
    public void debuterPartie(){
       
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
