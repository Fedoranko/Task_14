package testHome;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
    }
}
