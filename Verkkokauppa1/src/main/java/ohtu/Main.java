package ohtu;

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");

        Kirjanpito kirjanpito = (Kirjanpito) ctx.getBean("kirjanpito");
        Kauppa kauppa = (Kauppa) ctx.getBean("kauppa");

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        hoidaAsiakas(kauppa);

        // seuraava asiakas
        seuraavaAsiakas(kauppa);
        // kirjanpito
        tulostaKirjanpito(kirjanpito);
    }

    public static void hoidaAsiakas(Kauppa kauppa) {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");
    }

    public static void tulostaKirjanpito(Kirjanpito kirjanpito) {
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }

    public static void seuraavaAsiakas(Kauppa kauppa) {
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");
    }
}
