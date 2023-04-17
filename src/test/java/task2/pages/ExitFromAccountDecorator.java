package task2.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ExitFromAccountDecorator implements ProfilePageComponent, BasePage {
    private final SelenideElement confirmButtonForExit = $x(".//input[@data-l='t,logout']");

    public ExitFromAccountDecorator() {
        checkElements();
    }

    @Override
    public void exitFromAccount() {
        exitButton.click();
        confirmButtonForExit
                .shouldBe(visible).click();
    }

    @Override
    public void checkElements() {
        exitButton.shouldBe(visible.because("Не нашлась кнопка выйти"));
    }
}
