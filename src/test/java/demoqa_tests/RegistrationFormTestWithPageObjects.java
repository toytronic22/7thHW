package demoqa_tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;


public class RegistrationFormTestWithPageObjects extends TestBase {
    Faker faker = new Faker();

    @Tag("jenkins")
    @Test
    void successfulRegistrationTest() {

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userAddress = faker.address().streetAddress(),
                userNumber = faker.number().digits(10),
                userHobby = faker.options().option("Sports", "Reading", "Music"),
                userSubject1 = "Computer science",
                userSubject2 = "Maths",
                userGender = "Other",
                birthMonth = "January",
                birthYear = "1993",
                birthDay = "06",
                userPicture = "pol.jpg",
                userState = "NCR",
                userCity = "Delhi";


        step("Перейти на форму регистрации", () -> {
            registrationPage.openPage();
        });
        step("Выбрать пол", () -> {
            registrationPage.setGender(userGender);
        });
        step("Установить дату рождения", () -> {
            registrationPage.setBirthDate(birthDay, birthMonth, birthYear);
        });
        step("Выбрать предметы", () -> {
            registrationPage.setSubjects(userSubject1, userSubject2);
        });
        step("Выбрать хобби", () -> {
            registrationPage.setHobbies(userHobby);
        });
        step("Загрузить картинку", () -> {
            registrationPage.uploadPicture(userPicture);
        });
        step("Выбрать штат и город", () -> {
            registrationPage.setStateAndCity(userState, userCity);
        });
        step("Ввести имя", () -> {
            registrationPage.setFirstName(firstName);
        });
        step("Ввести фамилию", () -> {
            registrationPage.setLastName(lastName);
        });
        step("Ввести емэйл", () -> {
            registrationPage.setUserEmail(userEmail);
        });
        step("Ввести номер телефона", () -> {
            registrationPage.setPhoneNumber(userNumber);
        });
        step("Ввести адрес", () -> {
            registrationPage.setAddress(userAddress);
        });
        step("Подтвердить регистрацию", () -> {
            registrationPage.submitForm();
        });
        step("Проверить что окно с результатом регистрации появилось", () -> {
            registrationPage.verifyResultModalAppears();
        });
        step("Проверить что данные в таблице с результатом совпадают с введенными данными", () -> {
            registrationPage.verifyResults("Student Name", firstName + " " + lastName)
                    .verifyResults("Student Email", userEmail)
                    .verifyResults("Gender", userGender)
                    .verifyResults("Mobile", userNumber)
                    .verifyResults("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                    .verifyResults("Subjects", userSubject1 + ", " + userSubject2)
                    .verifyResults("Hobbies", userHobby)
                    .verifyResults("Picture", userPicture)
                    .verifyResults("Address", userAddress)
                    .verifyResults("State and City", userState + " " + userCity);
        });
    }

}