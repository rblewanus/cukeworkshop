package cuke.common;

import cuke.common.testutil.Environment;
import cuke.common.testutil.PropertiesHelper;

import java.util.Properties;

/**
 * Created on 09-01-2017.
 */
public abstract class OmgevingConfig {

    private static String omgeving;
    private static String browser;

    public static String getOmgeving() {
        if (omgeving==null) { bepaalOmgeving(); }
        return omgeving;
    }

    public static String getBrowser() {
        if (browser==null) { bepaalBrowser(); }
        return browser;
    }

    /**
     * Met deze methode wordt de omgeving bepaald.
     */
    private static void bepaalOmgeving() {
        String computernaam = Environment.getComputerName();
        omgeving = computernaam;
        // Nu is de omgeving nog altijd de computernaam.
        // Deze kan anders geprogrammeerd worden, door bijv. in een properties bestand een computernaam een omgeving te geven.
        // Gebruik hiervoor PropertiesHelper.loadPropertiesNoEnv in testutil
        System.out.println("Computernaam is: " + Environment.getComputerName() + ", dan is de omgeving: " + omgeving);
    }

    private static void bepaalBrowser() {
        Properties browserProp = PropertiesHelper.loadProperties("browser");
        browser = browserProp.getProperty("browser");
    }
}
