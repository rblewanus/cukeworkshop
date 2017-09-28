package cuke.common.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created on 19-12-2016.
 */
class WebElementLocator extends WebElementInteractie {

    WebElement vindKnop(String vindMethode, String vindMetWaarde) {
        if (vindMethode.equals("metTekst")) {
            boolean valueKnop = BrowserHelper.getWebDriver().findElements(By.xpath(String.format("//*[@value='%s']", vindMetWaarde))).size() == 1;
            boolean textKnop = BrowserHelper.getWebDriver().findElements(By.xpath(String.format("//*[text()='%s']", vindMetWaarde))).size() == 1;
            if (valueKnop) {
                return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[@value='%s']", vindMetWaarde))));
            } else if (textKnop) {
                return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[text()='%s']", vindMetWaarde))));
            } else {
                return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(), '" + vindMetWaarde + "')]/input[1]")));
            }
        } else if (vindMethode.equals("metId")) {
            return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(vindMetWaarde)));
        } else {
            return null;
        }
    }

    WebElement vindInputVeld(String vindMethode, String vindMetWaarde) {
        if (vindMethode.equals("metTekst")) {
            boolean tdVeld = BrowserHelper.getWebDriver().findElements(By.xpath(String.format("//label[text()= '%s']/parent::td/following-sibling::td/input[1]", vindMetWaarde))).size() == 1;
            boolean siblingVeld = BrowserHelper.getWebDriver().findElements(By.xpath(String.format("//label[contains(text(), '%s')]/following-sibling::input[1]", vindMetWaarde))).size() == 1;
            if (tdVeld) {
                return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//label[text()= '%s']/parent::td/following-sibling::td/input[1]", vindMetWaarde))));
            } else if (siblingVeld) {
                return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//label[contains(text(), '%s')]/following-sibling::input[1]", vindMetWaarde))));
            } else {
                return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(), '" + vindMetWaarde + "')]/input[1]")));
            }
        } else if (vindMethode.equals("metId")) {
            return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(vindMetWaarde)));
        } else {
            return null;
        }
    }

    WebElement vindTextAreaVeld(String vindMethode, String vindMetWaarde) {
        if (vindMethode.equals("metTekst")) {
            return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(), '" + vindMetWaarde + "')]/following-sibling::textarea[1]")));
        } else if (vindMethode.equals("metId")) {
            return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(vindMetWaarde)));
        } else {
            return null;
        }
    }

    WebElement vindCheckbox(String vindMethode, String vindMetWaarde) {
        if (vindMethode.equals("metTekst")) {
            BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(), '" + vindMetWaarde + "')]")));
            if (BrowserHelper.getWebDriver().findElements(By.xpath("//input[@type = 'checkbox']/following-sibling::label[contains(text(), '" + vindMetWaarde + "')]")).size()>0) { // input ervoor
                return BrowserHelper.getWebDriver().findElement(By.xpath("//input[@type = 'checkbox']/following-sibling::label[contains(text(), '" + vindMetWaarde + "')]"));
            } else { // input erachter
                return BrowserHelper.getWebDriver().findElement(By.xpath("//label[contains(text(), '" + vindMetWaarde + "')]/input[@type = 'checkbox']"));
            }
        } else if (vindMethode.equals("metId")) {
            return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(vindMetWaarde)));
        } else {
            return null;
        }
    }

    WebElement vindRadiobutton(String vindMethode, String vindMetWaarde) {
        if (vindMethode.equals("metTekst")) {
            BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(), '" + vindMetWaarde + "')]")));
            if (BrowserHelper.getWebDriver().findElements(By.xpath("//input[@type = 'radio']/following-sibling::label[contains(text(), '" + vindMetWaarde + "')]")).size()>0) { // input ervoor
                return BrowserHelper.getWebDriver().findElement(By.xpath("//input[@type = 'radio']/following-sibling::label[contains(text(), '" + vindMetWaarde + "')]"));
            } else { // input erachter
                return BrowserHelper.getWebDriver().findElement(By.xpath("//label[contains(text(), '" + vindMetWaarde + "')]/input[@type = 'radio']"));
            }
        } else if (vindMethode.equals("metId")) {
            return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(vindMetWaarde)));
        } else {
            return null;
        }
    }

    WebElement vindSelectieElement(String vindMethode, String vindMetWaarde) {
        if (vindMethode.equals("metTekst")) {
            return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(), '" + vindMetWaarde + "')]/select")));
        } else if (vindMethode.equals("metId")) {
            return BrowserHelper.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(vindMetWaarde)));
        } else {
            return null;
        }
    }
}
