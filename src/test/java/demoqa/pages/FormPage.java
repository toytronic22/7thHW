package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ModalComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ModalComponent modalComponent = new ModalComponent();
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userGender = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbyPicker = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement userState = $("#state");
    private final SelenideElement userCity = $("#city");
    private final SelenideElement submitBtn = $("#submit");


    public FormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public FormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public FormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public FormPage setUserGender(String value) {
        userGender.$(byText(value)).click();
        return this;
    }

    public FormPage setUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }

    public FormPage setDate(String month, String year, String day) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    public FormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public FormPage setHobby(String hobby) {
        hobbyPicker.$(byText(hobby)).click();
        return this;
    }

    public FormPage setPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    public FormPage setAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public FormPage setState(String state) {
        userState.click();
        userState.$(byText(state)).click();
        return this;
    }

    public FormPage setCity(String city) {
        userCity.click();
        userCity.$(byText(city)).click();
        return this;
    }

    public FormPage pressSubmitBtn() {
        submitBtn.click();
        return this;
    }

    public FormPage verifyModal() {
        modalComponent.verifyModal();
        return this;
    }

    public FormPage verifyModalResults(String key, String value) {
        modalComponent.verifyModalResults(key, value);
        return this;
    }

    public FormPage closeModal() {
        modalComponent.closeModal();
        return this;
    }


    public void formValidation() {

        $("#closeLargeModal").click();
    }
}
