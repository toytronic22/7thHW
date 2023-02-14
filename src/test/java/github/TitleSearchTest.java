package github;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;

public class TitleSearchTest {
    @Test
    void successfulSearchTest(){
        open("https://github.com");
        $(".HeaderMenu--logged-out").$$("ul li").findBy(text(" Solutions ")).hover()
                .$(".HeaderMenu-dropdown").$$("ul li").findBy(text(" Enterprise")).hover().click();
        $("h1").shouldHave(text("Build like the best"));

    }
}