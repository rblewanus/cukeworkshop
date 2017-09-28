package cuke.common.browser;

import cuke.common.OmgevingConfig;
import cuke.common.testutil.BestandHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created on 28-2-2017.
 *
 * Op dit niveau wordt selenium webdriver gestart en wordt de basisinteractie met de browser geregeld.
 */
public class BrowserHelper {
    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    private static String browserType;

    static WebDriver getWebDriver() {
        if (webDriver == null) {
            startWebDriver();
        }
        return webDriver;
    }

    static WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            if (webDriver == null) {
                getWebDriver();
            }
            webDriverWait = new WebDriverWait(webDriver, 10);
        }
        return webDriverWait;
    }

    private static void startWebDriver() {
        String driversLocatie = BestandHelper.getRootPath() + File.separator + "drivers" + File.separator;
        if (browserType == null) {
            browserType = OmgevingConfig.getBrowser();
        }
        switch (browserType.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driversLocatie + "chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driversLocatie + "geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case "ie":
            case "internet explorer":
                System.setProperty("webdriver.ie.driver", driversLocatie + "IEDriverServer.exe");
                webDriver = new InternetExplorerDriver();
                break;
            case "htmlunit": // Headless browser
                webDriver = new HtmlUnitDriver();
                break;
            default:
                System.out.println("Geen browser opgegeven, Chrome wordt als standaard browser gestart.");
                System.setProperty("webdriver.chrome.driver", driversLocatie + "chromedriver.exe");
                webDriver = new ChromeDriver();
        }
        webDriver.manage().window().maximize();
    }

    public static void gaNaarUrl(String url) {
        getWebDriver().get(url);
    }

    public static void klikOpKnop(String knopId) {
        WebElementInteractie.klikElementMetId(knopId);
    }

    public static void selecteerCheckbox(String labelTekst) {
        WebElementInteractie.vinkCheckboxAanOfUit("metTekst", labelTekst, "aan");
    }

    public static void selecteerRadiobutton(String radioButtonTekst) {
        WebElementInteractie.selecteerRadiobutton("metTekst", radioButtonTekst);
    }

    public static void vulVeldMetTekst(String veldTekst, String waarde) {
        WebElementInteractie.vulInputVeldMetWaarde("metTekst", veldTekst, waarde);
    }

    public static void controleerAanwezigheidVanTekstMetXpath(String xpathString) {
        List<WebElement> tekstElementen = webDriver.findElements(By.xpath(xpathString));
        assertTrue("De verwachte tekst is niet gelijk aan de gevonden tekst", tekstElementen.size() > 0);
    }

    public static void controleerTekstVanOnderdeelMetId(String idVanOnderdeel, String verwachteTekst) {
        List<WebElement> tekstElementen = webDriver.findElements(By.id(idVanOnderdeel));
        if (tekstElementen.size() > 0) {
            WebElement tekstElement = webDriver.findElement(By.id(idVanOnderdeel));
            String gevondenTekst = tekstElement.getText();
            assertEquals(String.format("De verwachte tekst '%s' is niet gevonden, in plaats daarvan stond er '%s'.", verwachteTekst, gevondenTekst), verwachteTekst, gevondenTekst);
        } else {
            fail("Het onderdeel waarvan de tekst gecontroleerd moest worden is niet gevonden.");
        }
    }

    public static void controleerZichtbaarheidElementMetId(boolean zichtbaar, String elementId) {
        if (zichtbaar) {
            WebElement element = webDriver.findElement(By.id(elementId));
            assertTrue("Het element is niet zichtbaar.", element.isDisplayed());
        } else {
            WebElement element = webDriver.findElement(By.id(elementId));
            assertFalse("Het element is toch zichtbaar.", element.isDisplayed());
        }
    }

    public static void knopIsBeschikbaar(String knopId) {
        WebElementInteractie.controleerKnopBeschikbaarheid("metId", knopId, true);
    }
}
