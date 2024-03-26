package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    //    Кнопка "Заказать" в хэдере
    private final By smallOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[1]");
    //    Кнопка "Заказать" внизу страницы
    private final By bigOrderButton = By.xpath(".//div[5]/button");
    private final By acceptCookie = By.id("rcc-confirm-button");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }
    public FormPage clickHeaderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(smallOrderButton));
        driver.findElement(smallOrderButton).click();
        return new FormPage(driver);

    }
        public FormPage clickFooterButton(){
        driver.findElement(acceptCookie).click();
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(bigOrderButton));

        driver.findElement(bigOrderButton).click();
        return new FormPage(driver);

    }

}