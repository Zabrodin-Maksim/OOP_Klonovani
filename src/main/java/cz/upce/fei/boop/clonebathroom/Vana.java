package cz.upce.fei.boop.clonebathroom;

import java.util.Objects;

/*
 * TODO Upravte třídu Vana, tak vyhověla testu a byla klonovatelná
 * TODO Při upravách třídy dodržujte strukturu třídy podle editor-fold
//<editor-fold defaultstate="collapsed" desc="Konstruktory">
 */
public class Vana implements Cloneable {

//<editor-fold defaultstate="collapsed" desc="Instanční proměnný/atributy">
//</editor-fold>


private String nazevVany;
private Rozmer rozmer;
//</editor-fold>

public Vana clone() throws CloneNotSupportedException{
   return (Vana) super.clone();
}
//<editor-fold defaultstate="collapsed" desc="toString">
  @Override
    public String toString() {
        return "Vana " + nazevVany + "{" + rozmer + ", reference=" + super.toString() + '}';
    }
    
//</editor-fold>


//<editor-fold defaultstate="collapsed" desc="Metody get">
public String getNazevVany() {
        return nazevVany;
    }

    public Rozmer getRozmer() {
        return rozmer;
    }
//</editor-fold>    

//<editor-fold defaultstate="collapsed" desc="Metody equals a hashCode ">
    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vana other = (Vana) obj;
        if (!Objects.equals(this.nazevVany, other.nazevVany)) {
            return false;
        }
        return Objects.equals(this.rozmer, other.rozmer);
    }
//</editor-fold>

    public Vana(String nazevVany, Rozmer rozmer) {
        if(rozmer != null){
            this.nazevVany = nazevVany;
            this.rozmer = rozmer;
        } else throw new NullPointerException("hodnota jednoho vstupního parametruje mimo povolený rozsah");
        
    }
    
    public Vana(String nazevVany, double delka, double sirka, double vyska ) {
        if(nazevVany != null){
            this.nazevVany = nazevVany;
            rozmer = new Rozmer (delka, sirka, vyska);
        } else { throw new NullPointerException("hodnota jednoho vstupního parametruje mimo povolený rozsah");
        }
    }
   

    
}
