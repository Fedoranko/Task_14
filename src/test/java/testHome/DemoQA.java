package testHome;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

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
        String email = "teatF@mail.ru";
        open("automation-practice-form");
        $("#firstName").setValue(name);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-1']").click();
        $("[for='hobbies-checkbox-1']").click();

        sleep(2000);
    }
}
