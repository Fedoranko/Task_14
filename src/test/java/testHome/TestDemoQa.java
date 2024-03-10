package testHome;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TestDemoQa extends BaseTest {

    @Test
    void checkForm() {
        String name = "Polina";
        String lastName = "house";
        String email = "teatF@mail.ru";
        String number = "9118883333";
//        String date = "22 April,2015";
        String month = "April";
        String year = "2022";
        String day = "26";

        registrationPage.openRegistrationPage()
                .setName(name)
                .setLastName(lastName);
        $(byText("Male")).parent().click();
        registrationPage.setDate(day, month, year);
        $("#lastName").click();
        $("[for='hobbies-checkbox-1']").click();
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(number);
        File file = new File("src/test/file/Выделение_143.png");
        $("#uploadPicture").uploadFile(file);
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#submit").click();

        registrationPage.verifyResult("Gender", "Male")
                .verifyResult("Date of Birth", "26 April,2022");
        sleep(2000);
    }
}
