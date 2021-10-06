/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package convertisseur_corlay_nobili;

import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Convertisseur_Corlay_Nobili {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in) ;
        float temp;
	int conversion;
        System.out.println("Bonjour, saisissez une valeur :");
        temp = sc.nextFloat();
        System.out.println("Saisissez la conversion que vous souhaitez effectuer :\n1) De Celcius vers Kelvin\n2) De Kelvin vers Celcius\n3) De Farenheit Vers Celcius\n4) De Celcius Vers Farenheit\n5) De Farenheit Vers Kelvin\n6) De Kelvin Vers Farenheit");
        conversion = sc.nextInt();
        if (conversion==1) {
            System.out.println(temp +" degrés Celcius est égal à "+CelciusVersKelvin (temp)+" degrés Kelvin");
	}
        if (conversion==2) {
            System.out.println(temp +" degrés Kelvin est égal à "+KelvinVersCelcius (temp)+" degrés Celcius");
        }
        if (conversion==3) {
            System.out.println(temp +" degrés Farenheit est égal à "+FarenheitVersCelcius (temp)+" degrés Celcius");
        }
        if (conversion==4) {
            System.out.println(temp +" degrés Celcius est égal à "+ CelsiusVersFarenheit (temp)+" degrés Farenheit");
        }
        if (conversion==5) {
            System.out.println(temp +" degrés Farenheit est égal à "+FarenheitVersKelvin (temp)+" degrés Kelvin");
        }
        if (conversion==6) {
            System.out.println(temp +" degrés Kelvin est égal à "+KelvinVersFarenheit (temp)+" degrés Farenheit");
        }


    }
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
}