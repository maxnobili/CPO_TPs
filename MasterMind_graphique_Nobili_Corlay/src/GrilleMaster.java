/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maxim
 */
public class GrilleMaster {
    CouleurMaster couleurmaster;
    
    CelluleMaster [][] grilleJeu = new CelluleMaster [12][4];
    
    public GrilleMaster(){ 
        for (int i=0;i<=3;i++){
            for (int j=0;j<=11;j++){
                grilleJeu[j][i] = new CelluleMaster();
            }
        } 
    }
    
    public boolean ajouterJeton(int Lignejoue,int Colonnejoue){
        if ("vide".equals(grilleJeu[11-Lignejoue][Colonnejoue].lireCouleurPion())){
            return true ;
        }
        return false ;
    }
    
    public void afficherGrilleSurConsole(){
        for( int i=0; i<=11; i++){
            System.out.print("\n");
            for( int j=0; j<=3; j++){
                if (lireCouleurDuPion(i,j)== "rouge"){
                        System.out.print("R ");
                }
                if (lireCouleurDuPion(i,j)== "orange"){
                        System.out.print("O ");
                }
                if (lireCouleurDuPion(i,j)== "bleu"){
                        System.out.print("B ");
                }
                if (lireCouleurDuPion(i,j)== "blanc"){
                        System.out.print("Blc ");
                }
                if (lireCouleurDuPion(i,j)== "rose"){
                        System.out.print("Re ");
                }
                if (lireCouleurDuPion(i,j)== "vert"){
                        System.out.print("V ");
                }
                if (lireCouleurDuPion(i,j)== "violet"){
                        System.out.print("Vi ");
                }
                if (lireCouleurDuPion(i,j)== "jaune"){
                        System.out.print("J ");
                }
                if (lireCouleurDuPion(i,j)== "vide"){
                        System.out.print("- ");
                }
            }
        }
    }
    public String lireCouleurDuPion(int LigneDonnee ,int ColonneDonnee){
        return grilleJeu[LigneDonnee][ColonneDonnee].lireCouleurPion();
    }
}
