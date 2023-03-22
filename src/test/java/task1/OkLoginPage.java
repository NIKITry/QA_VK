package task1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage {
    public SelenideElement getEmail() {
        return $("#field_email");
    }

    public SelenideElement getPassword() {
        return $("#field_password");
    }

    public SelenideElement getButtonToLogIn() {
        return $(".button-pro.__wide");
    }
}