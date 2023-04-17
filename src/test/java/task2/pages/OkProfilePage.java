package task2.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class OkProfilePage implements ProfilePageComponent, BasePage {
    private final SelenideElement profileNameButton = $(By.xpath(".//div[@class='tico ellip']"));

    public OkProfilePage() {
        checkElements();
    }

    public SelenideElement getProfileNameButton() {
        return profileNameButton;
    }

    @Override
    public void exitFromAccount() {
        new ExitFromAccountDecorator().exitFromAccount();
    }

    @Override
    public void checkElements() {
        profileNameButton.should(exist).shouldBe(visible);
    }
}
