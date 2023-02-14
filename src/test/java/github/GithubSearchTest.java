package github;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GithubSearchTest {

    @Test
    void succesfullSearchTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box button").click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").should(exist);
    }
}