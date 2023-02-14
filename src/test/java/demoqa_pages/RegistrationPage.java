package demoqa_pages;

import com.codeborne.selenide.SelenideElement;
import demoqa_pages.components.CalendarComponent;
import demoqa_pages.components.RegistrationResultsModal;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement

            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userPhoneInput = $("#userNumber"),

    birthDateInput = $("#dateOfBirthInput"),

    subjectsInput = $("#subjectsInput"),

    hobbiesCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),

    stateDropdown = $("#state"),

    cityDropdown = $("#city"),

    submitButton = $("#submit");


    public RegistrationPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;

    }


    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }


    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }


    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();
        return this;
    }


    public RegistrationPage setPhoneNumber(String value) {
        userPhoneInput.setValue(value);
        return this;
    }


    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }


    public RegistrationPage setSubjects(String subject1, String subject2) {
        subjectsInput.setValue(subject1).pressEnter();
        subjectsInput.setValue(subject2).pressEnter();
        return this;
    }


    public RegistrationPage setHobbies(String hobby) {
        hobbiesCheckbox.$(byText(hobby)).click();
        return this;
    }


    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }


    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }


    public RegistrationPage setStateAndCity(String state, String city) {
        stateDropdown.click();
        stateDropdown.$(byText(state)).click();
        cityDropdown.click();
        cityDropdown.lastChild().$(byText(city)).click();
        return this;
    }


    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }


    public RegistrationPage verifyResultModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }


    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResults(key, value);
        return this;
    }

}