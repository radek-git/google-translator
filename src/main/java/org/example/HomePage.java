package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public LanguagesPopup clickOnMoreLanguagesButton() {
        WebElement button = getDriver().findElement(By.xpath("//div[contains(@class, 'tlid-open-source-language-list')]"));
        button.click();

        return new LanguagesPopup(getDriver(), getWait());
    }

    public String languageFrom(String filename) {
        String input = FileManager.read(filename);
        String languageFrom = input.substring(0, input.indexOf("\n"));
        return languageFrom;
    }

    public String languageTo(String filename) {
        String input = FileManager.read(filename);
        String languageFrom = input.substring(0, input.indexOf("\n"));
        input = input.replace(languageFrom + "\n", "");
        String languageTo = input.substring(0, input.indexOf("\n"));

        return languageTo;
    }

    public String textToTranslate(String filename) {
        String input = FileManager.read(filename);
        String languageFrom = input.substring(0, input.indexOf("\n"));
        input = input.replace(languageFrom + "\n", "");
        String languageTo = input.substring(0, input.indexOf("\n"));
        input = input.replace(languageTo + "\n", "");
        return input;
    }


    public LanguagesPopup clickOnMoreLanguagesButtonRight() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'tlid-open-target-language-list')]")));
        WebElement button = getDriver().findElement(By.xpath("//div[contains(@class, 'tlid-open-target-language-list')]"));
        button.click();
        return new LanguagesPopup(getDriver(), getWait());
    }

    public void inputTextToTranslateInSourceField(String text) {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='source']")));
        WebElement source = getDriver().findElement(By.xpath("//textarea[@id='source']"));
        source.sendKeys(text);

        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();
    }

    public String getTranslatedText() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'tlid-copy-target')]/span/span")));
        WebElement text = getDriver().findElement(By.xpath("//div[contains(@class, 'tlid-copy-target')]/span/span"));
        String translatedText = text.getText();
        return translatedText;
    }

    public void saveTextToFile(String filename, String text) {
        FileManager.write(filename, text);
    }
}
