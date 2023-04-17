package task2.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import task2.bots.Bot;
import task2.pages.OkLoginPage;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    protected static final String baseUrl = "https://ok.ru";

    protected static Bot bot;
    protected static OkLoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = baseUrl;
        open("/");
        bot = new Bot();
        loginPage = new OkLoginPage();
    }

    @AfterAll
    public static void cleanUp() {

    }
}
