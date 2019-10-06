package blackjack;

import java.util.Scanner;

/**
 *
 * @author s1901265
 */
public class Blackjack {

    public static void main(String[] args) {
        Korttipakka pakka = new Korttipakka();
        PelaajanKasi kasi = new PelaajanKasi();
        PelaajanKasi jakaja = new PelaajanKasi();
        
        Scanner lukija = new Scanner(System.in);
        
        //pelin aloitus ja pelaajan vuoro
        pakka.sekoitaPakka();

        kasi.otaKortti(pakka.jaaKortti());
        kasi.otaKortti(pakka.jaaKortti());
        
        int summa = kasi.selvitaSumma();

        System.out.println("Korttien summa on " + summa);
        
        if(kasi.onkoBlackjack()) {
            System.out.println("Blackjack saavutettu!");
            return;
        }

        while (summa < 21) {
            System.out.println("Haluatko lisäkortin? (k/e)");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("k")) {    // ehtolause, joka tarkistaa onko vastaus kyllä, annetaan kortti
                kasi.otaKortti(pakka.jaaKortti());
            } else {
                break;
            }
            
            summa = kasi.selvitaSumma();
            System.out.println("Korttien summa on: " + summa);
        }
        
        if(summa > 21) {
            System.out.println("Hävisit!");
            return;
        }

        //jakajan vuoro
        jakaja.otaKortti(pakka.jaaKortti());
        jakaja.otaKortti(pakka.jaaKortti());
        int jakajanSumma = jakaja.selvitaSumma();
        
        while (jakajanSumma < 15){
            jakaja.otaKortti(pakka.jaaKortti());
            jakajanSumma += jakaja.selvitaSumma();
        }
        
        if(jakajanSumma > 21) {
            System.out.println("Jakaja hävisi!");
            return;
        }
        
        if(summa > jakajanSumma) {
            System.out.println("Voitit!");
        } else if(summa < jakajanSumma) {
            System.out.println("Hävisit!");
        } else {
            System.out.println("Tasapeli!");
        }
        
        System.out.println("Pelaajan korttien summa on: " + summa);
        System.out.println("Jakajan korttien summa on " + jakajanSumma);
    }
}
