package github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AnnotatedSteps {

    @Step("Перейти на сайт")
    public void openBaseUrl() {

        open("https://github.com");
    }

    @Step("Найти репозиторий {repo}")
    public void  searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo).pressEnter();
    }

    @Step("Перейти в репозиторий {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Перейти на таб Issues")
    public void goToIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие Issue с номером {num}")
    public void verifyIssueNumber(int num) {
        $(withText("#" + num)).should(exist);
    }
}