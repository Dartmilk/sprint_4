package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ForRentPage {
    private final WebDriver driver;
    //    Поле "Когда привезти самокат"
    private final By fieldDateDelivery = By.xpath(".//div[1]/div/input");
    //    Поле "Срок аренды"
    private final By fieldRentalPeriod = By.className("Dropdown-placeholder");
    //    Чекбокс "Черный жемчуг"
    private final By blackCheckbox = By.id("black");
    //    Чекбокс "Черный жемчуг"
    private final By greyCheckbox = By.id("grey");
    //Поле "Комментарий"
    private final By fieldForComment = By.xpath(".//div[4]/input");
    //    Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[3]/button[2]");
    // Кнопка "Да"
    private final By buttonYes = By.xpath(".//button[text()='Да']");
    //Плашка с сообщением "Заказ оформлен"
    private final By orderAccept = By.xpath("/html/body/div/div/div[2]/div[5]/div[text()='Заказ оформлен']");

    public ForRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public ForRentPage enterDateDelivery(String date) {
        driver.findElement(fieldDateDelivery).click();
        driver.findElement(By.xpath(".//div[5]/div[text()='" + date + "']")).click();
        return this;
    }

    public ForRentPage enterRentalPeriod(String period) {
        driver.findElement(fieldRentalPeriod).click();
        driver.findElement(By.xpath(".//div[text()='" + period + "']")).click();
        return this;
    }

    public ForRentPage enterScooterColor(String color) {
        if (color.equals("черный жемчуг")) {
            driver.findElement(blackCheckbox).click();
        } else driver.findElement(greyCheckbox).click();
        return this;
    }

    public ForRentPage enterComment(String comment) {
        driver.findElement(fieldForComment).sendKeys(comment);
        return this;
    }

    public ForRentPage clickOrderButton() {
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(buttonYes));
        driver.findElement(buttonYes).click();
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(orderAccept));
        assert driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[text()='Заказ оформлен']")).isDisplayed();
        return this;
    }

}
