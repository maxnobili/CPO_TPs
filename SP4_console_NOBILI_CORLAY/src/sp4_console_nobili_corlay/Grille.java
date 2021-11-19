/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_nobili_corlay;

import static java.time.Clock.system;

/**
 *
 * @author maxim
 */
public class Grille { 
    Cellule [][] CelluleJeu = new Cellule [6][7];
    
    
    public Grille(){
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                CelluleJeu[i][j]=new Cellule();
            }
        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton jeton, int ColonneJoueur){
        for (int i=0; i<6; i++){
            if (CelluleJeu[5-i][ColonneJoueur].affecterJeton(jeton) == true){
                return true ;
            }
                //attention de haut en bas mais plus simple si de bas en haut dans l'affichage 
        }
        return false ;
    }
    
    public boolean etreRemplie(){
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                if (CelluleJeu[j][i] == null){
                    return false; 
                }    
            }
        }
        return true;
    }
    
    public void viderGrille(){
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                CelluleJeu[j][i] = null; 
            }
        }
    }
                    
    public void afficherGrilleSurConsole(){
        for( int i=0; i<6; i++){
            for( int j=0; j<7; j++){
                if( lireCouleurDuJeton(i,j)=="rouge"){
                   System.out.print("\033[31m O");
                }  
                if( lireCouleurDuJeton(i,j)=="jaune"){
                        System.out.print("\033[33m O");
                }
                if( lireCouleurDuJeton(i,j)=="vide"){
                    System.out.print("\033[30m O");
                }
            }
            System.out.print("\n");
        }
    }
    
    public boolean celluleOccupee(int LigneDonnee ,int ColonneDonnee){
        if( CelluleJeu[LigneDonnee][ColonneDonnee].lireCouleurDuJeton() != null ){
            return true ;
        }
        return false ;
    }
    
    public String lireCouleurDuJeton(int LigneDonnee ,int ColonneDonnee){
        return CelluleJeu[LigneDonnee][ColonneDonnee].lireCouleurDuJeton();
    }
    
    public boolean etreGagnantePourJoueur(Joueur J){
        String couleurJ=J.couleur ;
        for(int x=0; x<6; x++){
            for (int y=0; y<4; y++){
                if (couleurJ == CelluleJeu[x][y].lireCouleurDuJeton()){
                    if (couleurJ == CelluleJeu[x][y+1].lireCouleurDuJeton()){
                        if (couleurJ == CelluleJeu[x][y+2].lireCouleurDuJeton()){
                            if(couleurJ == CelluleJeu[x][y+3].lireCouleurDuJeton()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        
        for (int i=0; i<3; i++){
            for (int j=0; j<7; j++){
                if (couleurJ == CelluleJeu[i][j].lireCouleurDuJeton()){
                    if (couleurJ == CelluleJeu[i+1][j].lireCouleurDuJeton()){
                        if(couleurJ == CelluleJeu[i+2][j].lireCouleurDuJeton()){ 
                            if(couleurJ == CelluleJeu[i+3][j].lireCouleurDuJeton()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        for(int x=5; x>2; x--){
            for (int y=0; y<4; y++){
                if (couleurJ == CelluleJeu[x][y].lireCouleurDuJeton()){
                    if ( couleurJ == CelluleJeu[x-1][y+1].lireCouleurDuJeton()){ 
                        if(couleurJ == CelluleJeu[x-2][y+2].lireCouleurDuJeton()){ 
                            if(couleurJ == CelluleJeu[x-3][y+3].lireCouleurDuJeton()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        for(int x=0; x<3; x++){
            for (int y=0; y<4; y++){
                if (couleurJ == CelluleJeu[x][y].lireCouleurDuJeton()){
                    if (couleurJ==CelluleJeu[x+1][y+1].lireCouleurDuJeton()){ 
                        if(couleurJ==CelluleJeu[x+2][y+2].lireCouleurDuJeton()){ 
                            if(couleurJ==CelluleJeu[x+3][y+3].lireCouleurDuJeton()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    
    
    public void tasserGrille(int colonne){
        for( int i=5; i>0 ; i--){
            if(CelluleJeu[i][colonne]==null){
                if(CelluleJeu[i - 1][colonne]!=null){
                    CelluleJeu[i][colonne] = CelluleJeu[i - 1][colonne];
                    CelluleJeu[i - 1][colonne] = null;
                }
                
            }
                
        }
    }
    
    public boolean colonneRemplie(int colonne){
        for( int i=0; i<6 ; i++){
            if(CelluleJeu[i][colonne].lireCouleurDuJeton()=="vide"){
                return false ;
            }
        }
        return true ;
    }
    
    public boolean placerDesintegrateur(int ligne,int colonne){
        if(CelluleJeu[ligne][colonne].presenceDesintegrateur()==true){
            return false ;
        }
        else{
            CelluleJeu[ligne][colonne].placerDesintegrateur() ;
            return true ;
        }
    }
    
    public boolean placerTrouNoir(int ligne,int colonne){
        if(CelluleJeu[ligne][colonne].presenceTrouNoir()==true){
            return false ;
        }
        else{
            CelluleJeu[ligne][colonne].placerTrouNoir() ;
            return true ;
        }
    }
    
    public boolean supprimerJeton(int Ligne ,int Colonne ){
        if(CelluleJeu[Ligne][Colonne]!=null ){    
            CelluleJeu[Ligne][Colonne]= null ;
            return true ;
        }
        return false ;
    }
    
    
    public Jeton recupererJeton(int lignevisee, int colonnevisee){
        CelluleJeu[lignevisee][colonnevisee].jetonCourant = null;
        return CelluleJeu[lignevisee][colonnevisee].jetonCourant ;
    }

}
