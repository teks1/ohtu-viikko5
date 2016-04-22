package ohtu.intjoukkosovellus;

public class IntJoukko {

    private final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 2;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            kapasiteetti = KAPASITEETTI;
        }
        if (kasvatuskoko < 0) {
            kasvatuskoko = OLETUSKASVATUS;
        }
        asetaArvot(kapasiteetti, kasvatuskoko);
    }

    private void asetaArvot(int kapasiteetti, int kasvatuskoko) {
        luvut = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        lisaaLuku(luku);
        return true;
    }

    private void lisaaLuku(int luku) {
        luvut[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % luvut.length == 0) {
            kasvataTaulukkoa();
        }
    }

    private void kasvataTaulukkoa() {
        int[] kopio = new int[luvut.length];
        kopioiTaulukko(luvut, kopio);
        luvut = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(kopio, luvut);
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        if (!kuuluu(luku)) {
            return false;
        }
        if (alkioidenLkm == 1) {
            luvut[0] = 0;
        } else {
            poistaLuku(luku);
        }
        alkioidenLkm--;
        return true;
    }

    private void poistaLuku(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                luvut[i] = luvut[alkioidenLkm - 1];
                luvut[alkioidenLkm - 1] = 0;
                break;
            }
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int alkioidenMaara() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        }
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += luvut[i] + ", ";
        }
        tuotos += luvut[alkioidenLkm - 1] + "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.alkioidenMaara(); i++) {
            x.lisaa(a.luvut[i]);
        }
        for (int i = 0; i < b.alkioidenMaara(); i++) {
            x.lisaa(b.luvut[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.alkioidenMaara(); i++) {
            for (int j = 0; j < b.alkioidenMaara(); j++) {
                if (a.luvut[i] == b.luvut[j]) {
                    y.lisaa(b.luvut[j]);
                }
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.alkioidenMaara(); i++) {
            z.lisaa(a.luvut[i]);
        }
        for (int i = 0; i < b.alkioidenMaara(); i++) {
            z.poista(b.luvut[i]);
        }
        return z;
    }

}
