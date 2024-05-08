package testHome;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestDemoQa extends BaseTest {

    @Test
    void checkForm() {

        registrationPage.openRegistrationPage()
                .setName(testData.firstName)
                .setLastName(testData.lastName);
        $(byText("Male")).parent().click();
        registrationPage.setDate(testData.day, testData.month, testData.year);
        $("#lastName").click();
        $("[for='hobbies-checkbox-1']").click();
        $("#userEmail").setValue(testData.email);
        $("#userNumber").setValue(testData.number);
        File file = new File("src/test/file/Выделение_143.png");
        $("#uploadPicture").uploadFile(file);
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#submit").click();

        registrationPage.verifyResult("Gender", "Male")
                .verifyResult("Date of Birth", testData.date);
    }
}
