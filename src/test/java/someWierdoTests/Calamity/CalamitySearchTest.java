package someWierdoTests.Calamity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import someWierdoTests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CalamitySearchTest extends TestBase {
    @ValueSource(strings = {"Supreme Calamitas", "Celestial Tracers", "Celestus"})
    @ParameterizedTest(name = "Открытие страницы объекта: {0} в Calamity Mod Wiki")
    void findObject(String testData){
        open("https://calamitymod.wiki.gg/wiki/Calamity_Mod_Wiki");
        $("#searchInput").setValue(testData);
        $(".suggestions").find(byText(testData)).click();
        $("#firstHeading").shouldHave(text(testData));
    }
}
