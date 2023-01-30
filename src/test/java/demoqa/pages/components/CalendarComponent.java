package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement monthElement = $(".react-datepicker__month-select");
    private final SelenideElement yearElement = $(".react-datepicker__year-select");

    public void setDate(String month, String year, String day) {
        monthElement.selectOption(month);
        yearElement.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }



}
