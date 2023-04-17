package task2.tests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import task2.pages.OkProfilePage;
import task2.matchers.CustomMatcher;
import task2.pageelements.ToolbarItemPageElement;


import static com.codeborne.selenide.Condition.name;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;

public class TestLoginOk extends BaseTest {
    private static final ElementsCollection NAV_SIDE_ELEMENTS = $$x(".//div/div[contains(@class,'nav-side')]");

    private static OkProfilePage profile;
    private static ToolbarItemPageElement toolbar;

    @Test
    @DisplayName("Test: user can log in OK")
    public void userCanLogIn() {
        assertThat(loginPage.getEmail().getAttribute("id"), equalTo("field_email"));
        assertThat(loginPage.getPassword().getAttribute("id"), equalTo("field_password"));
        loginPage.getEmail().shouldHave(name("st.email"));
        loginPage.getPassword().shouldHave(name("st.password"));
        profile = loginPage.logIn(bot.getEmail(), bot.getPassword());
        toolbar = new ToolbarItemPageElement();
        assertThat(profile.getProfileNameButton().getText(), equalTo("botS23AT29 botS23AT29"));
        Integer numOfNavSideElem = Math.toIntExact(NAV_SIDE_ELEMENTS.size());
        assertThat(numOfNavSideElem, lessThanOrEqualTo(15));
        assertThat(numOfNavSideElem, CustomMatcher.isReasonableNum());
    }


    @AfterAll
    @DisplayName("Test: existing toolbar components")
    public static void signOut() {
        toolbar.getProfileIcon().shouldBe(visible);
        toolbar.clickOnProfile()
                .exitFromAccount();
    }
}
