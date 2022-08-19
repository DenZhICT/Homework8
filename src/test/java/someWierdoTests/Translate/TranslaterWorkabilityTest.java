package someWierdoTests.Translate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import someWierdoTests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TranslaterWorkabilityTest extends TestBase {
    @CsvSource ( value = {
            "Работа, Work",
            "Смерть, Death"
    }
    )
    @ParameterizedTest(name = "При написании в переводчик слова {0} выдаст перевод {1}")
    void checkTrans(String testData,String exceptionData){
        open("https://translate.yandex.ru");
        $("#fakeArea").setValue(testData);
        $("#translation").shouldHave(text(exceptionData));
    }
}
