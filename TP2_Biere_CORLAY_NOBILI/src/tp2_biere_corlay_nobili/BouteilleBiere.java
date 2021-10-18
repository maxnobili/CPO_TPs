/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP2_Biere_CORLAY_NOBILI;

/**
 *
 * @author adrie
 */
public class BouteilleBiere {
    String Nom;
    double degreAlcool;
    String brasserie;
    boolean ouverte;
    
    @Override
    public String toString() {
        String chaine_a_retourner;
        chaine_a_retourner = Nom + " (" + degreAlcool + " degrés) Ouverte ? ";
        if (ouverte == true ) chaine_a_retourner += "oui" ;
        else chaine_a_retourner += "non" ;
          return chaine_a_retourner ;
        }

    public void lireEtiquette() {
        System.out.println("Bouteille de " + Nom +" (" + degreAlcool + " degres) \nBrasserie : " + brasserie ) ;
    }
    public BouteilleBiere(String unNom, double unDegre, String uneBrasserie, boolean uneouverte) {
        Nom = unNom;
        degreAlcool = unDegre;
        brasserie = uneBrasserie;
        ouverte = uneouverte;
    }
    public void Decapsuler(){
        if (ouverte == false){
            ouverte = true;
            System.out.println(ouverte + ", la biere est ouverte");
        }
        else{
            System.out.println("Erreur : biere déjà ouverte");
            ouverte = false;
            System.out.println(ouverte);
        }
        
    }

}