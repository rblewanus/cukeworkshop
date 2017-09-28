package cuke.common.browser;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created on 19-12-2016.
 */
class WebElementInteractie {

    private static WebElementLocator webElementLocator = new WebElementLocator();

    static void klikElementMetId(String id) {
        WebElement knop = webElementLocator.vindKnop("metId", id);
        BrowserHelper.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(knop)).click();
    }

    static void klikElementMetTekst(String tekst) {
        WebElement knop = webElementLocator.vindKnop("metTekst", tekst);
        BrowserHelper.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(knop)).click();
    }

    static void controleerKnopBeschikbaarheid(String vindMethode, String vindMetWaarde, boolean verwachtBeschikbaar) {
        WebElement element = webElementLocator.vindKnop(vindMethode, vindMetWaarde);
        boolean gevondenBeschikbaar = BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOf(element)).isEnabled();
        assertEquals(String.format("Verwacht werd dat de knop %s '%s' beschikbaarheid '%s' is, maar is dat niet.",
                vindMethode, vindMetWaarde, verwachtBeschikbaar), verwachtBeschikbaar, gevondenBeschikbaar);
        assertTrue("De knop is niet beschikbaar.", element.isEnabled());
    }

    static void vulInputVeldMetWaarde(String vindMethode, String vindMetWaarde, String waarde) {
        WebElement veld = webElementLocator.vindInputVeld(vindMethode, vindMetWaarde);
        vulWebElementVeldMetWaarde(veld, waarde);
    }

    static void controleerInputVeldVoorWaarde(String vindMethode, String vindMetWaarde, String verwachteWaarde) {
        WebElement veld = webElementLocator.vindInputVeld(vindMethode, vindMetWaarde);
        String gevondenWaarde = veld.getAttribute("value");
        assertEquals(String.format("De verwachte waarde '%s' en gevonden waarde '%s' in veld %s '%s' zijn niet gelijk.",
                verwachteWaarde, gevondenWaarde, vindMethode, vindMetWaarde), verwachteWaarde, gevondenWaarde);
    }

    static void vulTextAreaVeldMetWaarde(String vindMethode, String vindMetWaarde, String waarde) {
        WebElement veld = webElementLocator.vindTextAreaVeld(vindMethode, vindMetWaarde);
        vulWebElementVeldMetWaarde(veld, waarde);
    }

    static void vulWebElementVeldMetWaarde(WebElement veld, String waarde) {
        int aantalKeerProberen = 1;
        while (!veld.getAttribute("value").equals(waarde) || aantalKeerProberen > 0) {
            veld.clear();
            veld.sendKeys(waarde);
            aantalKeerProberen--;
        }
        assertEquals(String.format("Probeerde veld te vullen met waarde '%s', maar dit is niet gelukt.", waarde),
                waarde, veld.getAttribute("value"));
    }

    static void controleerTextAreaVoorWaarde(String vindMethode, String vindMetWaarde, String verwachteWaarde) {
        WebElement veld = webElementLocator.vindTextAreaVeld(vindMethode, vindMetWaarde);
        String gevondenWaarde = veld.getAttribute("value");
        assertEquals(String.format("De verwachte waarde '%s' en gevonden waarde '%s' in veld %s '%s' zijn niet gelijk.",
                verwachteWaarde, gevondenWaarde, vindMethode, vindMetWaarde), verwachteWaarde, gevondenWaarde);
    }

    static void vinkCheckboxAanOfUit(String vindMethode, String vindMetWaarde, String aanOfUit) {
        WebElement checkbox = webElementLocator.vindCheckbox(vindMethode, vindMetWaarde);
        boolean isGeselecteerd = BrowserHelper.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(checkbox)).isSelected();
        if (aanOfUit.toLowerCase().equals("aan") && !isGeselecteerd) {
            checkbox.click();
            BrowserHelper.getWebDriverWait().until(ExpectedConditions.elementToBeSelected(checkbox));
        } else if (aanOfUit.toLowerCase().equals("uit") && isGeselecteerd) {
            checkbox.click();
            BrowserHelper.getWebDriverWait().until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(checkbox)));
        }
    }

    static void controleerCheckboxStatus(String vindMethode, String vindMetWaarde, boolean verwachtGeselecteerd) {
        WebElement checkbox = webElementLocator.vindCheckbox(vindMethode, vindMetWaarde);
        boolean gevondenGeselecteerd = BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOf(checkbox)).isSelected();
        assertEquals(String.format("Verwacht werd dat de checkbox %s '%s' %s geselecteerd is, maar is dat niet.",
                vindMethode, vindMetWaarde, verwachtGeselecteerd), verwachtGeselecteerd, gevondenGeselecteerd);
    }

    static void selecteerRadiobutton(String vindMethode, String vindMetWaarde) {
        WebElement radiobutton = webElementLocator.vindRadiobutton(vindMethode, vindMetWaarde);
        radiobutton.click();
    }

    static void controleerRadiobuttonStatus(String vindMethode, String vindMetWaarde, boolean verwachtGeselecteerd) {
        WebElement radiobutton = webElementLocator.vindRadiobutton(vindMethode, vindMetWaarde);
        boolean gevondenGeselecteerd = BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOf(radiobutton)).isSelected();
        assertEquals(String.format("Verwacht werd dat de radiobutton %s '%s' %s geselecteerd is, maar is dat niet.",
                vindMethode, vindMetWaarde, verwachtGeselecteerd), verwachtGeselecteerd, gevondenGeselecteerd);
    }

    static void selecteerInSelectieElement(String vindMethode, String vindMetWaarde, String teSelecterenTekst) {
        Select selectieElement = new Select(webElementLocator.vindSelectieElement(vindMethode, vindMetWaarde));
        selectieElement.selectByVisibleText(teSelecterenTekst);
    }

    static void controleerGeselecteerdItemInSelectieElement(String vindMethode, String vindMetWaarde, String verwachtGeselecteerd) {
        Select selectieElement = new Select(webElementLocator.vindSelectieElement(vindMethode, vindMetWaarde));
        String gevondenGeselecteerd = selectieElement.getFirstSelectedOption().getText().trim();
        assertEquals(String.format("De verwachte geselecteerd waarde '%s' en gevonden geselecteerde waarde '%s' in selectie element %s '%s' zijn niet gelijk.",
                verwachtGeselecteerd, gevondenGeselecteerd, vindMethode, vindMetWaarde), verwachtGeselecteerd, gevondenGeselecteerd);
    }
}
