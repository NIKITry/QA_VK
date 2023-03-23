package task2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class OkProfilePage implements ProfilePageComponent {
    private final SelenideElement msgButton = $(By.xpath(".//div[@id='msg_toolbar_button']"));
    private final SelenideElement profileNameButton = $(By.xpath(".//div[@class='tico ellip']"));

    public SelenideElement getMsgButton() {
        return msgButton;
    }

    public SelenideElement getProfileNameButton() {
        return profileNameButton;
    }



    public OkMessagePage goToMessages() {
        msgButton.click();
        return new OkMessagePage();
    }

    @Override
    public void exitFromAccount() {
        throw new UnsupportedOperationException();
    }
}
