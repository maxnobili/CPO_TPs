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
    // creation de la grille de jeu avec 6 lignes et 7 colonnes
    Cellule [][] CelluleJeu = new Cellule [6][7];
    
    // creation de chaque cellule pour chaque case de la grille 
    public Grille(){
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                CelluleJeu[i][j]=new Cellule();
            }
        }
    }
    // part en bas de la colonne et remonte jusqu'a ce qu'on puisse ajouter un jeton et ajoute un jeton 
    public boolean ajouterJetonDansColonne(Jeton jeton, int ColonneJoueur){
        for (int i=0; i<6; i++){
            if (CelluleJeu[5-i][ColonneJoueur].affecterJeton(jeton) == true){
                return true ;
            }
        }
        return false ;
    }
    // parcourt toute la grille pour voir si il reste une cellule vide 
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
    // parcourt toute la grille et vide chaque cellule
    public void viderGrille(){
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                CelluleJeu[j][i] = null; 
            }
        }
    }
    // parcourt toute la grille               
    public void afficherGrilleSurConsole(){
        for( int i=0; i<6; i++){
            for( int j=0; j<7; j++){
                // regarde pour chaque cellule le contenant de celle-ci 
                // en fonction du contenant affiche un rond de la couleur associé à la valeur de la cellule
                if (CelluleJeu[i][j].presenceTrouNoir()==true && CelluleJeu[i][j].presenceDesintegrateur()==true){
                        System.out.print("\033[34m O");
                }
                else if (CelluleJeu[i][j].presenceTrouNoir()==true){
                    System.out.print("\033[34m O");
                }
                else if(CelluleJeu[i][j].presenceDesintegrateur()==true){
                    System.out.print("\033[32m O");
                }
                else if( lireCouleurDuJeton(i,j)=="rouge"){
                   System.out.print("\033[31m O");
                }  
                else if( lireCouleurDuJeton(i,j)=="jaune"){
                        System.out.print("\033[33m O");
                }
                else {
                    System.out.print("\033[30m O");
                }
            }
            System.out.print("\n");
        }    
    }
    // verifie pour une cellule si elle est vide ou pas 
    public boolean celluleOccupee(int LigneDonnee ,int ColonneDonnee){
        if( CelluleJeu[LigneDonnee][ColonneDonnee].lireCouleurDuJeton() != "vide" ){
            return true ;
        }
        else{
            return false ;
        }
    }
    
    public String lireCouleurDuJeton(int LigneDonnee ,int ColonneDonnee){
        return CelluleJeu[LigneDonnee][ColonneDonnee].lireCouleurDuJeton();
    }
    
    // verifie si le joueur est gagnant pour n'importe quelle combinaison de 4 jeton du même joueur aligné
    public boolean etreGagnantePourJoueur(Joueur J){
        // creation d'une variable qui a pour valeur la couleur du joueur pour verifier la couleur de la cellule et celle des cellules autour
        String couleurJ=J.couleur ;
        
        // verifie si il existe une ligne de 4 jetons du meme joueur dans la grille
        // on fixe alors une ligne et une colonne et on regarde pour les 3 cellules des colonnes suivantes si elles sont de la meme couleur
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
        // verifie si il existe une colonne de 4 jetons du meme joueur dans la grille
        // on fixe alors une ligne et une colonne et on regarde pour les 3 cellules des lignes suivantes si elles sont de la meme couleur
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
        // verifie si il existe une diagonale montante de 4 jetons du meme joueur dans la grille
        // on fixe alors une ligne et une colonne et on regarde pour les 3 cellules en diagonale vers le haut si elles sont de la meme couleur
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
        // verifie si il existe une diagonale descandante de 4 jetons du meme joueur dans la grille
        // on fixe alors une ligne et une colonne et on regarde pour les 3 cellules en diagonale vers le bas si elles sont de la meme couleur
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

    
    // regarde pour une colonne donnee si il y a une cellule vide suivis d'une cellule pleine au dessus de la cellule vide
    // si c'est le cas le jeton au dessus de la cellule vide est placé dans cette cellule
    // ceci est executé pour toute les cases de la colonne sauf celle tout en haut
    public void tasserGrille(int colonne){
        for( int i=5; i>=0 ; i--){
            if(CelluleJeu[i][colonne].jetonCourant==null){
                if(celluleOccupee(i+1 , colonne)== true ){
                    CelluleJeu[i][colonne].jetonCourant = CelluleJeu[i - 1][colonne].jetonCourant;
                    CelluleJeu[i - 1][colonne].jetonCourant = null;
                }
                
            }
                
        }
    }
    // regarde si il reste une case vide dans une colonne ou pas
    public boolean colonneRemplie(int colonne){
        for( int i=0; i<6 ; i++){
            if(CelluleJeu[i][colonne].lireCouleurDuJeton()=="vide"){
                return false ;
            }
        }
        return true ;
    }
    // place un desintagrateur pour une cellule donnée 
    public boolean placerDesintegrateur(int ligne,int colonne){
        if(CelluleJeu[ligne][colonne].presenceDesintegrateur()==true){
            return false ;
        }
        else{
            CelluleJeu[ligne][colonne].placerDesintegrateur() ;
            return true ;
        }
    }
    // place un trou noir dans une cellule donnée 
    public boolean placerTrouNoir(int ligne,int colonne){
        if(CelluleJeu[ligne][colonne].presenceTrouNoir()==true){
            return false ;
        }
        else{
            CelluleJeu[ligne][colonne].placerTrouNoir() ;
            return true ;
        }
    }
    // supprime le jeton d'une cellule donnée 
    public boolean supprimerJeton(int Ligne ,int Colonne ){
        if(CelluleJeu[Ligne][Colonne]!=null ){    
            CelluleJeu[Ligne][Colonne]= null ;
            return true ;
        }
        return false ;
    }
    
    // recupere le jeton d'une case donnée  
    public Jeton recupererJeton(int lignevisee, int colonnevisee){
        CelluleJeu[lignevisee][colonnevisee].jetonCourant = null;
        return CelluleJeu[lignevisee][colonnevisee].jetonCourant ;
    }

}
