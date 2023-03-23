package task2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkProfilePage implements ProfilePageComponent {
    private final SelenideElement profileNameButton = $(By.xpath(".//div[@class='tico ellip']"));

    public SelenideElement getProfileNameButton() {
        return profileNameButton;
    }

    @Override
    public void exitFromAccount() {
        throw new UnsupportedOperationException();
    }
}
