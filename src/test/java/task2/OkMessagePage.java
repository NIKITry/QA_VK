package task2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OkMessagePage {
    private final SelenideElement textInputMessage = $(By.xpath(".//div[contains(@data-tsid,'write_msg_input')]/div"));
    private final SelenideElement containerForInputText = $(By.xpath(".//div[contains(@data-tsid,'write_msg_input')]"));
    private final SelenideElement buttonSendMessage = $(By.xpath(".//div/*[@data-tsid='button_send']"));
    private final SelenideElement textUserMessage = $(By.xpath(".//div[@class='wrap']//span[@data-tsid='message_text']"));
    private final SelenideElement chatElement = $(By.xpath(".//*[@data-tsid='chat' and @data-tsid-id='GROUP_CHAT']/a"));
    private final SelenideElement removeCheckBox = $(By.xpath(".//*[@data-tsid='message_root']/*[@data-l='t,selectMultiple']"));
    private final SelenideElement toolbarRemoveCheckbox = $x(".//*[@class='controls']/*[@data-tsid='control-remove']");
    private final SelenideElement buttonConfirmDelete = $(By.xpath(".//div/*[@data-tsid='confirm-primary']"));
    private final SelenideElement textForEmptyChat = $x(".//div[@class='text']/*[@key='empty-chat-text-1']");
    public SelenideElement getTextInputMessage() {
        return textInputMessage;
    }

    public SelenideElement getRemoveCheckBox() {
        return removeCheckBox;
    }

    public SelenideElement getTextUserMessage() {
        return textUserMessage;
    }

    public SelenideElement getButtonSendMessage() {
        return buttonSendMessage;
    }

    public SelenideElement getTextForEmptyChat() {
        return textForEmptyChat;
    }

    public OkMessagePage selectChat() {
        chatElement.click();
        return this;
    }

    public OkMessagePage writeAndSendMessage(String message) {
        containerForInputText.setValue(message);
        buttonSendMessage.click();
        return this;
    }

    public OkMessagePage deleteLastMessage() {
        removeCheckBox.click();
        toolbarRemoveCheckbox.click();
        buttonConfirmDelete.click();
        return this;
    }

}
