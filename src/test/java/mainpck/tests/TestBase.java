package mainpck.tests;

import com.codeborne.selenide.Configuration;
import mainpck.pages.FormPage;
import org.junit.jupiter.api.BeforeAll;

public abstract class TestBase {
    FormPage formPage = new FormPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1980x1020";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;
    }
}
