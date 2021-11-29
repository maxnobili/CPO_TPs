/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_nobili_corlay;

/**
 *
 * @author maxim
 */
public class Cellule { 
    // creation des attributs utiles a la classe cellule
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    // initialisation des attributs utiles a la classe cellule
    public Cellule(){
        jetonCourant = null ;
        desintegrateur = false;
        trouNoir = false;
                
    }
    // affecte la valeur du jeton du joueur a la valeur du jeton courant 
    public boolean affecterJeton(Jeton JetonJoueur){
        if(jetonCourant == null){
            jetonCourant = JetonJoueur ;
            return true;
        }
        else{
            return false ;
        }
    }
    
    public Jeton recupererJeton(){
        return jetonCourant;
    }
    // supprime le jeton du jeton courant
    public boolean supprimerJeton(){
        jetonCourant = null;
        return true;
    }
    // place un trou noir 
    public boolean placerTrouNoir(){
        if(trouNoir == false){
            trouNoir = true;
            return true;
        }
        else{
            return false;
        }
    }
    // place un desintegrateur 
    public boolean placerDesintegrateur(){
        if(desintegrateur == false){
            desintegrateur = true;
            return true;
        }
        else{
            return false;
        }
    }
    
    // regarde si un trou noir est present 
    public boolean presenceTrouNoir(){
        if (trouNoir == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    // regarde si un desintegrateur est present     
    public boolean presenceDesintegrateur(){
        if(desintegrateur == true){
            return true;
        }
        return false ;
    }
    
    // lis la couleur du jeton courant 
    public String lireCouleurDuJeton(){
        if(jetonCourant!=null){
            return jetonCourant.Couleur ;
        }
        else{
            return "vide" ;
        }
    }
    
    // recupere le desintegrateur 
    public boolean recupererDesintegrateur(){
        if(desintegrateur == true){
            desintegrateur = false;
            return true;
        }
        return false ;
    }
    
    // active le trou noir
    public boolean activerTrouNoir(){
        if (trouNoir == true && jetonCourant == null){
            jetonCourant = null;
            trouNoir = false;
            return true;
        }
        else{
            return false;
        }
    }
}


