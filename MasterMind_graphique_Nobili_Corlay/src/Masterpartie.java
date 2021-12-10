
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maxim
 */
public class Masterpartie {
    int R = 11;
    int J = 23;
    int B = 47;
    int Blc = 95;
    int Re = 83;
    int Vi = 71;
    int V = 35;
    int O = 59;
    int valeurcouleur = 0;
    String [] Listepions = new String[96];
    CouleurMaster couleurmaster = new CouleurMaster(0); 
    String [] tabbase = new String [4];
    Scanner scanner = new Scanner(System.in);
    GrilleMaster grillejeu;

    
    public void initialiserPartie(){
        
        grillejeu = new GrilleMaster();
        Random rdc = new Random();
        for (int i =0 ; i<=3 ; i++){
            int nbcouleur;
            nbcouleur = rdc.nextInt(7);
            tabbase [i] = couleurmaster.Tableaucouleur[nbcouleur];  
            //System.out.println(tabbase[i]);
        }
        affecterCouleur();
        

    }
    public void debuterPartie(){
        String [] CouleurJoue = new String[4];
        for (int i = 0; i<=11 ; i++){
            int nbcouleurcom = 0;
            int nbplacecom = 0;
            int nbcouleur = 0;
            String b = Listepions[1];
            String couleur1;
            String couleur2;
            String couleur3;
            String couleur4;
            System.out.println("Entrez la premiere couleur");
            couleur1 = scanner.nextLine();
            CouleurJoue[0] = couleur1;
            System.out.println("Entrez la seconde couleur");
            couleur2 = scanner.nextLine();
            CouleurJoue[1] = couleur2;
            System.out.println("Entrez la troisieme couleur");
            couleur3 = scanner.nextLine();
            CouleurJoue[2] = couleur3;
            System.out.println("Entrez la quatrieme couleur");
            couleur4 = scanner.nextLine();
            CouleurJoue[3] = couleur4;
            
            
            
         

            for (int colonnejoue = 0; colonnejoue<=3; colonnejoue++){
                nbcouleur = couleurmaster.AttribuerNbACouleur(CouleurJoue[colonnejoue]);

                if (grillejeu.ajouterJeton(i, colonnejoue) == true){
                    grillejeu.grilleJeu[i][colonnejoue].pionCourant = couleurmaster.Tableaucouleur[nbcouleur];
                    
                }
            }
            grillejeu.afficherGrilleSurConsole();
           // Essaie sans celluleMASTER juste avec une grille de couleurmaster
            
            for (int k = 0; k <=3; k++){
                System.out.println ("nbp" + nbplacecom);
                if (grillejeu.grilleJeu[i][k].pionCourant.equals(tabbase [k])){
                            nbplacecom = nbplacecom + 1;
                }
                else{
                    for (int q = 0; q <=3; q++){  
                        System.out.println ("nbc" + nbcouleurcom);
                        if (grillejeu.grilleJeu[i][k].pionCourant.equals(tabbase [q])){
                            nbcouleurcom++;
                            break;
                        }    
                    }
                }
            }
            if (nbplacecom == 4){
                System.out.println("Vous avez gagné!!");
                break;
            }

            System.out.println("nb de couleur pareil:" + nbcouleurcom);
            System.out.println("nb de place pareil:" + nbplacecom);

        }
    }
    public void affecterCouleur(){
        
        for (int i = 0; i<=11;i++){
            Listepions[i] = "rouge";
        }
        for (int i = 12; i<=23;i++){
            Listepions[i] = "jaune";
        }
        for (int i = 24; i<=35;i++){
            Listepions[i] = "vert";
        }
        for (int i = 36; i<=47;i++){
            Listepions[i] = "bleu";
        }
        for (int i = 48; i<=59;i++){
            Listepions[i] = "orange";
        }
        for (int i = 60; i<=71;i++){
            Listepions[i] = "violet";
        }
        for (int i = 72; i<=83;i++){
            Listepions[i] = "rose";
        }
        for (int i = 84; i<=95;i++){
            Listepions[i] = "blanc";
        }
    }
}

