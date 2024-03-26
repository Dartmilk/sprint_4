package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.pages.ForRentPage;
import praktikum.pages.MainPage;
import praktikum.pages.FormPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;


    public OrderTest(String name, String lastName, String address, String metro, String phone, String date,
                     String period, String color, String comment) {

        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;

    }

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Дмитрий", "Лазарев", "Мавзолей", "Черкизовская", "89566478338", "28", "сутки",
                        "черный жемчуг", "Прекрасный сервис"},
                {"Василий", "Пупкин", "Садовод", "Сокольники", "89556434212", "29", "двое суток",
                        "серая безысходность", "Сервис прекрасный"},
        };
    }

    @Test
    public void headerButtonTest() {
        WebDriver driver = driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        FormPage order = main.clickHeaderButton();
        order.enterName(name)
                .enterLastName(lastName)
                .enterAddress(address)
                .enterMetroStation(metro)
                .enterPhone(phone);
        ForRentPage forRentPage = order.clickOnNextButton();
        forRentPage.enterDateDelivery(date)
                .enterRentalPeriod(period)
                .enterScooterColor(color)
                .enterComment(comment)
                .clickOrderButton();


    }

    @Test
    public void footerButtonTest() {
        WebDriver driver = driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        FormPage order = main.clickFooterButton();
        order.enterName(name)
                .enterLastName(lastName)
                .enterAddress(address)
                .enterMetroStation(metro)
                .enterPhone(phone);
        ForRentPage forRentPage = order.clickOnNextButton();
        forRentPage.enterDateDelivery(date)
                .enterRentalPeriod(period)
                .enterScooterColor(color)
                .enterComment(comment)
                .clickOrderButton();


    }
}
