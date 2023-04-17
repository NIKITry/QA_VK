package task2.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OkMessagePage implements BasePage {
    private final SelenideElement containerForInputText = $(By.xpath(".//div[contains(@data-tsid,'write_msg_input')]"));
    private final SelenideElement buttonSendMessage = $(By.xpath(".//div/*[@data-tsid='button_send']"));
    private final SelenideElement textUserMessage = $(By.xpath(".//div[@class='wrap']//span[@data-tsid='message_text']/span"));
    private final SelenideElement chatElement = $(By.xpath(".//*[@data-tsid='chat' and @data-tsid-id='GROUP_CHAT']/a"));
    private final SelenideElement removeCheckBox = $(By.xpath(".//*[@data-tsid='message_root']/*[@data-l='t,selectMultiple']"));
    private final SelenideElement toolbarRemoveCheckbox = $x(".//*[@class='controls']/*[@data-tsid='control-remove']");
    private final SelenideElement buttonConfirmDelete = $(By.xpath(".//div/*[@data-tsid='confirm-primary']"));
    private final SelenideElement textForEmptyChat = $x(".//div[@class='text']/*[@key='empty-chat-text-1']");


    public OkMessagePage() {
        checkElements();
    }

    public SelenideElement getTextUserMessage() {
        return textUserMessage;
    }

    public SelenideElement getTextForEmptyChat() {
        return textForEmptyChat;
    }

    public OkMessagePage selectChat() {
        chatElement
                .shouldBe(visible).click();
        return this;
    }

    public OkMessagePage writeAndSendMessage(String message) {
        containerForInputText
                .shouldBe(visible).setValue(message);
        buttonSendMessage.
                shouldBe(visible).click();
        return this;
    }

    public OkMessagePage deleteLastMessage() {
        removeCheckBox
                .shouldBe(visible).click();
        toolbarRemoveCheckbox
                .shouldBe(visible).click();
        buttonConfirmDelete
                .shouldBe(visible).click();
        return this;
    }

    @Override
    public void checkElements() {
        chatElement.should(exist).shouldBe(visible);
    }
}
