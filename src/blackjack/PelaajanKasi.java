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
            }
            if(this.kortit.get(i).getArvo() == 1){ // asettaa ässän arvoksi 11
                summa += 11;
            }
            if (this.kortit.get(i).getArvo() > 1 && this.kortit.get(i).getArvo() < 10){ // antaa numerokorttien arvot järjestyksessä
                summa += this.kortit.get(i).getArvo();
            }
        }
        
        if (summa > 21 && this.kortit.size() == 2) {
            summa -= 10;
        }
//        for (int i = 0; i < this.kortit.size(); i++) {
//            Kortti kortti = this.kortit.get(i);
//            summa += kortti.getArvo();
//        }
//        if (summa > 21 && this.kortit.size() == 2) { //jos menee yli 21, vähentää summasta 10 ja muuttaa toisen ässän arvon numeroksi 1
//            summa -= 10;
//            String maa1 = this.kortit.get(0).getMaa();
//            String maa2 = this.kortit.get(1).getMaa();
//            Kortti kortti1 = new Kortti(11, maa1);
//            Kortti kortti2 = new Kortti(1, maa2);
//            this.kortit.clear();
//            this.kortit.add(kortti1);
//            this.kortit.add(kortti2);
//        }

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
    
    public String toString() {
        String kasi = "";
        for(int i=0; i<this.kortit.size(); i++) {
            kasi += this.kortit.get(i).toString() + "\n";
        }
        
        return kasi;
    }
}
