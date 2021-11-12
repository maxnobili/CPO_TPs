package sp4_console_nobili_corlay;

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
    int nombreJetonsRestants = ListeJetons.length ;
    
    public void Joueur(String NomJ1){
        nom = NomJ1 ;
    }
    
    public void affecterCouleur(String CouleurJ1){
        couleur = CouleurJ1 ;
    }
    
    public boolean ajouterJeton(int Jeton){
           if(nombreJetonsRestants!=21){
               ListeJetons[nombreJetonsRestants]=Jeton ;
           }
           
    }
}
