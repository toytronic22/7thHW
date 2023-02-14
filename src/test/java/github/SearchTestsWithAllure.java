package github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Tag("github")
public class SearchTestsWithAllure {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int ISSUE_NUMBER = 80;


    @Test
    void checkIssueWithListener() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE_NUMBER)).should(exist);
    }

    @Test
    void checkIssueThruLambdaStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Перейти на сайт", () -> {
            open("https://github.com");
        });
        step("Найти репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Перейти в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Перейти на таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверить наличие Issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(exist);
        });

    }


    @Severity(SeverityLevel.BLOCKER)
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Test
    void checkIssueWithAnnotatedSteps() {

        AnnotatedSteps steps = new AnnotatedSteps();

        steps.openBaseUrl();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.goToIssueTab();
        steps.verifyIssueNumber(ISSUE_NUMBER);

    }


}