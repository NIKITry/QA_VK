package task2.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public interface ProfilePageComponent {
    SelenideElement exitButton = $x(".//div[contains(@class,'user-delete-button')]");
    void exitFromAccount();
}
