package cuke.common.steps;

import cucumber.api.java.nl.*;
import cuke.common.implementation.LeningImpl;

/**
 * Created on 28-2-2017.
 */
public class LeningSteps {

    @Gegeven("^de klant wil informatie over een lening$")
    public void deKlantWilInformatieOverEenLening() {
        LeningImpl.gaNaarCukeWorkshopPagina();
    }

    @Als("^de klant een lening wil voor \"([^\"]*)\"$")
    public void deKlantEenLeningWilVoor(String leningsoort) {
        LeningImpl.klikOpKnopInLeningAanvragen(leningsoort);
    }

    @Dan("^krijgt de klant de informatie tekst \"([^\"]*)\"$")
    public void krijgtDeKlantDeInformatieTekst(String leningtekst) {
        LeningImpl.controleerLeningInformatieTekst(leningtekst);
    }

    @Dan("^kan de klant zijn keuze bevestigen$")
    public void kanDeKlantZijnKeuzeBevestigen() {
        LeningImpl.controleerBeschikbaarheidKnopInLeningAanvragen("Ga verder naar toelichting");
    }

    @Als("^de klant zijn keuze bevestigd$")
    public void deKlantZijnKeuzeBevestigd() {
        LeningImpl.klikOpKnopInLeningAanvragen("Ga verder naar toelichting");
    }

    @Dan("^kan de klant de informatie over de lening verifieren$")
    public void kanDeKlantDeInformatieOverDeLeningVerifieren() {
        LeningImpl.controleerLeningtypeEnBedrag();
    }

    @Gegeven("^de klant heeft gekozen voor een lening$")
    public void deKlantHeeftGekozenVoorEenLening() {
        LeningImpl.gaNaarCukeWorkshopPagina();
        LeningImpl.vulLeningtypeEnBedragIn("Flitskrediet", "300");
        LeningImpl.klikOpKnopInLeningAanvragen("Ga verder naar toelichting");
    }

    @Als("^de klant aangeeft (wel|geen) ervaring te hebben met lenen$")
    public void deKlantAangeeftGeenErvaringTeHebbenMetLenen(String welgeen) {
        if (welgeen.equals("geen")) {
            LeningImpl.selecteerOptie("Ik heb geen kennis of ervaring met lenen.");
        } else {
            LeningImpl.selecteerOptie("Ik heb kennis en ervaring met lenen.");
        }
    }

    @Dan("^wordt de wettelijke informatie over lenen (wel|niet) getoond$")
    public void wordtDeWettelijkeInformatieOverLenenGetoond(String welniet) {
        LeningImpl.controleerZichtbaarheidWettelijkeInformatie(welniet);
    }

    @Gegeven("^de klant heeft een leningkeuze gemaakt$")
    public void deKlantHeeftEenLeningkeuzeGemaakt() throws Throwable {
        LeningImpl.gaNaarCukeWorkshopPagina();
    }

    @Als("^de klant kiest voor een \"([^\"]*)\" van \"([^\"]*)\" euro$")
    public void deKlantKiestVoorEenVanEuro(String leningtype, String bedrag) {
        LeningImpl.gaNaarCukeWorkshopPagina();
        LeningImpl.vulLeningtypeEnBedragIn(leningtype, bedrag);
    }
}
