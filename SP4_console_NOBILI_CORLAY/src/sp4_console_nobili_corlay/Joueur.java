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
    
    // creation des attributs de la lcasse joueur
    String nom ;
    String couleur ;
    Jeton [] ListeJetons = new Jeton[21]; // tableau avec le nombre de jeton en possession du joueur
    int nombreJetonsRestants = ListeJetons.length ;
    int nombreDesintegrateurs = 0 ;
    
    public Joueur(String NomJoueur){
        nom = NomJoueur ;
    }
    
    public void affecterCouleur(String CouleurJoueur){
        couleur = CouleurJoueur ;
    }
    
    // ajoute un jeton dans le tableau de jeton du joueur 
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
    
    // utilise un desintegrateur et modifie le nombre de desintegrateur du joueur
    public boolean utiliserDesintegrateur(){
        if (nombreDesintegrateurs == 0){
            return false ;
        }
        nombreDesintegrateurs = nombreDesintegrateurs - 1 ;
        return true ;
    }
}

