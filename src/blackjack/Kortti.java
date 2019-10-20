
package blackjack;

/**
 *
 * @author s1901265
 */
public class Kortti {
    private int arvo;
    private String maa;
    
    //konstruktori
    public Kortti(int arvo, String maa){
        this.arvo = arvo;
        this.maa = maa;
    }
    
    //get ja set arvot molemmille atribuuteille
    public int getArvo(){
        return arvo;
    }
    public void setArvo(int arvo){
        this.arvo = arvo;
    }
    
    public String getMaa(){
        return maa;
    }
    public void setMaa(String maa){
        this.maa = maa;
    }
    
    //toString metodi
    public String toString() {
        return "Arvo: "+this.arvo+ " Maa: "+this.maa;
    }
    
}
