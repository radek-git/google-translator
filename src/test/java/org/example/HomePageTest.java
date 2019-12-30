package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    String filename = "input.txt";
    String filenameOutput = "output.txt";


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);

        driver.get("https://translate.google.pl/?hl=pl&tab=rT1");
        driver.manage().window().maximize();

        homePage = new HomePage(driver, wait);
    }


    @Test
    public void clickOnMoreLanguagesButton() {
        LanguagesPopup languagesPopup = homePage.clickOnMoreLanguagesButton();
        homePage = languagesPopup.inputLanguageFromFile(homePage.languageFrom(filename));
        languagesPopup = homePage.clickOnMoreLanguagesButtonRight();
        homePage = languagesPopup.inputLanguageToFromFile(homePage.languageTo(filename));
        homePage.inputTextToTranslateInSourceField(homePage.textToTranslate(filename));
        homePage.getTranslatedText();
        homePage.saveTextToFile(filenameOutput, homePage.getTranslatedText());

    }
}
