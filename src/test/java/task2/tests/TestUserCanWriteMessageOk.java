package task2.tests;

import org.junit.jupiter.api.*;
import task2.pageelements.ToolbarItemPageElement;
import task2.pages.OkMessagePage;

import static com.codeborne.selenide.Condition.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class TestUserCanWriteMessageOk extends BaseTest {

    private static ToolbarItemPageElement toolbar;
    private static OkMessagePage messagePage;


    @BeforeEach
    public void init() {
        loginPage.getEmail().setValue(bot.getEmail());
        loginPage.getPassword().setValue(bot.getPassword());
        loginPage.logIn();
        toolbar = new ToolbarItemPageElement();
    }

    @Test
    public void testUserCanWriteMessage() {
        messagePage = toolbar.goToMessages();
        messagePage.selectChat()
                .getTextUserMessage()
                .shouldBe(hidden);
        assertThat(messagePage.getTextForEmptyChat().getText(), equalTo("В этом чате нет новых сообщений."));
        messagePage.writeAndSendMessage("message")
                .getTextUserMessage()
                .hover()
                .shouldHave(text("message"));
        String textMessage = messagePage.getTextUserMessage().text();
        assertThat(textMessage, containsString("message"));
    }

    @AfterEach
    public void deleteMessage() {
        messagePage.deleteLastMessage()
                .getTextForEmptyChat()
                .shouldBe(visible.because("отсутствует сообщение о том, что это пустой чат"))
                .shouldHave(text("В этом чате нет новых сообщений."));
    }
    @AfterAll
    public static void signOut() {
        toolbar.getProfileIcon().shouldBe(visible);
        toolbar.clickOnProfile()
                .exitFromAccount();
    }
}
