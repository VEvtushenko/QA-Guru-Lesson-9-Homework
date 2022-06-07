package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void dragAndDrop() {
        Configuration.holdBrowserOpen = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(Condition.text("B"));
    }

    @Test
    void dragAndDropWithAction() {
        Configuration.holdBrowserOpen = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b"))
                .release().perform();
        $("#column-a").shouldHave(Condition.text("B"));
    }

}
