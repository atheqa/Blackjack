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
        
        //jakaa pelaajalle kaksi korttia
        System.out.println("===== PELAAJAN VUORO =====");
        //kasi.otaKortti(pakka.jaaKortti());
        //kasi.otaKortti(pakka.jaaKortti());
        kasi.otaKortti(new Kortti(8, "pata"));      // TESTAUKSEEN, muuta arvo ja maa
        kasi.otaKortti(new Kortti(8, "ruutu"));     // TESTAUKSEEN, muuta arvo ja maa
        
        //selvittää kädessä olevien korttien summan
        int summa = kasi.selvitaSumma();

        System.out.println(kasi);
        System.out.println("Korttien summa on " + summa);
        //tarkistaa onko kahden ensimmäisen kortin tulos blackjack
        if(kasi.onkoBlackjack()) {
            System.out.println("Blackjack saavutettu!");
            return;
        }
        //kysyy pelaajalta haluaako hän lisää kortteja, jos summa on alle 21
        while (summa < 21) {
            System.out.println("Haluatko lisäkortin? (k/e)");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("k")) {    // ehtolause, joka tarkistaa onko vastaus kyllä, annetaan kortti
                kasi.otaKortti(pakka.jaaKortti());
            } else {
                break;
            }
            
            summa = kasi.selvitaSumma();
            System.out.println(kasi);
            System.out.println("Korttien summa on: " + summa);
        }
        
        if(summa > 21) {
            System.out.println("Hävisit!");
            return;
        }

        //jakajan vuoro
        System.out.println("\n===== JAKAJA VUORO =====");
        //Kortti aloitusKortti1 = pakka.jaaKortti();
        //Kortti aloitusKortti2 = pakka.jaaKortti();
        jakaja.otaKortti(new Kortti(3, "pata"));            // TESTAUKSEEN, muuta arvo ja maa
        jakaja.otaKortti(new Kortti(3, "ruutu"));           // TESTAUKSEEN, muuta arvo ja maa
        
        int jakajanSumma = jakaja.selvitaSumma();
        System.out.println("Jakajan Käsi: " + jakajanSumma);
        
        while (jakajanSumma < 15){
            jakaja.otaKortti(pakka.jaaKortti());
            jakajanSumma = jakaja.selvitaSumma();
            System.out.println("Jakaja Käsi: " + jakajanSumma);
        }
        
        System.out.println("Jakajan kortteja on: " + jakaja.size());
        
        System.out.println("\n===== LOPPUTULOS =====");
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
        
        System.out.println("\n===== PELAAJAN KÄSI =====");
        System.out.println(kasi);
        
        System.out.println("===== JAKAJAN KÄSI =====");
        System.out.println(jakaja);
        
        System.out.println("===== KÄSIEN SUMMAT =====");
        System.out.println("Pelaajan korttien summa on: " + summa);
        System.out.println("Jakajan korttien summa on " + jakajanSumma);
    }
}
