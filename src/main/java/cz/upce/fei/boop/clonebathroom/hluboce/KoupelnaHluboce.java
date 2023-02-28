package cz.upce.fei.boop.clonebathroom.hluboce;

import cz.upce.fei.boop.clonebathroom.MojeException;
import cz.upce.fei.boop.clonebathroom.Rozmer;
import cz.upce.fei.boop.clonebathroom.Vana;


/**
 * TODO Upravte třídu KoupelnaHluboce tak vyhověla testu a byla hluboce klonovatelná
 * TODO Při upravách třídy dodržujte strukturu třídy podle editor-fold
 */
public class KoupelnaHluboce implements Cloneable{

//<editor-fold defaultstate="collapsed" desc="instanční proměnný/atributy">
    private String nazevKupelny;
    private Rozmer rozmer;
    private Vana vana;
    
    
//</editor-fold>


//<editor-fold defaultstate="collapsed" desc="konstruktory">
    public KoupelnaHluboce(String nazevKupelny, Rozmer rozmer, Vana vana) {
        if( rozmer != null){
            if(nazevKupelny == null) throw new NullPointerException("Nevystavila se výjimka NullPointerException z důvodu null ve jménu koupelny"); 
            if(nazevKupelny == "") throw new MojeException("Nevystavila se výjimka MojeException"); 
            this.nazevKupelny = nazevKupelny;
            this.rozmer = rozmer;
            this.vana = vana;
        } else throw new NullPointerException("Nevystavila se výjimka NullPointerException z důvodu null v rozměru koupelny");
    }
    public KoupelnaHluboce(String nazevKupelny, double delka, double sirka, double vyska, Vana vana) {
        if( vana != null){
            this.nazevKupelny = nazevKupelny;
            rozmer = new Rozmer(delka, sirka, vyska);
            this.vana = vana;
        } else throw new NullPointerException("Nevystavila se výjimka NullPointerException z důvodu null ve parametru na vanu koupelny");
    }

//</editor-fold>


//<editor-fold defaultstate="collapsed" desc="metoda klonovani">
    public KoupelnaHluboce clone() throws CloneNotSupportedException{
        KoupelnaHluboce newKoupelnaHluboce = (KoupelnaHluboce) super.clone();
        newKoupelnaHluboce.vana = (Vana) vana.clone();
        return newKoupelnaHluboce;
    }
//</editor-fold>
    

//<editor-fold defaultstate="collapsed" desc="metoda toString">
    @Override
    public String toString() {
        return "KoupelnaHluboce{" + "nazevKupelny=" + nazevKupelny + ", rozmer=" + rozmer + ", vana=" + vana + '}';
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="metody get">
    public String getNazev() {
        return nazevKupelny;
    }

    public Rozmer getRozmer() {
        return rozmer;
    }

    public Vana getVana() {
        return vana;
    }

//</editor-fold>

   

    

}
