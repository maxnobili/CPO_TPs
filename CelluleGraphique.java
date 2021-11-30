/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetp4;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 *
 * @author adrie
 */
public class CelluleGraphique extends JButton {
    Cellule celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_trounoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    
    
    
    public CelluleGraphique (Cellule uneCellule){
        celluleAssociee = uneCellule;
    }
    
    @Override
    public void paintComponent (Graphics G) {
        super.paintComponent(G);
        if (celluleAssociee.presenceTrouNoir() == true){
            setIcon(img_trounoir);
        }
        else if(celluleAssociee.presenceDesintegrateur() == true){
            setIcon(img_desint);
        }
        else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            switch(couleur_jeton){
                case "vide":
                    setIcon(img_vide);
                    break;
                case "rouge":
                    setIcon(img_rouge);
                    break;
                case "jaune":
                    setIcon(img_jaune);
                    break;
            }
        }
    }
}
