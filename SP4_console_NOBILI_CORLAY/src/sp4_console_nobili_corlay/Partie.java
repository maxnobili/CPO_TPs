/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_nobili_corlay;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Partie { 
    
    Scanner scanner = new Scanner(System.in);
    
    // creation du tableau pour repertorier le nom de chaque joueur
    Joueur [] ListeJoueurs = new Joueur [2];
    
    // creation des attributs utiles à la classe partie
    Joueur joueurCourant;

    Grille grilleJeu;
    
    // variable pour les jetons restants
    int jetrest = 0;

  
    // affectation des noms des joueurs a leur place dans le tableau
    public Partie(Joueur joueur1,Joueur joueur2){

       ListeJoueurs[0] = joueur1;

       ListeJoueurs[1] = joueur2;

    }

  

    public void initialiserPartie(){

        grilleJeu = new Grille();
        
        // placement des deux trous noirs et desintegrateurs qui doivent être sur la meme case 
        Random rdm = new Random();
        int lignetnDs = rdm.nextInt(5) ;
        int colonnetnDs = rdm.nextInt(6) ;
        grilleJeu.placerTrouNoir(lignetnDs, colonnetnDs);
        grilleJeu.placerDesintegrateur(lignetnDs, colonnetnDs);
        int lignetnDs2 = rdm.nextInt(5) ;
        int colonnetnDs2 = rdm.nextInt(6) ;
        grilleJeu.placerTrouNoir(lignetnDs2, colonnetnDs2);
        grilleJeu.placerDesintegrateur(lignetnDs2, colonnetnDs2);

        // boucle qui affecte trois trous noirs en verifiant qu'il n'y est pas deja un trou noir deja present 
        for (int i = 0 ;i <= 2; i++){
            
            Random tn = new Random();
            
            int lignetn = tn.nextInt(5) ;

            int colonnetn = tn.nextInt(6) ;
            
            if(grilleJeu.CelluleJeu[lignetn][colonnetn].presenceTrouNoir()==true){
                while(grilleJeu.CelluleJeu[lignetn][colonnetn].presenceTrouNoir()==true){

                    lignetn = tn.nextInt(5) ;

                    colonnetn = tn.nextInt(6) ;
                }
                grilleJeu.placerTrouNoir(lignetn, colonnetn);
            }
            else{
                grilleJeu.placerTrouNoir(lignetn, colonnetn);
            }
        } 
        
        // boucle qui affecte trois trous desintegrateurs en verifiant qu'il n'y est pas deja un trou noir ou un desintegrateur deja present 
        for (int i = 0 ;i <= 2; i++){

            Random ds = new Random();

            int ligneds = ds.nextInt(5) ;

            int colonneds = ds.nextInt(6) ;
            
            if(grilleJeu.CelluleJeu[ligneds][colonneds].presenceDesintegrateur()==true || grilleJeu.CelluleJeu[ligneds][colonneds].presenceTrouNoir()==true){
                while(grilleJeu.CelluleJeu[ligneds][colonneds].presenceDesintegrateur()==true){

                    ligneds = ds.nextInt(5) ;

                    colonneds = ds.nextInt(6) ;
                }
                grilleJeu.placerDesintegrateur(ligneds, colonneds);
            }
            else{
                grilleJeu.placerDesintegrateur(ligneds, colonneds);
            }
        }
        // attribution d'une couleur pour chaque joueur
        attribuerCouleursAuxJoueurs();
        
        // donne 21 jeton de la couleur du joueur a chaque joueur
        for(int i=0; i<21 ; i++){

           ListeJoueurs[0].ListeJetons[i] = new Jeton(ListeJoueurs[0].couleur);

           ListeJoueurs[1].ListeJetons[i] = new Jeton(ListeJoueurs[1].couleur);

        }

        grilleJeu.afficherGrilleSurConsole();

    }

  

    public void debuterPartie(){
        
        // choisi aleatoirement quel joueur va commencer
        Random rn = new Random();

        int jdep = rn.nextInt(1) ;

        if (jdep == 0){

           joueurCourant = ListeJoueurs[0];

        }

        if (jdep == 1){

           joueurCourant = ListeJoueurs[1];

        }

        // boucle pour executer les tours de chaque jouueur
        while (grilleJeu.etreGagnantePourJoueur(joueurCourant) == false && grilleJeu.etreRemplie() == true){
            
            // affichage pour savoir qui commence et quelles options s'offrent a lui
            System.out.println(joueurCourant.nom);
            System.out.println(" Vous avez deux choix possibles, jouer un jeton (1) ou recuperer un jeton (2) ou utiliser un désintégrateur (3).");
            System.out.println(" Tapez le chiffre correspond à l'action que vous souhaitez éffectuer");
            
            // demande au joueur quel choix veut il faire
            int choix = scanner.nextInt();
            
            // choix 1 : placer un jeton
            if (choix == 1){
            
                System.out.println(joueurCourant.nom);
                
                System.out.println("Donnez la colonne dans laquelle vous souhaitez jouer:");
                
                //demande la colonne ou on souhaite jouer
                int colonne = scanner.nextInt();
                
                // verification si la colonne choisie est en dehors du tableau et si l colonne est remplie
                if (colonne != 0 && colonne != 1 && colonne != 2 && colonne != 3 && colonne != 4 && colonne != 5 && colonne != 6 ){

                    System.out.println("Vous avez commit l'irréparable, la colonne n'existe pas...Réessayez");

                    continue;
                }
                if (grilleJeu.colonneRemplie(colonne) == true){

                    System.out.println("La colonne est remplie");

                    continue;
                }

                // boucle qui enleve un jeton au joueur courant si il lui en reste un
                for (int i = 20 ; i > 0 ; i--){
                    if (joueurCourant.ListeJetons[i] != null){

                        jetrest = i;

                        joueurCourant.ListeJetons[jetrest] = null;

                        break;

                    }

                }
                Jeton jeton = joueurCourant.ListeJetons[jetrest-1];

                // 
                for(int i=5; i>=0; i--){

                    if (grilleJeu.celluleOccupee(i , colonne)== false && grilleJeu.CelluleJeu[i][colonne].presenceTrouNoir() == false ){
                        grilleJeu.ajouterJetonDansColonne(jeton, colonne);
                        if( grilleJeu.CelluleJeu[i][colonne].presenceDesintegrateur() == true){
                            joueurCourant.nombreDesintegrateurs += 1 ;
                            grilleJeu.CelluleJeu[i][colonne].desintegrateur = false ; 
                        }
                        grilleJeu.afficherGrilleSurConsole();
                        break;
                    }
                    if(grilleJeu.CelluleJeu[i][colonne].presenceTrouNoir() == true){

                        grilleJeu.CelluleJeu[i][colonne].activerTrouNoir();
                        grilleJeu.afficherGrilleSurConsole();

                        break;

                    }

                }


                if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == true){

                    break;
                }

                if (joueurCourant == ListeJoueurs[1]){

                    joueurCourant = ListeJoueurs[0];

                }

                else{

                    joueurCourant = ListeJoueurs[1];

                }
            }
            if (choix == 2){              
                System.out.println(" Dans quelle colonne souhaitez vous récuperer votre jeton?");
                int colonner = scanner.nextInt();
                System.out.println(" Dans quelle ligne souhaitez vous récuperer votre jeton?");
                int ligner = scanner.nextInt();
                if (colonner != 0 && colonner != 1 && colonner != 2 && colonner != 3 && colonner != 4 && colonner != 5 && colonner != 6 ){
                    System.out.println("Vous avez commit l'irréparable, la colonne n'existe pas...Réessayez");
                    continue;
                }
                if (ligner != 0 && ligner != 1 && ligner != 2 && ligner != 3 && ligner != 4 && ligner != 5){
                    System.out.println("Vous avez commit l'irréparable, la ligne n'existe pas...Réessayez");
                    continue;
                }
                if (grilleJeu.celluleOccupee(ligner , colonner)== false){
                    System.out.println("Il n'y a pas de jeton dans cette case");
                    continue;
                }
                grilleJeu.CelluleJeu[ligner][colonner].recupererJeton();
                for (int i = 0 ; i <= 20 ; i++){
                    if (joueurCourant.ListeJetons[i] == null){
                        jetrest = i;
                        Jeton jeton = joueurCourant.ListeJetons[jetrest-1];
                        joueurCourant.ListeJetons[jetrest] = jeton;
                        break;
                    }
                }
                
                grilleJeu.CelluleJeu[ligner][colonner].supprimerJeton();
                grilleJeu.tasserGrille(colonner);
                grilleJeu.afficherGrilleSurConsole();
                
                if (joueurCourant == ListeJoueurs[1]){

                    joueurCourant = ListeJoueurs[0];

                }

                else{

                    joueurCourant = ListeJoueurs[1];

                }
            }
            if (choix==3){
                
                System.out.println(" Dans quelle colonne souhaitez vous désintégrer un jeton?");
                int colonnedes = scanner.nextInt();
                System.out.println(" Dans quelle ligne souhaitez vous désintégrer un jeton?");
                int lignedes = scanner.nextInt();
                
                if (colonnedes != 0 && colonnedes != 1 && colonnedes != 2 && colonnedes != 3 && colonnedes != 4 && colonnedes != 5 && colonnedes != 6 ){
                    System.out.println("Vous avez commit l'irréparable, la colonne n'existe pas...Réessayez");
                    continue;
                }
                if (lignedes != 0 && lignedes != 1 && lignedes != 2 && lignedes != 3 && lignedes != 4 && lignedes != 5){
                    System.out.println("Vous avez commit l'irréparable, la ligne n'existe pas...Réessayez");
                    continue;
                }
                if (grilleJeu.celluleOccupee(lignedes , colonnedes)== false && grilleJeu.CelluleJeu[lignedes][colonnedes].lireCouleurDuJeton() == joueurCourant.couleur){
                    System.out.println("Vous ne pouvez choisir qu'un jeton adversaire !");
                    continue;
                }
                
                grilleJeu.CelluleJeu[lignedes][colonnedes].supprimerJeton();
                grilleJeu.tasserGrille(colonnedes);
                grilleJeu.afficherGrilleSurConsole();
                joueurCourant.utiliserDesintegrateur() ;
                
                if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == true){
                    
                    if (joueurCourant == ListeJoueurs[1]){
                        joueurCourant = ListeJoueurs[0] ;
                    }
                    else{
                        joueurCourant = ListeJoueurs[1];
                    }
                    
                    if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == false){
                        break;
                    }
                }
                
                if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == false){
                    
                    if (joueurCourant == ListeJoueurs[1]){
                        joueurCourant = ListeJoueurs[0] ;
                    }
                    else{
                        joueurCourant = ListeJoueurs[1];
                    }
                    
                    if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == true){
                        break;
                    }
                }
                
                if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == true){
                    
                    if (joueurCourant == ListeJoueurs[1]){
                        joueurCourant = ListeJoueurs[0] ;
                    }
                    else{
                        joueurCourant = ListeJoueurs[1];
                    }
                    
                    if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == true){
                        if (joueurCourant == ListeJoueurs[1]){
                            joueurCourant = ListeJoueurs[0] ;
                        }
                        else{
                            joueurCourant = ListeJoueurs[1];
                        }
                        System.out.println(joueurCourant+" a perdu car il a fait une faute de jeu !!!! ");
                        break;
                    }
                }
                
                
                if (joueurCourant == ListeJoueurs[1]){
                    joueurCourant = ListeJoueurs[0] ;
                }
                else{
                    joueurCourant = ListeJoueurs[1];
                }
            }
        }

        if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == true){

            if (joueurCourant == ListeJoueurs[1]){

                System.out.println("Le gagnant est " + ListeJoueurs[0].nom);

            }

            if (joueurCourant == ListeJoueurs[0]){

                System.out.println("Le gagnant est " + ListeJoueurs[1].nom);

            }
        }
    }   

    

  

    public void attribuerCouleursAuxJoueurs(){

        Random rn = new Random();

        int temp = rn.nextInt(2) ;

        if (temp == 1){

            ListeJoueurs[0].couleur = "rouge";

            ListeJoueurs[1].couleur = "jaune";

        }

        if (temp==0){

            ListeJoueurs[0].couleur = "jaune";

            ListeJoueurs[1].couleur = "rouge";

        }
    }

}


