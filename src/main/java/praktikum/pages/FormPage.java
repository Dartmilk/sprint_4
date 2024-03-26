package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

public class FormPage {
    private final WebDriver driver;
    //    Поле "Имя"
    private final By fieldName = By.xpath(".//div[2]/div[1]/input");
    //    Поле "Фамилия"
    private final By fieldLastName = By.xpath(".//div[2]/input");
    //    Поле "Адрес"
    private final By fieldAddress = By.xpath(".//div[3]/input");
    //    Поле "Станция метро"
    private final By fieldMetroStation = By.xpath(".//div[4]/div/div[1]/input");
    //    Поле "Телефон"
    private final By fieldPhone = By.xpath(".//div[5]/input");
    //    Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }


    public FormPage enterName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldName));
        driver.findElement(fieldName).sendKeys(name);
        return this;
    }

    public FormPage enterLastName(String lastName) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldLastName));
        driver.findElement(fieldLastName).sendKeys(lastName);
        return this;
    }

    public FormPage enterAddress(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldAddress));
        driver.findElement(fieldAddress).sendKeys(address);
        return this;
    }

    public FormPage enterMetroStation(String metroStation) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldMetroStation));
        driver.findElement(fieldMetroStation).click();
        driver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
        return this;
    }

    public FormPage enterPhone(String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldPhone));
        driver.findElement(fieldPhone).sendKeys(phone);
        return this;
    }

    public ForRentPage clickOnNextButton() {
        driver.findElement(nextButton).click();
        return new ForRentPage(driver);
    }
}
