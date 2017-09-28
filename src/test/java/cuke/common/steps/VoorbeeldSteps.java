package cuke.common.steps;

import cucumber.api.DataTable;
import cucumber.api.java.nl.*;
import cuke.common.implementation.VoorbeeldImpl;
import cuke.common.model.Lening;
import cuke.common.testutil.BestandHelper;
import cuke.common.testutil.Wacht;

import java.io.File;
import java.util.List;

/**
 * Created on 1-3-2017.
 */
public class VoorbeeldSteps {

    @Als("^iets met (wel|niet) lenen$")
    public void ietsMetWelNietLenen(String welniet) {
        if (welniet.equals("wel")) {
            VoorbeeldImpl.printString("Wel is " + welniet + " gekozen.");
        } else {
            VoorbeeldImpl.printString("En nu is er " + welniet + " gekozen.");
        }
    }

    @Gegeven("^een (.*) variabele$")
    public void eenVrijeVariabele(String var) {
        VoorbeeldImpl.printString(var);
    }

    @Gegeven("^datatable met lening naar een list omzetten$")
    public void datatableMetLeningNaarEenListOmzetten(DataTable dataTable) {
        List<Lening> leningen = dataTable.asList(Lening.class);
        VoorbeeldImpl.printEenGegevensVanEenLeningLijst(leningen);
    }

    @Gegeven("^datatable met lening direct in een leninglijst$")
    public void datatableMetLeningDirectInEenLeninglijst(List<Lening> leningen) {
        VoorbeeldImpl.printEenGegevensVanEenLeningLijst(leningen);
    }

    @Gegeven("^er wordt een browser geopend met een oefenwebsite$")
    public void erWordtEenBrowserGeopendMetEenOefenwebsite() {
        VoorbeeldImpl.startBrowserMetUrl("file://"+ BestandHelper.getRootPath() + File.separator + "src/main/cuke_workshop/voorbeeld.html");
    }

    @Als("^er geklikt wordt op de knop met id (.*)$")
    public void erGekliktWordtOpDeKnop(String knopId) {
        Wacht.seconden(1); // Iets langzamer, omdat het dan beter met het ook te volgen is
        VoorbeeldImpl.klikOpKnopMetId(knopId);
    }

    @Dan("^is de tekst (.*) zichtbaar$")
    public void isDeTekstTekstZichtbaar(String tekst) {
        Wacht.seconden(1); // Iets langzamer, omdat het dan beter met het ook te volgen is
        VoorbeeldImpl.tekstIsZichtbaar(tekst);
    }
}
