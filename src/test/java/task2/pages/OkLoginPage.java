package task2.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage {
    private final SelenideElement email = $(By.xpath(".//input[@id='field_email']"));
    private final SelenideElement password = $(By.xpath(".//input[@id='field_password']"));
    private final SelenideElement btLogin = $(By.xpath(".//input[@type='submit']"));

    public OkLoginPage() {
        checkElements();
    }

    public SelenideElement getEmail() {
        return email;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public OkProfilePage logIn() {
        btLogin.click();
        return new OkProfilePage();
    }

    protected void checkElements() {
        password.should(exist).shouldBe(visible);
        email.should(exist).shouldBe(visible);
        btLogin.should(exist).shouldBe(visible);
    }
}
