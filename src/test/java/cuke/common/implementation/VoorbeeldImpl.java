package cuke.common.implementation;

import cuke.common.browser.BrowserHelper;
import cuke.common.model.Lening;

import java.util.List;

/**
 * Created on 1-3-2017.
 */
public class VoorbeeldImpl {

    public static void printEenGegevensVanEenLeningLijst(List<Lening> leningen) {
        for (Lening lening : leningen) {
            System.out.println("Leningtype: " + lening.getLeningtype());
            System.out.println("Leenbedrag: " + lening.getBedrag());
        }
    }

    public static void printString(String var) {
        System.out.println("De variabele wordt nu geprint:\n");
        System.out.println(var);
    }

    public static void startBrowserMetUrl(String url) {
        BrowserHelper.gaNaarUrl(url);
    }

    public static void klikOpKnopMetId(String knopId) {
        BrowserHelper.klikOpKnop(knopId);
    }

    public static void tekstIsZichtbaar(String tekst) {
        BrowserHelper.controleerTekstVanOnderdeelMetId("tekstScherm2", tekst);
    }
}
