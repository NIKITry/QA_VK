package task2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class ToolbarItemWrapper {
    private final SelenideElement rootItem;
    private static final By PROFILE_ICON = By.xpath(".//div[contains(@class,'toolbar_dropdown_w')]");

    private static final By MESSAGE_BUTTON = By.xpath(".//div[@id='msg_toolbar_button']");

    public ToolbarItemWrapper(SelenideElement rootItem) {
        this.rootItem = rootItem;
    }

    public ProfilePageComponent clickOnProfile() { // в чем смысл враппера если все равно надо указывать, на что нажимаем (только в вынесении общего?)
        rootItem.$(PROFILE_ICON)
                .shouldBe(visible)
                .click();
        return new ExitFromAccountDecorator();
    }

    public SelenideElement getProfileIcon() {
        return rootItem.$(PROFILE_ICON);
    }

    public SelenideElement getMsgButton() {
        return rootItem.$(MESSAGE_BUTTON);
    }

    public OkMessagePage goToMessages() {
        getMsgButton().click();
        return new OkMessagePage();
    }


}
