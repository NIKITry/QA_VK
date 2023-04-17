package task2.pageelements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import task2.pages.OkMessagePage;
import task2.pages.ProfilePageComponent;
import task2.pages.OkProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ToolbarItemPageElement {

    private static final SelenideElement ROOT_ELEMENT_TOOLBAR = $x(".//*[@data-l='t,navigationToolbar']");
    private static final By PROFILE_ICON = By.xpath(".//div[contains(@class,'toolbar_dropdown_w')]");
    private static final By MESSAGE_BUTTON = By.xpath(".//div[@id='msg_toolbar_button']");


    public ProfilePageComponent clickOnProfile() {
        ROOT_ELEMENT_TOOLBAR.$(PROFILE_ICON)
                .shouldBe(visible)
                .click();
        return new OkProfilePage();
    }

    public SelenideElement getProfileIcon() {
        return ROOT_ELEMENT_TOOLBAR.$(PROFILE_ICON);
    }

    public SelenideElement getMsgButton() {
        return ROOT_ELEMENT_TOOLBAR.$(MESSAGE_BUTTON);
    }

    public OkMessagePage goToMessages() {
        getMsgButton()
                .shouldBe(visible)
                .click();
        return new OkMessagePage();
    }
}
