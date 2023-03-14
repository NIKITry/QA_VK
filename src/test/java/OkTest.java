import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class OkTest{
    private final String PASSWORD = "cxm62qdRIEO";
    private final String EMAIL = "teddi2x2@gmail.com";


    @Test
    public void userCanLogIn() {
        open("https://ok.ru");
        OkLoginPage results = new OkLoginPage();
        results.getEmail().setValue(EMAIL);
        results.getPassword().setValue(PASSWORD);
        results.getButtonToLogIn().click();
        OkProfilePage profile = new OkProfilePage();
        profile.getProfileName().shouldHave(Condition.text("Егор Топорков"));
    }
}
