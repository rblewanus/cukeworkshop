package cuke.common.testutil;

import cucumber.api.DataTable;

import java.util.List;

/**
 * Created on 09-01-2017.
 */
public class StringHelper {

    /**
     * Met deze method wordt een lijst van bijv. 8100, 8110, 8120 en 8130 (met komma's en " en ") omgezet in een Stringlist (String[])
     *
     * Dergelijke methodes zijn er om mooiere stapdefinities te maken.
     *
     * @param opsomming Een lijst van onderdelen met ", " en " en " ertussen.
     * @return een String[] lijst waar doorheen geloopt kan worden.
     */
    public static String[] maakLijstVanOpsommingMetTrim(String opsomming) {
        opsomming = opsomming.replace(" en ", ",");
        opsomming = opsomming.replace(" ", ""); // Alle spaties weghalen, voor betere afhandeling van lijsten met spaties in de onderdelen, gebruik zonder .trim().
        return opsomming.split(",");
    }

    /**
     * Met deze method wordt een lijst van bijv. item een, item twee en item drie (met komma's en " en ") omgezet in een Stringlist (String[])
     * @param opsomming Een lijst van onderdelen met ", " en " en " ertussen.
     * @return een String[] lijst waar doorheen geloopt kan worden.
     */
    public static String[] maakLijstVanOpsomming(String opsomming) {
        opsomming = opsomming.replace(" en ", ",");
        return opsomming.split(",");
    }

    /**
     * Met deze method wordt gekeken of een string alleen cijfers bevat
     * @param str de te controleren string
     * @return true als de string geheel numeriek is, false wanneer dat niet zo is.
     */
    public static boolean stringIsCompleetNumeriek (String str) {
        String strZonderTekst = str.replaceAll("\\D+","");
        return str.equals(strZonderTekst);
    }

    /**
     * Met deze method wordt gekeken of een string alleen tekst bevat
     * @param str de te controleren string
     * @return true als de string geheel numeriek is, false wanneer dat niet zo is.
     */
    public static boolean stringIsCompleetAlphabetisch (String str) {
        String strZonderTekst = str.replaceAll("\\D+","");
        return !str.equals(strZonderTekst);
    }

    /**
     * Deze methode maakt een string compleet numeriek door het weghalen van alle letters.
     * @param str een string met eventueel letters
     * @return een string zonder letters
     */
    public static String maakStringNumeriekDoorVerwijderenLetters (String str) {
        return str.replaceAll("\\D+","");
    }

    /**
     * Een methode om te controleren of er cijfers in een string staan. Door te kijken naar de lengte van de string nadat alle letters zijn verwijderd.
     *
     * Dit is handig wanneer je niet zeker weet wat je terugkrijgt uit een database of van een scherm. Soms moet je dan wat anders doen als het cijfers bevat ten opzicht van wanneer het geen cijfers bevat.
     *
     * @param str een string
     * @return true wanneer er cijfers in de string zitten, false wanneer dat niet zo is.
     */
    public static boolean stringBevatCijfers (String str) {
        String strZonderTekst = str.replaceAll("\\D+","");
        return strZonderTekst.length()>0;
    }
}
