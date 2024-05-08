package testHome;

import com.github.javafaker.Faker;

import java.util.Locale;

import static org.apache.commons.lang3.RandomStringUtils.random;


public class TestData {
    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String number = faker.phoneNumber().subscriberNumber(11);
    String month = Months.randomMonth();
    String day = randomDay();
    String year = faker.number().numberBetween(1900, 2100) + "";
    String date = String.format("%s %s,%s", day, month, year);
    public String randomDay() {
        int day = faker.number().numberBetween(1, 28);
        if (day < 10) {
            return "0" + day;
        } else {
            return String.valueOf(day);
        }
    }
}
