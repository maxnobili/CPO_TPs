/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetp4;

/**
 *
 * @author adrie
 */
public class Joueur { 
    String nom ;
    String couleur ;
    Jeton [] ListeJetons = new Jeton[21];
    int nombreJetonsRestants = ListeJetons.length ;
    int nombreDesintegrateurs = 0 ;
    
    public Joueur(String NomJoueur){
        nom = NomJoueur ;
    }
    
    public void affecterCouleur(String CouleurJoueur){
        couleur = CouleurJoueur ;
    }
    
    public boolean ajouterJeton(Jeton JetonJoueur){
           if(nombreJetonsRestants!=21){
               ListeJetons[nombreJetonsRestants]=JetonJoueur ;
               return true ;
           }
           else {
               return false ;
           }
    }
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs = nombreDesintegrateurs + 1 ;
    }
    
    public boolean utiliserDesintegrateur(){
        if (nombreDesintegrateurs == 0){
            return false ;
        }
        nombreDesintegrateurs = nombreDesintegrateurs - 1 ;
        return true ;
    }
}
