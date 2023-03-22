package task1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OkProfilePage {

    public SelenideElement getProfileName() {
        return $(".tico.ellip");
    }
}