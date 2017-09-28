package cuke.common.implementation;

import cuke.common.testutil.BestandHelper;
import cuke.common.browser.BrowserHelper;
import cuke.common.testutil.PropertiesHelper;

import java.io.File;
import java.util.Properties;

/**
 * Created on 28-2-2017.
 * <p>
 * Op dit niveau wordt stappen verder uitgeprogrammeerd.
 * Bijvoorbeeld het aanroepen van de BrowserHelper om een browser te starten of tegen de browserhelper te zeggen welke interactie gedaan moet worden.
 * <p>
 * De daadwerkelijke interactie met de browser gebeurd een laag dieper.
 */
public class LeningImpl {

    /**
     * Met private static String's hieronder, zijn onderdelen die in een test onthouden moeten blijven. Deze vul je bijvoorbeeld bij de "Gegeven" of "Als" in en wordt daarna weer gebruikt bij de controle in de "Dan".
     */
    private static String gekozenLening;
    private static String gekozenBedrag;

    public static void gaNaarBddWorkshopPagina() {
        String bddapplicatie = "file://"+ BestandHelper.getRootPath() + File.separator + "src/main/cuke_workshop/leningaanvraag.html";
        BrowserHelper.gaNaarUrl(bddapplicatie);
    }

    public static void klikOpKnopInLeningAanvragen(String knopnaam) {
        String knopId = haalKnopIdVoorKnopnaam(knopnaam);
        BrowserHelper.klikOpKnop(knopId);
    }

    public static void vulLeningtypeEnBedragIn(String leningtype, String bedrag) {
        // Vul hier de variabelen die in deze class bij een latere controle stap gebruikt wordt (informatie over lening verifieren)
        gekozenBedrag = bedrag;
        gekozenLening = leningtype;
        // Selecteer de lening met (een deel van) de tekst van het label
        BrowserHelper.selecteerRadiobutton(leningtype);
        BrowserHelper.vulVeldMetTekst("Te lenen bedrag", bedrag);
    }

    public static void vulVeldMetWaarde(String veld, String waarde) {
        BrowserHelper.vulVeldMetTekst(veld, waarde);
    }

    public static void selecteerOptie(String tekstVanOptie) {
        BrowserHelper.selecteerRadiobutton(tekstVanOptie);
    }

    public static void controleerBeschikbaarheidKnopInLeningAanvragen(String knopnaam) {
        String knopId = haalKnopIdVoorKnopnaam(knopnaam);
        BrowserHelper.knopIsBeschikbaar(knopId);
    }

    public static void controleerZichtbaarheidWettelijkeInformatie(String welniet) {
        if (welniet.equals("wel")) {
            BrowserHelper.controleerZichtbaarheidElementMetId(true, "leningtoelichting");
        } else {
            BrowserHelper.controleerZichtbaarheidElementMetId(false, "leningtoelichting");
        }
    }

    public static void controleerLeningtypeEnBedrag() {
        BrowserHelper.controleerTekstVanOnderdeelMetId("gekozen_typelening", gekozenLening);
        BrowserHelper.controleerTekstVanOnderdeelMetId("gekozen_amount", gekozenBedrag);
    }

    public static void controleerLeningInformatieTekst(String leningtekst) {
        String xpathString = String.format("//p[text()='%s']", leningtekst);
        BrowserHelper.controleerAanwezigheidVanTekstMetXpath(xpathString);
    }

    private static String haalKnopIdVoorKnopnaam(String knopnaam) {
        Properties knopIds = PropertiesHelper.loadProperties("knopnamenNaarId");
        String knopnaamMetUnderscores = knopnaam.replace(" ", "_");
        if (!knopIds.containsKey(knopnaamMetUnderscores)) {
            throw new RuntimeException(String.format("De knopnaam %s komt niet voor in het properties bestand knopnamenNaarId.properties", knopnaamMetUnderscores));
        }
        return knopIds.getProperty(knopnaamMetUnderscores);
    }
}
