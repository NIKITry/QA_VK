package task2;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class OkTest {
    private static final String url = "https://ok.ru";
    private static OkLoginPage loginPage;
    private static OkProfilePage profile;
    private static OkMessagePage messagePage;
    private static Bot bot;
    private final String testMessage = "message";
    private final String profileText = "botS23AT3 botS23AT3";
    private static final SelenideElement profileIcon = $x(".//div[contains(@class,'toolbar_dropdown_w')]"); // might be taken away from the test with some pattern
    private static final SelenideElement exitButton = $x(".//div[contains(@class,'user-delete-button')]");
    private static final SelenideElement confirmButtonForExit = $x(".//input[@data-l='t,logout']");

    @BeforeAll
    public static void setUp() {
        loginPage = new OkLoginPage();
        profile = new OkProfilePage();
        messagePage = new OkMessagePage();
        bot = new Bot();
        open(url);
    }

    @Test
    @Order(1)
    @DisplayName("Test: elements existing and visibility")
    public void isExistsOnLoginPage() {
        loginPage.getPassword().exists();
        loginPage.getEmail().exists();
    }

    @Test
    @Order(2)
    @DisplayName("Test: user can log in OK")
    public void userCanLogIn() {
        loginPage.getEmail().setValue(bot.getEmail());
        loginPage.getPassword().setValue(bot.getPassword());
        loginPage.getEmail().shouldHave(name("st.email"));
        loginPage.getPassword().shouldHave(name("st.password"));
        loginPage.logIn();
        profile.getProfileNameButton()
                .shouldHave(text(profileText))
                .exists();
    }

    @Test
    @Order(4)
    @DisplayName("Test: going to messages and write one")
    public void userCanWriteMessage() {
        profile.goToMessages();
        messagePage.selectChat()
                .getTextUserMessage()
                .shouldBe(hidden);
        messagePage.writeAndSendMessage(testMessage)
                .getTextUserMessage()
                .hover()
                .shouldHave(text(testMessage));
    }

    @Test
    @Order(5)
    @DisplayName("Test: delete written message")
    public void deleteMessage() {
        messagePage.deleteLastMessage()
                .getTextForEmptyChat()
                .shouldBe(visible)
                .shouldHave(text("В этом чате нет новых сообщений."));
    }



    @AfterAll
    static void exitFromAccount() {
        profileIcon.click();
        exitButton.click();
        confirmButtonForExit.click();
    }





}
