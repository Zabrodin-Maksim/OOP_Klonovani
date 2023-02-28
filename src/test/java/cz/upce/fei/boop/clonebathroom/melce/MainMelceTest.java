
package cz.upce.fei.boop.clonebathroom.melce;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kasi0004
 */
public class MainMelceTest {
    
    public MainMelceTest() {
    }

     @Test
    public void testMain() throws Exception {
        MainMelce.main(null);
    }
    
     @Test
    public void testMain2() throws Exception {
       new MainMelce();
    }
    
}
