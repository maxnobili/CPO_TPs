/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_nobili_corlay;

/**
 *
 * @author maxim
 */
public class Jeton { 
    String Couleur;
    
    // affecte la couleur pour un jeton 
    public Jeton(String CouleurJoueur){
        Couleur = CouleurJoueur ;
    }
    // retourne la couleur d'un jeton 
    public String lireCouleur(){
        return Couleur ;
    }
}


