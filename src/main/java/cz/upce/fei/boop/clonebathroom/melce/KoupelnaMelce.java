package cz.upce.fei.boop.clonebathroom.melce;

import cz.upce.fei.boop.clonebathroom.MojeException;
import cz.upce.fei.boop.clonebathroom.Rozmer;
import cz.upce.fei.boop.clonebathroom.Vana;



/**
 * TODO Upravte třídu KoupelnaMelce tak vyhověla testu a byla mělce klonovatelná
 * TODO Při upravách třídy dodržujte strukturu třídy podle editor-fold
 */
public class KoupelnaMelce implements Cloneable  {

//<editor-fold defaultstate="collapsed" desc="instanční proměnný/atributy">
private String nazevKoupelny;
private Rozmer rozmer;
private Vana vana;


//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="konstruktory">
    public KoupelnaMelce(String nazevKoupelny, Rozmer rozmer, Vana vana) {
        if(rozmer == null) throw new NullPointerException("Nevystavila se výjimka NullPointerException z důvodu null v rozměru koupelny");
        if(nazevKoupelny == null) throw new NullPointerException("Nevystavila se výjimka NullPointerException z důvodu null ve jménu koupelny");
        if (nazevKoupelny == "") throw new MojeException("Nevystavila se výjimka MojeException");
        this.nazevKoupelny = nazevKoupelny;
        this.rozmer = rozmer;
        this.vana = vana;
    }

    public KoupelnaMelce(String nazevKoupelny, double delka, double sirka, double vyska, Vana vana) {
        if( vana == null) throw new NullPointerException("Nevystavila se výjimka NullPointerException z důvodu null ve parametru na vanu koupelny");
        this.nazevKoupelny = nazevKoupelny;
        rozmer = new Rozmer (delka, sirka, vyska);
        this.vana = vana;
    }
    


//</editor-fold>    


//<editor-fold defaultstate="collapsed" desc="klonování">
    public KoupelnaMelce clone() throws CloneNotSupportedException{
        return (KoupelnaMelce) super.clone();
    }
//</editor-fold>
    


//<editor-fold defaultstate="collapsed" desc="metoda toString">
@Override
    public String toString() {
        return "KoupelnaMelce{" + "nazevKoupelny=" + nazevKoupelny + ", rozmer=" + rozmer + ", vana=" + vana + '}';
    }

//</editor-fold>    
    
//<editor-fold defaultstate="collapsed" desc="Metody get/set ">
 public String getNazev() {
        return nazevKoupelny;
    }

    public void setNazev(String nazevKoupelny) {
        this.nazevKoupelny = nazevKoupelny;
    }

    public Rozmer getRozmer() {
        return rozmer;
    }

    public void setRozmer(Rozmer rozmer) {
        this.rozmer = rozmer;
    }

    public Vana getVana() {
        return vana;
    }

    public void setVana(Vana vana) {
        this.vana = vana;
    }
//</editor-fold>

   

    

    
}
