/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_convertisseurobjet_corlay_nobili;

/**
 *
 * @author maxim
 */
public class TP2_convertisseurObjet_CORLAY_NOBILI {

    
   public static float CelciusVersKelvin ( float tempC) {
        float tempK ;
        tempK = tempC + (273,15) ;
        return (tempK) ;
        
    }
    public static float KelvinVersCelcius ( float tempK) {
        float tempC;
        tempC = tempK-(273,15) ;
        return (tempC);
    }
    public static float FarenheitVersCelcius ( float tempF) {
        float tempC ;
        tempC = (5/9)*(tempF-32)  ;
        return (tempC);
    }
    public static float CelsiusVersFarenheit ( float tempC) {
        float tempF;
        tempF = tempC*(9/5) + 32;
        return (tempF);
    }
    public static float KelvinVersFarenheit ( float tempK) {
        float tempF;
        tempF = (tempK - (273,15))/(5/9) + (32) ;
        return (tempF);
    }
    public static float FarenheitVersKelvin ( float tempF) {
        float tempK;
        tempK = (tempF - 32)*(5/9) + (273,15) ;
        return (tempK);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
    }
    
}
