package task2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ExitFromAccountDecorator implements ProfilePageComponent {
    private final SelenideElement confirmButtonForExit = $x(".//input[@data-l='t,logout']");
    @Override
    public void exitFromAccount() {
        exitButton.click();
        confirmButtonForExit.click();
    }
}
