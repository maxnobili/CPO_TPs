/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maxim
 */
public class Joueur {
    String nom ;
    String couleur ;
    int [] ListeJetons = new int[21];
    int reservoirjeton = ListeJetons.length ;
    
    public Joueur(String NomJ1){
        nom = NomJ1 ;
    }
    
    public String affecterCouleur(String CouleurJ1){
        couleur = CouleurJ1 ;
    }
    
    
}
