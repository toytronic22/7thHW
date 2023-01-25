package mainpck.testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userGender = getRandomValue("Male", "Female", "Other");
    public String[] dayMonthYear = getRandomDate();
    public String dateOfBirth = String.format("%s %s,%s", dayMonthYear[0], dayMonthYear[1], dayMonthYear[2]);
    public String userCellNumber = String.valueOf(faker.number().numberBetween(9151111111L, 9269999999L));
    public String hobby = getRandomValue("Sports", "Reading", "Music");
    public String subject = getRandomValue("Math", "Chemistry", "Physics", "Computer Science", "English", "History");
    public String filePath = "images/File.png";
    public String fileName = "File.png";
    public String address = faker.address().fullAddress();
    public String state = getRandomValue("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getCity();


    private String getRandomValue(String... initialValues) {
        return faker.options().option(initialValues);
    }

    private String[] getRandomDate() {
        return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).format(faker.date().birthday(18, 70)).split(" ");
    }

    private String getCity() {
        String cityItem = null;

        if (state.equals("NCR")) {
            cityItem = getRandomValue("Delhi", "Gurgaon", "Noida");
        }

        if (state.equals("Uttar Pradesh")) {
            cityItem = getRandomValue("Agra", "Lucknow", "Merrut");
        }

        if (state.equals("Haryana")) {
            cityItem = getRandomValue("Karnal", "Panipat");
        }

        if (state.equals("Rajasthan")) {
            cityItem = getRandomValue("Jaipur", "Jaiselmer");
        }

        return cityItem;
    }

}
