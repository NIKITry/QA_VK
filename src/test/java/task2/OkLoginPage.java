package task2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class OkLoginPage {
    private final SelenideElement email = $(By.xpath(".//input[@id='field_email']"));
    private final SelenideElement password = $(By.xpath(".//input[@id='field_password']"));
    private final SelenideElement btLogin = $(By.xpath(".//input[@type='submit']"));
    public SelenideElement getEmail() {
        return email;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public OkLoginPage logIn() {
        if (email.getValue().isEmpty() || password.getValue().isEmpty()) {
            throw new IllegalArgumentException("fill the email or password");
        }
        btLogin.click();
        return this;
    }

}
