package blackjack;

import java.util.ArrayList;

/**
 *
 * @author s1901265
 */
public class PelaajanKasi {

    private ArrayList<Kortti> kortit = new ArrayList<>();

    public void otaKortti(Kortti kortti) {
        this.kortit.add(kortti);
    }

    public int selvitaSumma() { //selvitetään kädessä olevien korttien arvo
        
        int summa = 0;
        
        for (int i = 0; i < this.kortit.size(); i++) {
            if(this.kortit.get(i).getArvo() > 9){ //asettaa kaikkien kuvakorttien arvoksi 10
                summa += 10;
            } else if(this.kortit.get(i).getArvo() == 1){ // asettaa ässän arvoksi 11
                summa += 11;
            } else if (this.kortit.get(i).getArvo() > 1 && this.kortit.get(i).getArvo() < 10){ // antaa numerokorttien arvot järjestyksessä
                summa += this.kortit.get(i).getArvo();
            }
        }
        
        if (summa > 21 && this.kortit.size() == 2) {
            summa -= 10;
        }

        return summa;
    }
    
    public boolean onkoBlackjack(){ //tarkistaa onko pelaajan käsi blackjack
        if(this.kortit.size() > 2){
            return false;
        }

        int summa = 0;
        summa += this.kortit.get(0).getArvo();
        summa += this.kortit.get(1).getArvo();

        if(summa == 21){
            return true;
        }
        return false;
    }
    
    public int size() {
        return this.kortit.size();
    }
    
    public String toString() {
        String kasi = "";
        for(int i=0; i<this.kortit.size(); i++) {
            kasi += this.kortit.get(i).toString() + "\n";
        }
        
        return kasi;
    }
}
