package ohtu.intjoukkosovellus;

import java.util.HashSet;

public class IntJoukko {

    private HashSet<Integer> intJoukko;

    public IntJoukko() {
        intJoukko = new HashSet<>();
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        intJoukko.add(luku);
        return true;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) {
            return false;
        }
        intJoukko.remove(luku);
        return true;
    }

    public boolean kuuluu(int luku) {
        if (intJoukko.contains(luku)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return intJoukko.toString();
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhd = new IntJoukko();
        yhd.intJoukko.addAll(a.intJoukko);
        yhd.intJoukko.addAll(b.intJoukko);
        return yhd;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (Integer i : a.intJoukko) {
            if (b.intJoukko.contains(i)) {
                y.lisaa(i);
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (Integer i : a.intJoukko) {
            if (!b.intJoukko.contains(i)) {
                z.lisaa(i);
            }
        }

        return z;
    }

}
