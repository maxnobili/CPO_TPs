/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetp4;

/**
 *
 * @author adrie
 */
public class Jeton { 
    String Couleur;
    
    public Jeton(String CouleurJoueur){
        Couleur = CouleurJoueur ;
    }
    public String lireCouleur(){
        return Couleur ;
    }
}
