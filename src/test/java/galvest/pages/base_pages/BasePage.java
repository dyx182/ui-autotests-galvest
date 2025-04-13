package galvest.pages.base_pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;


public class BasePage {

    private final SelenideElement sendMessage = $x("//jdiv[@class='hoverArea__cMvXG']");

    public WebElement getSendMessage() {
        return sendMessage;
    }

    protected void fillingOutInputFields(String value, WebElement input) {
        try {
            for (char c : value.toCharArray()) {
                input.sendKeys(String.valueOf(c));
                Thread.sleep(30);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}