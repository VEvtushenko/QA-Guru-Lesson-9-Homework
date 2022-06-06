package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideGithubTest {
    @Test
    void selenideGithubTest() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/selenide");
        $(".pagehead").shouldHave(text("Selenide is a library for test automation powered by Selenium WebDriver"));

        $(linkText("selenide")).click();
        $(linkText("Wiki")).click();

        $("#repo-content-pjax-container").shouldHave(text("Welcome to the selenide wiki!"));
        $("#wiki-pages-box").$(".Link--muted").click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).shouldBe(visible);

        $(linkText("SoftAssertions")).click();
        $(withText("Or register extension inside test class:")).preceding(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
