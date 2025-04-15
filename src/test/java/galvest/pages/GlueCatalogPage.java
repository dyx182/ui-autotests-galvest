package galvest.pages;


import com.codeborne.selenide.SelenideElement;
import galvest.pages.base_pages.BaseCatalogPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;


import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;


public class GlueCatalogPage extends BaseCatalogPage {

    Header header = new Header();

    //TODO Заменить локатор
    private final SelenideElement titlePageText = $x("//div[2]/ul/li[3]/span");

    //текст элемнета
    public static String savedTitleText;


    public Header getHeader() {
        return header;
    }

    @Step("Проверка заголовка страницы")
    public GlueCatalogPage assertTitlePage() {
        titlePageText.shouldHave(text("Клеи"), Duration.ofSeconds(5));
        return this;
    }
    @Step("Добавление элемента в корзину и получение его названия")
    public GlueCatalogPage addGoodElement(int index) {
        getCatalogElement(index).addElement();
        savedTitleText = getCatalogElement(index).getTextTitleElement();
        return this;
    }
    @Step("Првоерка количества элементов")
    public GlueCatalogPage assertsUniqueElements() {
        Assertions.assertTrue(checkingTheTUiquenessOfElements());
        return this;
    }
}
