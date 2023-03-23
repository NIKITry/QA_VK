package task2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class ToolbarItemWrapper {
    private final SelenideElement rootItem;
    private static final By PROFILE_ICON = By.xpath(".//div[contains(@class,'toolbar_dropdown_w')]");
    public ToolbarItemWrapper(SelenideElement rootItem) {
        this.rootItem = rootItem;
    }

    public ProfilePageComponent clickOnProfile() { // в чем смысл враппера если все равно надо указывать, на что нажимаем (только в вынесении общего?)
        rootItem.$(PROFILE_ICON)
                .shouldBe(visible)
                .click();
        return new ExitFromAccountDecorator();
    }


}
