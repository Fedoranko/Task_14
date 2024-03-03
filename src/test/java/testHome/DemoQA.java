package testHome;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        String date = "04.04.2024";
        open("automation-practice-form");
        $("#firstName").setValue(name);
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").setValue(date).pressEnter();
        $("#lastName").click();
        $("[for='hobbies-checkbox-1']").click();
        File file = new File("src/test/file/Выделение_143.png");
        $("#uploadPicture").uploadFile(file);
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#submit").click();

        String resultFIO = $("tbody > tr:nth-child(1) > td:last-child").getText();
        String resultDate = $("tbody").$(byText("Date of Birth")).sibling(0).getText();
        System.out.println(resultDate + "++++++++++++++");

        assertAll(
                () -> assertEquals(name + " " + lastName, resultFIO),
                () -> assertEquals(name + " " + lastName, resultFIO)
        );
        sleep(2000);
    }
}
