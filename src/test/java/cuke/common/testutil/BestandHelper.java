package cuke.common.testutil;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static org.junit.Assert.fail;

/**
 * Created on 1/17/2017.
 */
public class BestandHelper {

    /**
     * Met deze methode wordt een bestand uit de testfiles folder (of subfolder) uitgelezen en in een string gezet.
     * @return scriptpath
     */
    public static String haalTestBestand(String filename) {
        String scriptPath = getScriptPath();
        String content;
        try {
            Scanner scanner = new Scanner(new File(scriptPath + filename), "UTF-8");
            if (scanner.hasNext()) {
                content = scanner.useDelimiter("\\A").next();
            } else {
                content = "";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not open " + scriptPath + filename, e);
        }
        return content;
    }

    /**
     * Onderstaande methode is voor het ophalen van het lokale pad t/m src/test/resources/. Werkt op unix en windows.
     * @return scriptpath De locatie van de "resources" folder.
     */
    private static String getScriptPath() {
        String currentPath = getRootPath();
        return currentPath + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    }

    /**
     * Deze methode geeft het pad van de hoofdmap van het project (dit maakt het omgeving onafhankelijk, maakt niet uit waar je het project neer zet.
     * @return de locatie van de hoofdmap van het project
     */
    public static String getRootPath() {
        String currentPath = null;
        try {
            currentPath = new File(".").getCanonicalPath();
        } catch (IOException e) {
            System.out.println("Could not open current path.");
        }
        return currentPath;
    }
}
