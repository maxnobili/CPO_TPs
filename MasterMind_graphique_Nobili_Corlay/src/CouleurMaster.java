/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maxim
 */

public class CouleurMaster {
    String Couleur ;
    String [] Tableaucouleur = {"jaune","rouge","vert","bleu","rose","blanc","orange","violet"};
    
    public CouleurMaster(int couleur){
        Couleur = Tableaucouleur[couleur] ;
    }
    public int AttribuerNbACouleur(String nb){
        int vreturn;
        for (int i = 0; i<=7;i++){
            if (Tableaucouleur[i].equals(nb)){
                vreturn = i;
                return vreturn;
            }
        }
        return 13;
    }
}