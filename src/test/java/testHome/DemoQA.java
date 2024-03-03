package testHome;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class DemoQA {
    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkForm() {
        String name = "Polina";
        String lastName = "house";
        String email = "teatF@mail.ru";
        String number = "9118883333";
        String date = "22 April,2015";
        open("automation-practice-form");
        $("#firstName").setValue(name);
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(number);
        actions().click($("#dateOfBirthInput")).click().click().sendKeys(date).perform();
        $("#dateOfBirthInput").pressEnter();
        $("#lastName").click();
        $("[for='hobbies-checkbox-1']").click();
        File file = new File("src/test/file/Выделение_143.png");
        $("#uploadPicture").uploadFile(file);
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#submit").click();

        String resultFIO = $("tbody > tr:nth-child(1) > td:last-child").getText();
        SelenideElement element = $("tbody").$(byText("Date of Birth")).sibling(0);
        String resultDate = element.getText();
        String resultFileName = $("tbody").$(byText("Picture")).sibling(0).getText();

        assertAll(
                () -> assertEquals(name + " " + lastName, resultFIO),
                () -> assertEquals(date, resultDate),
                () -> assertEquals("Выделение_143.png",resultFileName)
        );
        sleep(2000);
    }
}
