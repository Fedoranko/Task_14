package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.components.ModelWindow;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    SelenideElement
            firstName = $("#firstName"),
            lastNameElement = $("#lastName");
    Calendar calendar = new Calendar();
    ModelWindow modelWindow  = new ModelWindow();

    public RegistrationPage openRegistrationPage() {
        open("automation-practice-form");
        return this;
    }

    public RegistrationPage setName(String name) {
        firstName.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameElement.setValue(lastName);
        return this;
    }

    public RegistrationPage setDate (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        modelWindow.verifyResult(key, value);
        return this;
    }
}
