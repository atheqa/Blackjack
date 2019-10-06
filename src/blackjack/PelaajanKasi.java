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

    public int selvitaSumma() {
        int summa = 0;
        for (int i = 0; i < this.kortit.size(); i++) {
            Kortti kortti = this.kortit.get(i);
            summa += kortti.getArvo();
        }
        if (summa > 21 && this.kortit.size() == 2) {
            summa -= 10;
            String maa1 = this.kortit.get(0).getMaa();
            String maa2 = this.kortit.get(1).getMaa();
            Kortti kortti1 = new Kortti(11, maa1);
            Kortti kortti2 = new Kortti(1, maa2);
            this.kortit.clear();
            this.kortit.add(kortti1);
            this.kortit.add(kortti2);
        }
        return summa;
        }
        public boolean onkoBlackjack(){
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
}
