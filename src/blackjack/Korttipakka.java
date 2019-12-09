
package blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author s1901265
 */
public class Korttipakka {
    private ArrayList<Kortti> pakka = new ArrayList<>();
    
    
    //konstruktori korttipakan jokaisen kortin luontiin, ensin maat ja sitten numerot
    public Korttipakka(){ //maiden luonti korttipakkaan
        luoMaa("pata");
        luoMaa("risti");
        luoMaa("hertta");
        luoMaa("ruutu");
    }
    private void luoMaa(String maa){
        for(int i=1; i < 14; i++){ //korttinumeroiden luonti ja ehdot kuvakortille ja ässälle
            Kortti numerokortti = new Kortti(i, maa);
            this.pakka.add(numerokortti);
        }
    }
    
    //sekoittaa korttipakan
    public void sekoitaPakka() {
        Collections.shuffle(pakka);
    }
    
    //antaa pakan päällimmäisen kortin ja poistaa sen pakasta
    public Kortti jaaKortti(){
        Kortti kortti;
        kortti = this.pakka.get(0);
        this.pakka.remove(0);
        return kortti;
    }
}
