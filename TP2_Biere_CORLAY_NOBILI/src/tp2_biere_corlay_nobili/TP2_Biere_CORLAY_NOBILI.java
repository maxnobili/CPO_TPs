/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TP2_Biere_CORLAY_NOBILI;

/**
 *
 * @author adrie
 */
public class TP2_Biere_CORLAY_NOBILI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BouteilleBiere unBiere = new BouteilleBiere("Cuvée des trolls",7.0,"Dubuisson",true);
        System.out.println(unBiere);
        unBiere.lireEtiquette();
        unBiere.Decapsuler();
        
        BouteilleBiere deuxBiere = new BouteilleBiere("Leffe",6.6,"Abbaye de Leffe",false);
        System.out.println(deuxBiere);
        deuxBiere.lireEtiquette();
        deuxBiere.Decapsuler();
        
        BouteilleBiere troisBiere = new BouteilleBiere("Chouffe",5.3,"Abbaye de Chouffe",true);
        System.out.println(troisBiere);
        troisBiere.lireEtiquette();
        troisBiere.Decapsuler();
        
        BouteilleBiere quatreBiere = new BouteilleBiere("Amsterdammer",12.5,"Amsterdam",true);
        System.out.println(quatreBiere);
        quatreBiere.lireEtiquette();
        quatreBiere.Decapsuler();
        
        BouteilleBiere cinqBiere = new BouteilleBiere("Heineken",3.2,"Abbaye de Heineken",true);
        System.out.println(cinqBiere);
        cinqBiere.lireEtiquette();
        cinqBiere.Decapsuler();
    }
     
}