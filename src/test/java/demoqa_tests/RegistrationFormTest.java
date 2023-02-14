package demoqa_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulRegistrationTest() {
        String firstName = "Test";
        String lastName = "Test";
        String userEmail = "test@test.com";
        String userGender = "Other";
        String userNumber = "1234567890";
        String birthMonth = "January";
        String birthYear = "1993";
        String birthDay = "06";
        String userSubject1 = "Maths";
        String userSubject2 = "Computer Science";
        String userHobby1 = "Sports";
        String userHobby2 = "Music";
        String userPicture = "pol.jpg";
        String userAddress = "Some address";
        String userState = "NCR";
        String userCity = "Delhi";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day--0'"+ birthDay +"':not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(userSubject1).pressEnter();
        $("#subjectsInput").setValue(userSubject2).pressEnter();
        $("#hobbiesWrapper").$(byText(userHobby1)).click();
        $("#hobbiesWrapper").$(byText(userHobby2)).click();
        $("#uploadPicture").uploadFromClasspath(userPicture);
        $("#currentAddress").setValue(userAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(userState)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(userCity)).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName),
                text(userEmail), text(userNumber));
    }
}