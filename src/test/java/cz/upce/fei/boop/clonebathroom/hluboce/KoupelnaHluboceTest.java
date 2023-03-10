package cz.upce.fei.boop.clonebathroom.hluboce;



import cz.upce.fei.boop.clonebathroom.Rozmer;
import cz.upce.fei.boop.clonebathroom.Vana;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Testy instancí trídy KoupelnaMelce kontrolují, zda třída má požadované
 * vlastnosti. Tou hlavní kontrolou je, zda dochazí pouze k mělkému klonování.
 *
 * Dále se testy využívají k procvičování přetěžování konstruktorů.
 *
 * Na příkladu koupelny z vanou je na první pohled jasné, že mělké klonování
 * neodpovídá realitě, protože vanu nelze sdílet mezi dvěmi koupelnami. Jedině
 * že by byla přenosná, potom by to šlo, ale potom by se nemohla jedna vana ve
 * stejném čase vyskytovat na dvou místech současně.
 *
 *
 * @author karel@simerda.cz
 */
public class KoupelnaHluboceTest {

    /**
     * Tento test ve volání konstruktoru určuje jaké je pořadí parametrů a jaké
     * jsou jejich typy. Dále testuje, zda koupelna byla vytvořena hluboce.
     *
     * První parametr konstruktoru je název koupelny, druhý je odkaz na její
     * rozměr a třetí je odkaz na vanu.
     *
     * Kontrolou se provnají dvě hodnoty reference na instanci vany a protože se
     * jedná o hluboké klonování, tak tyto hodnoty nesmí být stejné.
     *
     * @throws java.lang.CloneNotSupportedException Tato výjimka se vystaví,
     * když třída nepovoluje klonování
     */
    @Test
    public void test01Constructor() throws CloneNotSupportedException {
        Vana vana = new Vana("Ravak", new Rozmer(2.0, 1.2, 0.5));
        Rozmer rozmerKoupelny = new Rozmer(4, 5, 3);
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", rozmerKoupelny, vana);
        KoupelnaHluboce klonKoupelny = koupelna.clone();
        Vana result = klonKoupelny.getVana();
        assertFalse(vana == result);
    }

    /**
     * Tento test, že dvě instance vany mají stejnou hodnotu. Předchozí test
     * prokazuje, že po klonování vnikla druhá instanc evany a tento zase
     * prokazuje, že došlo ke zkopírovnání stavu.
     *
     * Tento test ovšem projde jen za určitého chování instancí třídy Vana.
     * Jakého? Třídu Vana je nutné doplnit o ... ?
     *
     * @throws CloneNotSupportedException
     */
    @Test
    public void test02Constructor() throws CloneNotSupportedException {
        Vana vana = new Vana("Ravak", new Rozmer(2.0, 1.2, 0.5));
        Rozmer rozmerKoupelny = new Rozmer(4, 5, 3);
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", rozmerKoupelny, vana);
        KoupelnaHluboce klonKoupelny = koupelna.clone();
        Vana result = klonKoupelny.getVana();
        assertEquals(vana, result);
    }

    /**
     * Tento test má o proti předchozímu testu jinou signaturu konstruktoru,
     * tzn. že třída KoupelnaMelce bude mít přetížené konstruktory.
     *
     * Podle kontroly očekávaného rozměru a rozměru z instnace koupelny lze
     * odvodit, co který parametr konstruktoru znamená.
     */
    @Test
    public void testConstructor00b() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", 3, 2, 3, vana);
        Rozmer expResult = new Rozmer(3, 2, 3);
        Rozmer result = koupelna.getRozmer();
        assertEquals(expResult, result);
    }

    /**
     * Tento test ověří, zda není ve volání konstruktoru použita hodnota null
     * místo odkazu na instanci vany.
     *
     * Testo obsahuje kontrolu, zda jsem nezapoměli vystavit výjimku. Když se
     * výjimka vystaví, tak se to ošetří parametrem excepted se jmenem očekávané
     * výjimky a test může pobíhat dál. Jestliže však výjimku nevystavíme,
     * konstruktor normálně proběhne a hlášení chyby by nenastalo. Hlášení chyby
     * způsobí až metoda fail().
     *
     */
    @Test(expected = NullPointerException.class)
    public void testConstructor01b() {
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", 3, 2, 3, null);
        fail("Nevystavila se výjimka NullPointerException z důvodu null ve parametru na vanu koupelny");

    }

    /**
     * Tento test ověří, zda není ve volání konstrultoru použita hodnota null
     * místo odkazu na instanci rozmeru koupelny.
     *
     * Kontrola nevystavení výjimky proběhne stejně jako v předchozím případu.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructor02() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", null, vana);
        fail("Nevystavila se výjimka NullPointerException z důvodu null v rozměru koupelny");
    }

    /**
     * Tento test prověří, zda není ve volání konstruktoru použita hodnota null
     * místo odkazu na jméno koupelny.
     *
     * Kontrola nevystavení výjimky proběhne stejně jako v předchozích
     * případech.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructor04() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce(null, new Rozmer(1, 1, 1), vana);
        fail("Nevystavila se výjimka NullPointerException z důvodu null ve jménu koupelny");
    }

    /**
     * Tento test prověří, zda není ve volání konstruktoru není použit prázdný
     * řetězec jako jméno koupelny.
     *
     * Kontrola nevystavení výjimky proběhne stejně jako v předchozích
     * případech.
     */
//    @Test(expected = MojeException.class)
    public void testConstructor05() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce("", new Rozmer(3, 4, 3), vana);
        fail("Nevystavila se výjimka MojeException");
    }

    @Test
    public void test07GetNazev() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce("Koupelna", new Rozmer(3, 4, 3), vana);
        assertEquals("Koupelna", koupelna.getNazev());
    }

}
