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
    
    public void Joueur(String NomJoueur){
        nom = NomJoueur ;
    }
    
    public void affecterCouleur(String CouleurJoueur){
        couleur = CouleurJoueur ;
    }
    
    public boolean ajouterJeton(int JetonJoueur){
           if(nombreJetonsRestants!=21){
               ListeJetons[nombreJetonsRestants]=JetonJoueur ;
               return true ;
           }
           else {
               return false ;
           }
           
           
           
    }
}

