package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LanguagesPopup extends BasePage {


    public LanguagesPopup(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomePage inputLanguageFromFile(String langName) {
        WebElement input = getDriver().findElement(By.xpath("//input[@id='sl_list-search-box']"));
        input.sendKeys(langName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();

        return new HomePage(getDriver(), getWait());
    }

    public HomePage inputLanguageToFromFile(String langName) {
        WebElement input = getDriver().findElement(By.xpath("//input[@id='tl_list-search-box']"));
        input.sendKeys(langName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();

        return new HomePage(getDriver(), getWait());
    }

}
