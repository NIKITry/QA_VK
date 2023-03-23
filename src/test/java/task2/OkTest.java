package task2;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OkTest {
    private static final String url = "https://ok.ru";
    private static OkLoginPage loginPage;
    private static OkProfilePage profile;
    private static OkMessagePage messagePage;
    private static Bot bot;
    private final String TEST_MESSAGE = "message";
    private final String PROFILE_TEXT = "botS23AT3 botS23AT3";
    private static final SelenideElement ROOT_ELEMENT_TOOLBAR = $x(".//*[@data-l='t,navigationToolbar']");

    @BeforeAll
    public static void setUp() {
        open(url);
        bot = new Bot();
        loginPage = new OkLoginPage();
    }

    @Test
    @Order(1)
    @DisplayName("Test: user can log in OK")
    public void userCanLogIn() {
        assertTrue(loginPage.getPassword().exists());
        assertTrue(loginPage.getEmail().exists());
        loginPage.getEmail().setValue(bot.getEmail());
        loginPage.getPassword().setValue(bot.getPassword());
        loginPage.getEmail().shouldHave(name("st.email"));
        loginPage.getPassword().shouldHave(name("st.password"));
        profile = loginPage.logIn();
        assertTrue(profile.getProfileNameButton()
                .shouldHave(text(PROFILE_TEXT))
                .exists()); // exists works strangely, ask teacher
    }

    @Test
    @Order(2)
    @DisplayName("Test: going to messages and write one")
    public void userCanWriteMessage() {
        messagePage = profile.goToMessages();
        messagePage.selectChat()
                .getTextUserMessage()
                .shouldBe(hidden);
        messagePage.writeAndSendMessage(TEST_MESSAGE)
                .getTextUserMessage()
                .hover()
                .shouldHave(text(TEST_MESSAGE));
    }

    @Test
    @Order(3)
    @DisplayName("Test: delete written message")
    public void deleteMessage() {
        messagePage.deleteLastMessage()
                .getTextForEmptyChat()
                .shouldBe(visible)
                .shouldHave(text("В этом чате нет новых сообщений."));
    }



    @AfterAll
    static void exitFromAccount() {
        ToolbarItemWrapper toolbar = new ToolbarItemWrapper(ROOT_ELEMENT_TOOLBAR);
        toolbar.clickOnProfile()
                .exitFromAccount(); // не уверен, что это хороший пример пользования декоратором
    }





}
