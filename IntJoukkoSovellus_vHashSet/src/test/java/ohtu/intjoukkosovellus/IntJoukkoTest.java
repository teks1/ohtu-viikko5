package ohtu.intjoukkosovellus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko intJoukko;

    @Before
    public void setUp() {
        intJoukko = new IntJoukko();
    }

    @Test
    public void konstruktoriLuoTyhjanSetin() {
        assertEquals("{}", intJoukko.toString());
    }
}
