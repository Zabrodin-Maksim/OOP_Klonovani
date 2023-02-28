package cz.upce.fei.boop.clonebathroom.melce;

import cz.upce.fei.boop.clonebathroom.Rozmer;
import cz.upce.fei.boop.clonebathroom.Vana;




public class MainMelce {

    public static void main(String[] args) throws CloneNotSupportedException {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaMelce koupelna1 = new KoupelnaMelce("K1", 10, 11, 12, vana);
        KoupelnaMelce koupelna2 = koupelna1.clone();
        koupelna2.setNazev("K2");
        System.out.println("" + koupelna1);
        System.out.println("" + koupelna2);
    }
}
