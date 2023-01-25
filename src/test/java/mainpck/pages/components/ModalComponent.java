package mainpck.pages.components;

import com.codeborne.selenide.SelenideElement;
import mainpck.pages.FormPage;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {
    private final SelenideElement modal = $(".modal-content");
    private final SelenideElement table = $(".table-responsive");
    private SelenideElement closeBtn = $("#closeLargeModal");

    public void verifyModal() {
        modal.should(appear);
    }

    public ModalComponent verifyModalResults(String key, String value) {
        table.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public void closeModal() {
        closeBtn.click();
    }
}
